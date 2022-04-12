package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private int id;
    private int id_post;
    private int id_reply;
    private String username_reply;
    private int is_public;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", id_post=" + id_post +
                ", id_reply=" + id_reply +
                ", username_reply='" + username_reply + '\'' +
                ", is_public=" + is_public +
                '}';
    }
}
