/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.legend.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * configuration for Thymeleaf
 * @author dell
 * @Time 2017-04-12 16:24:53
 */

/**
 * 可以使用默认配置,这样ThymeleafConfiguration类可以删除掉
 */
//@Configuration
public class ThymeleafConfiguration {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver() {
        //这里使用SpringResourceTemplateResolver,不能使用ServletContextTemplateResolver
        //否则会出现templates/*.html找不到的情况
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

//    @Bean
//    public ViewResolver thymeleafViewResolver()
//    {
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
////        thymeleafViewResolver.setViewNames(new String[]{"*.html"});
//        thymeleafViewResolver.setOrder(0);
//        thymeleafViewResolver.setCharacterEncoding("UTF-8");
//        return thymeleafViewResolver;
//    }

//    @Bean
//    public InternalResourceViewResolver resourceViewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setPrefix("/templates/");
//        bean.setSuffix(".html");
//        return bean;
//    }

}
