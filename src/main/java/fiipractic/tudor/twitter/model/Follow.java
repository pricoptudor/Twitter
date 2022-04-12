package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    @NonNull
    private int id;

    @NonNull
    private String username1;

    @NonNull
    private String username2;

    public String toString(){
        return "Follow{" +
                "id=" + id+
                ", username1='"+username1+ '\''+
                ", username2='"+username2+ '\''+
                '}';
    }
}
