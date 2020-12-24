package com.linkedbear.spring.withdao.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
            LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy年MM月DD日"));
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            return Date.from(zonedDateTime.toInstant());
        }
        return null;
    }
}
