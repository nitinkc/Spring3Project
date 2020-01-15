package com.spring.training.spring3to5.config.a2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by nitin on 12/12/15.
 */

@Configuration
@Import({ StudentConfig.class, UniversityConfig.class })
public class AppConfig {
}
