package fiipractic.tudor.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String username;

    private String firstName;

    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String birth;

    @Override
    public String toString(){
        return "User{" +
                "username=" + username +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birth +'\'' +
                '}';
    }
}
