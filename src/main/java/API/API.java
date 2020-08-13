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

/**
 *
 * @author RichardDumser
 */
@RestController
public class API {

    private static Core.User currentUser;

    @GetMapping("/GetUserInformation")
    @ResponseStatus(HttpStatus.OK)
    public Core.User getUserInfoController() {
        return (currentUser);
    }

    @PostMapping("/RegisterNewUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String postUserInfoController(String email, String username, String password, int age) {
        currentUser = Core.User.currentUser(username, password, email, age);
        StringBuilder registrationmsg = new StringBuilder(email);               //I could just return it as json, but for learning purposes I'll leave it with this string using StringBuilder
        registrationmsg.append(" registered as ").append(username);
        registrationmsg.append(" with password ").append(password);
        registrationmsg.append(" aged ").append(age);
        return registrationmsg.toString();
    }

    @PostMapping("/UserAuthentication")
    @ResponseStatus(HttpStatus.CREATED)
    public String postLoginController(String username, String password) {
        return "not implemented yet";
    }
}
