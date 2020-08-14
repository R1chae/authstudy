/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author RichardDumser
 */
public class Infrastructure {
    private static final String DBPATH = "jdbc:derby:src\\main\\java\\Infrastructure\\authstudyDB;create=true";
    private static final String DBUSERNAME = "root";
    private static final String DBPASSWORD = "";
    private static Connection con;
    
    public static void connect() throws SQLException{
        if(con == null){
            con = DriverManager.getConnection(DBPATH, DBUSERNAME, DBPASSWORD);
        }
    }
    
    public static void register(String username, String password, String email, int age) throws SQLException{
        connect();
        Statement statement = con.createStatement();                            //TABLE user: (username varchar(64), password varchar(128), email varchar(128), age int, PRIMARY KEY(username)
        StringBuilder sb = new StringBuilder("INSERT INTO users VALUES ('");
        sb.append(username).append("', '");
        sb.append(password).append("', '");
        sb.append(email).append("', ");
        sb.append(age).append(")");
        statement.executeUpdate(sb.toString());
    }
    
    public static Core.User login(String username, String password) throws SQLException{
        connect();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            if((rs.getString("username").equals(username)) && (rs.getString("password").equals(password))){
                return Core.User.currentUser(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getInt("age"));
            }
        }
        return null;
    }
}
