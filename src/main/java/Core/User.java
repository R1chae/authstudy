/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author RichardDumser
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    private String email;
    private int age;
    
    private static User currentUser = new User();

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

    public static void currentUser(String username, String password, String email, int age) {
        currentUser.username = username;
        currentUser.password = password;
        currentUser.email = email;
        currentUser.age = age;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

}
