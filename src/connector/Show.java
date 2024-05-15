package connector;

import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Show class shows how to instantiate the "Connect" class and execute the connection to the database.
 * 
 * @author neury (Minimalist-dev)
 * @version 1.0
 * @since 1.0
 * 
 */
public class Show {
    private static final ArrayList<Object> jsonFormat = new ArrayList<>();

    /**
     * Method that contains the instantiation of the connection and the request to the database.
     * 
     * @return returns an ArrayList object with the results in String. To be converted to JSON and displayed.
     * @since 1.0
     * 
     */
    public static ArrayList<Object> 
    instance() {
        Connection con          = new Connect().with();
//        Connection con          = new Connect().with("url");
//        Connection con          = new Connect().with("user", "password");
//        Connection con          = new Connect().with("url", "user", "password");
        Statement s             = null;
        ResultSet r             = null;
        CallableStatement cs    = null;
        
        try {
        /* 
            1 
        */
            s = con.createStatement(); 
            r = s.executeQuery("SELECT * FROM database.demo;");
            
            while (r.next()) {
                jsonFormat.add("{\"ID\":\"" + r.getInt("id") + "\", \"name\": " + r.getString("nombre") + ", \"lastname\": " + r.getString("lastname") + "}"); 
            }
            out.println("Result = " + jsonFormat);
        /* 
            2
        */
//            cs = con.prepareCall("{CALL global.cantidad()}");
//            r  = cs.executeQuery();
            
            while (r.next()) {
                /* etc */
            }
        /*
            3
        */
//            s = con.createStatement(); 
//            r = s.executeQuery("SELECT * FROM database.demo2;");

            while (r.next()) {
                /* etc */
            }
        } catch (SQLException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                /*
                    { 
                        CLOSE HERE
                    }  
                */
                r.close();
                s.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return jsonFormat;
    }
}
