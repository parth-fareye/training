package com.fareye.training.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter @Setter @NoArgsConstructor
public class User {

    private int user_id;
    private String firstName;
    private String lastName;
    private String email;

    private String createdDate;

    private String modifiedDate;
    private boolean verified;
    private String role;
    private boolean activity;
    private String password;
    private String avatarUrl;

    //    @Override
    public void setPassword(String password) {
        this.password =hashPassword(password);
    }
    public String hashPassword(String password){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return hashedPassword;
    }
}