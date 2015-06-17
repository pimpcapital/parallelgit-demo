package com.beijunyi.parallelgit.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanConfig.class})
public class RuntimeConfig {

}
