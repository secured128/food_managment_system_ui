package com.elalex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserRESTCaller {
    private static final Logger log = LoggerFactory.getLogger(UserRESTCaller.class);

    //    User userToFind = new User("ella", "ella");
//
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public List<User> findAll() {
        try {
            ResponseEntity<List> responseEntity = new RestTemplateBuilder().build().getForEntity("http://localhost:8090/find", List.class);
            return getUsersListFromMapsList(responseEntity.getBody());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public List<User> findByNameStartsWithIgnoreCase(String nameStart) {
        try {
            ResponseEntity<List> responseEntity = new RestTemplateBuilder().build().getForEntity("http://localhost:8090/find/" + nameStart, List.class);
            return getUsersListFromMapsList(responseEntity.getBody());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private List<User> getUsersListFromMapsList(List<Map> mapsList) {
        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < mapsList.size(); i++) {
            Map currentUserMap = mapsList.get(i);
            User currentUser = new User(((Integer) currentUserMap.get("id")).longValue(), (String) currentUserMap.get("name"), (String) currentUserMap.get("password"));
            usersList.add(currentUser);
        }
        return usersList;
    }

//                User user = responseEntity.getBody();
//                User user1 = restTemplate.getForObject(
//                        "http://localhost:8090/user/71269", User.class);
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
//    }
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

}
