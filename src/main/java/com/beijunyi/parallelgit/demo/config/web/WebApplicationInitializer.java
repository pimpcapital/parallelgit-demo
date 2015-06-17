package com.beijunyi.parallelgit.demo.config.web;

import javax.annotation.Nonnull;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import net.jawr.web.JawrConstant;
import net.jawr.web.servlet.JawrServlet;

@WebListener
public class WebApplicationInitializer implements ServletContextListener {

  private static final Class<JawrServlet> JAWR_SERVLET = JawrServlet.class;
  private static final String JAWR_PROPERTIES = "/jawr.properties";

  private static void configureJawrForType(@Nonnull ServletContext context, @Nonnull String type) {
    ServletRegistration.Dynamic sr = context.addServlet(JAWR_SERVLET.getSimpleName() + "-" + type, JAWR_SERVLET);
    sr.setInitParameter("configLocation", JAWR_PROPERTIES);
    sr.setInitParameter("type", type);
    sr.addMapping("*." + type);
    sr.setLoadOnStartup(1);
  }

  @Override
  public void contextInitialized(ServletContextEvent evt) {
    ServletContext context = evt.getServletContext();
    configureJawrForType(context, JawrConstant.JS_TYPE);
    configureJawrForType(context, JawrConstant.CSS_TYPE);

  }

  @Override
  public void contextDestroyed(ServletContextEvent evt) {
  }
}
