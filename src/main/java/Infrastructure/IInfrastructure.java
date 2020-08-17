/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infrastructure;

import java.sql.SQLException;

/**
 *
 * @author RichardDumser
 */
public interface IInfrastructure {
    public void connect() throws SQLException;
    public void register(String username, String password, String email, int age) throws SQLException;
    public Core.User login(String username, String password) throws SQLException;
}
