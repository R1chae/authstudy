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
public class DBConnectionFailedException extends SQLException {

    /**
     * Creates a new instance of <code>DBConnectionFailedException</code>
     * without detail message.
     */
    public DBConnectionFailedException() {
    }

    /**
     * Constructs an instance of <code>DBConnectionFailedException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DBConnectionFailedException(String msg) {
        super(msg);
    }
}
