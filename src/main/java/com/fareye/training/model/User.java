package com.fareye.training.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Currency;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Users")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First Name", length = 25) @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @Column(name = "Last Name", length = 25) @NotBlank(message = "lastName is mandatory")
    private String lastName;

    @Column(name = "Email ID") @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String emailId;

    @Column(name = "IsVerified")
    private Boolean isVerified;

    @Column(name = "Date of Creation") @Temporal(TemporalType.DATE) @Setter(AccessLevel.NONE)
    private LocalDate dateCreated;

    @Column(name = "Last Modified") @Setter(AccessLevel.NONE)
    private LocalDate dateModified;

    @Column(name = "Hashed Password") @NotBlank(message = "password is mandatory") @Size(max = 32, min = 9, message = "password size is not acceptable") @Setter(AccessLevel.NONE)
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "IsActive")
    private Boolean isActive;

    public void setPassword(String password) {
        this.password = hashPassword();
    }
    public String hashPassword(){
        String hashedPassword = BCrypt.hashpw(this.password, BCrypt.gensalt(10));
        return hashedPassword;
    }
}
