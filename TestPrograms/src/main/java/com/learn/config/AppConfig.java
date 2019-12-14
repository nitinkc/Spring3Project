package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.hello.*;
import com.learn.hello.implementation.SayHelloWorld;

@Configuration
public class AppConfig {
	
    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new SayHelloWorld();
    }
	
}