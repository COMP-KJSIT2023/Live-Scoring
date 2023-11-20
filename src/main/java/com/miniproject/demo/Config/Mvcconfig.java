package com.miniproject.demo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class Mvcconfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login_form");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/Viewer/index").setViewName("Viewer page/index");
        registry.addViewController("/Viewer/upcoming").setViewName("Viewer page/upcoming");
        registry.addViewController("/Scorer/cricket").setViewName("Scorer page/cricket");
        registry.addViewController("/Scorer/football").setViewName("Scorer page/football");
        registry.addViewController("/Scorer/batfirst").setViewName("Scorer page/batting");
        registry.addViewController("/Scorer/batsecond").setViewName("Scorer page/battingSecondInnings");
        registry.addViewController("/Scorer/bowlfirst").setViewName("Scorer page/firstInningsBowler");
        registry.addViewController("/Scorer/bowlsecond").setViewName("Scorer page/secondInningsBowler");
    };

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("src/main/resources/templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

}
