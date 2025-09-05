package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @SpringBootApplication
    public static class EmployeeApiApplication {
        public static void main(String[] args) {

            SpringApplication.run(EmployeeApiApplication.class, args);
        }
    }
}
