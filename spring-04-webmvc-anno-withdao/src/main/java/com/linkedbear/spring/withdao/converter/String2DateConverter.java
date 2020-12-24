package com.linkedbear.spring.withdao.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    
    @Override
    public Date convert(String source) {
        if (StringUtils.hasText(source)) {
            /*
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            try {
                return dateFormat.parse(source);
            } catch (ParseException e) {
                return null;
            }
            */
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(source, dateTimeFormatter);
            return Date.from(zonedDateTime.toInstant());
        }
        return null;
    }
}
