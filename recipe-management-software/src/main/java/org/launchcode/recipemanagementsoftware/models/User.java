package org.launchcode.recipemanagementsoftware.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity{
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    //use to create and verify hashes
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    //    responsible for determining if a given password is a match for the hash stored by the object
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
