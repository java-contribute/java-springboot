package javacontribute.javaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class JavaSpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaSpringbootApplication.class, args);
    }
}
