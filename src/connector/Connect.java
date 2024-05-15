package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main function of the "Connect" class is to make the connection between JDBS and MySQL in an instantiated way.
 * <br><br>
 * Way to instantiate it: in the class that has been instantiated and within the method to be used.<br>
 * <pre>
 *      Connection con = new Connect().with();
 *      Connection con = new Connect().with("url");
 *      Connection con = new Connect().with("user", "password");
 *      Connection con = new Connect().with("url", "user", "password");
 * </pre><br>
 * Way to close it: <strong>in the class that has been instantiated and you only have to close it once, 
 * after all requests to the server or else it will block the connection.</strong><br>
 * <pre>
 *      con.close();
 * </pre><br>
 * Allows you to connect to other databases and users with different privileges. As with this way of instantiating it, it allows 
 * you to close the connection and free resources, avoiding overloads, blocking, server request errors and connection drops.
 * <br><br>
 * <strong>See proyect in github:</strong> <a href="https://xxxxxxxxx">Proyect files</a>
 *
 * @author neury (Minimalist-dev)
 * @version 1.0
 * @since 1.0
 *
 */
public class Connect {
    
    private static final String URL         = "jdbc:mysql://localhost:3306/database";
    private static final String USER        = "root";
    private static final String PASSWORD    = "1234";
    private Connection con                  = null;
    
    /**
     * The with() method, without parameters, allows it to be instantiated and connect to the database. 
     * With the predefined values of the class.
     * 
     * @return the connection
     * @since 1.0
     *
     */
    public Connection
    with() {
        try {
            if (con == null) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    /**
     * The with(String url) method, allows it to be instantiated and connect to the database assigned to it.
     * With the predefined values of the class, except database.
     *
     * @param url from the database
     * @return the connection
     * @since 1.0
     *
     */
    public Connection
    with(String url) {
        try {
            if (con == null) {
                con = DriverManager.getConnection(url, USER, PASSWORD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    /**
     * The with(String user, String password) method, allows it to be instantiated and connect to the database assigned to it.
     * With the predefined values of the class, assigning the user and password.
     *
     * @param user from the database
     * @param password from the database
     * @return the connection
     * @since 1.0
     *
     */
    public Connection
    with(String user, String password) {
        try {
            if (con == null) {
                con = DriverManager.getConnection(URL, user, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    /**
     * The with(String url, String user, String password) method, allows it to be instantiated and 
     * connect to the database assigned to it, including the username and password.
     * <br><br>
     * Does not have pre-defined values.
     *
     * @param url from the database
     * @param user from the database
     * @param password from the database
     * @return the connection
     * @since 1.0
     *
     */
    public Connection
    with(String url, String user, String password) {
        try {
            if (con == null) {
                con = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
