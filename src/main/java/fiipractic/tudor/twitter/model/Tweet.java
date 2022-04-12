package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tweet {
    private Post post;
    private String likes;
    private String mentions;
}
