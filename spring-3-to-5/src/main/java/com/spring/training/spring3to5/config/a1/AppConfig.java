package com.spring.training.spring3to5.config.a1;

import com.spring.training.spring3to5.beans.b4javaConfigBeans.javaConfig.implementation.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by nitin on 12/12/15.
 */

/* The @Configuration helps avoif the following xml configuration entry
* <bean id="helloBean" class="beans.a1.basicBeans.javaConfig.implementation.HelloWorld"/>
*/
@Configuration
@Primary
public class AppConfig {
    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

}
