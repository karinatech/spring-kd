package com.cybertek.configs;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHourss;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:applicatiioin.properties")
public class ApplicationConfig {
    @Bean
    public Java java(){
        return new Java(extraSessions());
    }
@Bean
    public Selenium selenium() {
    return new Selenium();
}
        @Bean
    public ExtraSessions extraSessions(){
            return new OfficeHourss();
    }
}
