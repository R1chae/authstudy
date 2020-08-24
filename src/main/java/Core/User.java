/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.Serializable;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author RichardDumser
 */
@Component
public class User implements Serializable{

    private UUID id;                                                            //adjust methods to use uuid, also database, and tests
    private String username;
    private String password;
    private String email;
    private int age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public static User currentUser(String username, String password, String email, int age) {
        
        if(age < 18){
            throw new IllegalArgumentException("age must be 18 or higher");
        } else if(username.length() < 4){
            throw new IllegalArgumentException("username must be 4 characters or longer");
        } else if(password.length() < 8){
            throw new IllegalArgumentException("password must be 8 characters or longer");
        } else if(!email.contains("@")){
            throw new IllegalArgumentException("email must contain @");
        }
        
        return new User(username, password, email, age);
    }

    private User(String username, String password, String email, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User{");
        sb.append("username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
