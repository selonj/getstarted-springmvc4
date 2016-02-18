#Get Started Spring WebMVC4 Using Annotation Configuration#

###1.Add spring-webmvc dependencies in [build.gradle](build.gradle).###
```groovy
compile 'org.springframework:spring-webmvc:4.1.6.RELEASE'
```

###2.Register DispatchServlet in [web.xml](src/main/webapp/WEB-INF/web.xml) and using *contextClass* parameter to specify  AnnotationConfigWebApplicationContext ###
```xml
<servlet>
    <servlet-name>spring-webmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextClass</param-name>
        <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.selonj.config.SpringWebMvcConfig</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>spring-webmvc</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

###3.Enable Spring Mvc Capabilities by *@EnableWebMvc* annotation and extends *WebMvcConfigurerAdapter* to register ViewResolvers in [SpringWebMvcConfig.java](src/main/java/com/selonj/config/SpringWebMvcConfig.java).###
```java
@EnableWebMvc
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/");
    }
}
```

###4.Using *@ComponentScan* annotation to discovery Controllers in [SpringWebMvcConfig.java](src/main/java/com/selonj/config/SpringWebMvcConfig.java).###

```xml
@ComponentScan("com.selonj")
```

###5.override *configureMessageConverters* method to register JsonMessageConverter in [SpringWebMvcConfig.java](src/main/java/com/selonj/config/SpringWebMvcConfig.java).###

```java
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter() {{
        setSupportedMediaTypes(asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
    }});
}
```