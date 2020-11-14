package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration  // for pure Java configuration - no .xml now
@EnableAspectJAutoProxy // for Spring AOP Proxy support
@ComponentScan("com.luv2code.aopdemo") // which packages to scan - recursive
public class DemoConfig {

}
