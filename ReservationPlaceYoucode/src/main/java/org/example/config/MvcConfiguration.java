package org.example.config;

import org.example.DAO.UserDAO;
import org.example.DAO.UserDaoImpl;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//il scan le code ou il est dans un package(compannentscan)
@Configuration
@ComponentScan(basePackages="org.example")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	//Bean annotation de config
	@Bean
	public ViewResolver getViewResolver(){
		//instonciation
		//get view .jsp
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	@Override
	//chemain du resource
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
}
