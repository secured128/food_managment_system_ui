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
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

//    @Bean
//    public CommandLineRunner loadData(RestTemplate restTemplate) {
//        return (args) -> {
////            // save a couple of users
////            repository.save(new User("Jack", "Bauer"));
////            repository.save(new User("Chloe", "O'Brian"));
////            repository.save(new User("Kim", "Bauer"));
////            repository.save(new User("David", "Palmer"));
////            repository.save(new User("Michelle", "Dessler"));
////
////            // fetch all users
////            log.info("Users found with findAll():");
////            log.info("-------------------------------");
////            for (User user : repository.findAll()) {
////                log.info(user.toString());
////            }
////            log.info("");
////
////            // fetch an individual user by ID
////            User user = repository.findOne(1L);
////            log.info("User found with findOne(1L):");
////            log.info("--------------------------------");
////            log.info(user.toString());
////            log.info("");
////
////            // fetch users by last name
////            log.info("User found with findByLastNameStartsWithIgnoreCase('Bauer'):");
////            log.info("--------------------------------------------");
////            for (User bauer : repository
////                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
////                log.info(bauer.toString());
////            }
////            log.info("");
//
//            User userToFind = new User("ella", "ella");
//            try {
//
//                ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8090/login/", userToFind, User.class);
//                User user = responseEntity.getBody();
////                User user1 = restTemplate.getForObject(
////                        "http://localhost:8090/user/71269", User.class);
//                log.info(user.toString());
//            } catch (IllegalStateException e) {
//                log.info(e.getMessage());
//            } catch (HttpClientErrorException e) {
//                log.error(e.getStatusCode().getReasonPhrase());
//                switch (e.getStatusCode()) {
//                    case UNSUPPORTED_MEDIA_TYPE:
//                        log.error("Invalid input was used instead valid user data");
//                        break;
//                    case NOT_FOUND:
//                        log.error("Can not fined user : " + userToFind.toString());
//                        break;
//                    default:
//                        break;
//
//                }
//            }
//
//
//        };
//    }

}
