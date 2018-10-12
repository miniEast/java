package com.example.validata.exception;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

//@ControllerAdvice
@Configuration
public class GlobalException implements HandlerExceptionResolver {

    /**
     * java.lang.ArithmeticException
     */
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView arithmeticExceptionHander(Exception e){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("error",e.toString());
//        modelAndView.setViewName("error2");
//        return modelAndView;
//
//    }

//
//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.put("java.lang.ArithmeticException", "error2");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ArithmeticException) {
            modelAndView.addObject("error", e);
            modelAndView.setViewName("error2");
        }
        return modelAndView;
    }
}

