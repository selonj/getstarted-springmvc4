#Get Started Spring WebMVC4 Using XML Configuration#

###1.Add spring-webmvc dependencies in [build.gradle](build.gradle).###
```groovy
compile 'org.springframework:spring-webmvc:4.1.6.RELEASE'
```

###2.Register DispatchServlet in [web.xml](src/main/webapp/WEB-INF/web.xml)###
```xml
<servlet>
    <servlet-name>spring-webmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring-webmvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>spring-webmvc</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

###3.Enable Spring Mvc Capabilities and register ViewResolvers in [spring-webmvc.xml](src/main/webapp/WEB-INF/spring-webmvc.xml).###
```xml
<mvc:annotation-driven/>
<mvc:view-resolvers>
    <mvc:jsp prefix="/"/>
</mvc:view-resolvers>
```

###4.Using <context:component-scan> to discovery Controllers in [spring-webmvc.xml](src/main/webapp/WEB-INF/spring-webmvc.xml).###

```xml
<context:component-scan base-package="com.selonj"/>
```