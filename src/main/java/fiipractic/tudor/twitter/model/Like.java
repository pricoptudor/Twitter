package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    private int id;
    private int id_post;
    private String username_like;

    public String toString(){
        return "Like{" +
                "id=" + id+
                ", id_post='"+id_post+ '\''+
                ", username_like='"+username_like+ '\''+
                '}';
    }
}
