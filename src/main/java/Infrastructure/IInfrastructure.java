/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infrastructure;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author RichardDumser
 */
public interface IInfrastructure {
    public void connect() throws SQLException;
    public void register(Core.User user) throws RegistrationFailedException;
    public Core.User login(String username, String password) throws SQLException;
    public void setCon(Connection con);                                         //for testing purposes
}
