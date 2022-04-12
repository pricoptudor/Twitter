package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mention {
    private int id;
    private int id_post;
    private String username_mentioned;

    @Override
    public String toString() {
        return "Mention{" +
                "id=" + id +
                ", id_post=" + id_post +
                ", username_mentioned='" + username_mentioned + '\'' +
                '}';
    }
}
