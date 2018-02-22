package com.elalex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner loadData(RestTemplate restTemplate) {
        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("Customer found with findOne(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
//            log.info("--------------------------------------------");
//            for (Customer bauer : repository
//                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
//                log.info(bauer.toString());
//            }
//            log.info("");

            User user = new User("alex", "alex");
            try {

                ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8090/login/", user,User.class);
//                User user1 = restTemplate.getForObject(
//                        "http://localhost:8090/user/71269", User.class);
                log.info(responseEntity.toString());
            } catch (IllegalStateException e) {
                log.info(e.getMessage());
            } catch (HttpClientErrorException e) {
                log.error(e.getStatusCode().getReasonPhrase());
                switch (e.getStatusCode()) {
                    case UNSUPPORTED_MEDIA_TYPE:
                        log.error("Invalid input was used instead valid user data");
                        break;
                    case NOT_FOUND:
                        log.error("Can not fined user : " + user.toString());
                        break;
                    default:
                        break;

                }
            }


        };
    }

}
