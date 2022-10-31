package com.springboot.cucumber;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:config/runconfiguation.properties"})
public class ConfigLoad {
}
