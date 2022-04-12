package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;

    private String message;

    private String username;

    private String timestamp;

    public String toString(){
        return "Post{" +
                "id=" + id+
                ", username='"+username+ '\''+
                ", message='"+message+ '\''+
                ", timestamp='"+timestamp+ '\''+
                '}';
    }
}
