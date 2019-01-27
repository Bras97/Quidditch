/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quidditch;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import quidditch.Ranking;
/**
 *
 * @author Marcin
 */
public class Quidditch {
    public static Connection con;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{  
        MysqlDataSource dataSource = new MysqlDataSource();
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quidditch?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");  
        //here sonoo is database name, root is username and password 
        //String query = "insert into znicz values (1,\"SuperZnicz2\",2,12,\"POL\");";
        //Statement statement = con.createStatement();
        //statement.executeUpdate(query);
        Ranking ranking = new Ranking();
        }catch(Exception e){ System.out.println(e);} 
    }
    
}
