package com.spb.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * application 
 *
 * author:lsd
 */
@SpringBootApplication
@EnableScheduling
public class App 
{
	
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
