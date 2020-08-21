/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Infrastructure.IInfrastructure;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RichardDumser
 */
@RestController
public class API {

    private static Core.User currentUser;
    ApplicationContext context = new AnnotationConfigApplicationContext(Infrastructure.Mapping.class);
    private Infrastructure.IInfrastructure infra = (Infrastructure.IInfrastructure) context.getBean("infraBean");

    public API() {
    }
    
    public API(IInfrastructure infra) {
        this.infra = infra;
    }
    
    public API(IInfrastructure infra, Core.User user) {
        this.infra = infra;
        this.currentUser = user;
    }
    
    @GetMapping("/GetUserInformation")
    @ResponseStatus(HttpStatus.OK)
    public Core.User getUserInfoController() {
        return (currentUser);
    }

    @PostMapping("/RegisterNewUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String postUserInfoController(String email, String username, String password, int age) {
        
        try{
            infra.register(username, password, email, age);
            
            currentUser = Core.User.currentUser(username, password, email, age);
            
            StringBuilder registrationmsg = new StringBuilder(email);           //I could just return it as json, but for learning purposes I'll leave it with this string using StringBuilder
            registrationmsg.append(" registered as ").append(username);
            registrationmsg.append(" with password ").append(password);
            registrationmsg.append(" aged ").append(age);
            return registrationmsg.toString();
        } catch(SQLException e){
            e.printStackTrace();
            return("Database call failed");
        }
    }

    @PostMapping("/UserAuthentication")
    @ResponseStatus(HttpStatus.CREATED)
    public String postLoginController(String username, String password) {
        try{
            currentUser = infra.login(username, password);//using the currentUser for this means that if someone is logged in already, they get logged out if they enter invalid credentials, BUT I don't have to make another User object
            if(currentUser.equals(null)){
                return "invalid credentials";
            } else {
                return "logged in as: " + currentUser.getUsername();            //should I use StringBuilder even for this?
            }
        } catch (SQLException e){
            e.printStackTrace();
            return "SQL ERROR";
        }
    }
}
