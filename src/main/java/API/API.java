/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RichardDumser
 */
@RestController
public class API {
 
    //private static final String PERSISTENCE_UNIT_NAME = "users";
    //private static EntityManagerFactory factory;
    
    @GetMapping("/GetUserInformation")
    public String getUserInfoController() {
        
        
        Core.User user = Core.User.getCurrentUser();
        
        return ("E-Mail: " + user.getEmail() + " </br> Username: " + user.getUsername() + " </br> Password: " + user.getPassword() + " </br> age: " + user.getAge());
    }
    
    @PostMapping("/RegisterNewUser")
    public String postUserInfoController(String email, String username, String password, int age) { 
        
        //factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        //EntityManager em = factory.createEntityManager();
        
        Core.User.currentUser(username, password, email, age);
        //em.persist(Core.User.getCurrentUser());
        return email + " registered as " + username + " with password " + password + " aged " + age;
    }
    
    @PostMapping("/UserAuthentication")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String postLoginController(String username, String password) {
        
        return "not implemented yet";
    }
}