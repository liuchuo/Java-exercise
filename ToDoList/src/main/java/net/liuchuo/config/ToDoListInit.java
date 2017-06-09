package net.liuchuo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ToDoListInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
