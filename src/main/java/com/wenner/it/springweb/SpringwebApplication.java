package com.wenner.it.springweb;

import com.wenner.it.springweb.config.MySpringWebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class SpringwebApplication {

    public static void main(String[] args) {
        new SpringwebApplication().startTomcat();
    }

    private void startTomcat() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8017);
        tomcat.getConnector();
        // 创建Web上下文
        Context context = tomcat.addContext("", null);

        try{
            DispatcherServlet dispatcherServlet = new DispatcherServlet(this.createWebApplication(context.getServletContext()));

            Wrapper servlet = tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/*");

            tomcat.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebApplicationContext createWebApplication(ServletContext servletContext)  {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MySpringWebConfig.class);
        webApplicationContext.setServletContext(servletContext);
        webApplicationContext.refresh();
        webApplicationContext.registerShutdownHook();
        return webApplicationContext;

    }
}
