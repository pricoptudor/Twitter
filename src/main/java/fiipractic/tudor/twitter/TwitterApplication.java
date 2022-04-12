package fiipractic.tudor.twitter;

import fiipractic.tudor.twitter.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApplication {
    public static User loggedUser;

    public static void main(String[] args) {
        SpringApplication.run(TwitterApplication.class, args);
    }

}
