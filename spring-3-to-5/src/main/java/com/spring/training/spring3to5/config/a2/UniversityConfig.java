package com.spring.training.spring3to5.config.a2;

import com.spring.training.spring3to5.beans.b4javaConfigBeans.javaConfigImport.University;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nitin on 12/12/15.
 */

@Configuration
public class UniversityConfig {

    @Bean(name="university")
    public University university(){
        // Returning the new instance of University to avoid the xml path
        return new University();
    }
}
