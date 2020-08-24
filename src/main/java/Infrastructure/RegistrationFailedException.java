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
public class RegistrationFailedException extends SQLException {

    /**
     * Creates a new instance of <code>RegistrationFailedException</code>
     * without detail message.
     */
    public RegistrationFailedException() {
    }

    /**
     * Constructs an instance of <code>RegistrationFailedException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistrationFailedException(String msg) {
        super(msg);
    }
}
