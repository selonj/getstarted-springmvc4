package com.selonj.config;

import java.io.File;
import java.io.IOException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by L.x on 16-2-18.
 */
@ComponentScan("com.selonj")
@EnableWebMvc
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp().prefix("/");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter() {{
      setSupportedMediaTypes(asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
    }});
  }

  @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/classpath/**").addResourceLocations(classpath("/META-INF/resources/"));
    registry.addResourceHandler("/resources/filesystem/**").addResourceLocations(location(new File("etc")));
  }

  private String classpath(String uri) {
    return String.format("classpath:%s", uri);
  }

  private String location(File file) {
    return file.toURI().toString();
  }
}
