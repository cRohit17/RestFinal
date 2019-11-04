package com.spring.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



//web.xml
@Component
public class WebAppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext container) {
      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
      rootContext.register(WebSpringBeanJavaConfig.class); //might change this one
      container.addListener(new ContextLoaderListener(rootContext));
      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/"); //this one.
  }
}

