package com.accolite.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // declare root context configuration classes
        return new Class<?>[]{  };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // declare servlet context configuration classes
        return new Class<?>[]{ DispatcherConfigClass.class };
    }

    @Override
    protected String[] getServletMappings() {
        // mapping of DispatcherServlet
        return new String[]{"/"};
    }
}
