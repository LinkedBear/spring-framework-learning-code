package com.linkedbear.spring.aop.h_imitate.processor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AopProxyPostProcessor implements BeanPostProcessor, BeanFactoryAware {
    
    private ConfigurableListableBeanFactory beanFactory;
    
    private Map<PointcutExpression, Method> beforePointcutMethodMap = new ConcurrentHashMap<>();
    
    @PostConstruct
    public void initAspectAndPointcuts() {
        // 取到BeanFactory中的所有BeanDefinition
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // 检查BeanDefinition对应的class上是否标注了@Aspect注解
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (!StringUtils.hasText(beanClassName)) {
                continue;
            }
            Class<?> clazz = ClassUtils.resolveClassName(beanClassName, ClassUtils.getDefaultClassLoader());
            if (!clazz.isAnnotationPresent(Aspect.class)) {
                continue;
            }
            // 到此为止，说明当前BeanDefinition对应的bean是一个切面类，解析方法
            PointcutParser pointcutParser = PointcutParser.
                    getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
            ReflectionUtils.doWithMethods(clazz, method -> {
                Before before = method.getAnnotation(Before.class);
                if (before != null) {
                    String pointcutExp = before.value();
                    // 借助pointcutParser解析切入点表达式
                    try {
                        PointcutExpression pointcutExpression = pointcutParser.parsePointcutExpression(pointcutExp);
                        beforePointcutMethodMap.put(pointcutExpression, method);
                    } catch (Exception e) {
                    	// 不支持
                        e.printStackTrace();
                    }
                }
                // 其余注解同。。。
            }, method -> {
                return method.isAnnotationPresent(Before.class)
                        || method.isAnnotationPresent(After.class)
                        || method.isAnnotationPresent(AfterReturning.class)
                        || method.isAnnotationPresent(AfterThrowing.class)
                        || method.isAnnotationPresent(Around.class);
            });
        }
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 切面不增强
        if (bean.getClass().isAnnotationPresent(Aspect.class)) {
            return bean;
        }
        // 检查类是否能被切入点表达式切入
        List<Method> proxyMethods = new ArrayList<>();
        beforePointcutMethodMap.forEach((pointcutExpression, method) -> {
            if (pointcutExpression.couldMatchJoinPointsInType(bean.getClass())) {
                proxyMethods.add(method);
            }
        });
        // 没有能匹配的切面，则直接返回普通对象
        if (proxyMethods.isEmpty()) {
            return bean;
        }
        // 需要织入通知
        return Enhancer.create(bean.getClass(), (MethodInterceptor) (proxy, method, args, methodProxy) -> {
            // 依次执行前置通知
            for (Method proxyMethod : proxyMethods) {
                Object aspectBean = beanFactory.getBean(proxyMethod.getDeclaringClass());
                proxyMethod.invoke(aspectBean);
            }
            return methodProxy.invokeSuper(proxy, args);
        });
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
