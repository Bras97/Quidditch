/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quidditch.Quidditch;

/**
 *
 * @author Marcin
 */
public class Sedzia {
    private Integer id_sedzi;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private static ArrayList<Sedzia> listaSedzia; 
    
    public Sedzia() {
    }
    
    public Sedzia(Integer id_sedzi, String imie, String nazwisko, Date data_urodzenia) {
        this.id_sedzi = (id_sedzi == null) ? null : id_sedzi;
        this.imie = (imie == null) ? null : imie;
        this.nazwisko = (nazwisko == null) ? null : nazwisko;
        this.data_urodzenia = (data_urodzenia == null) ? null : data_urodzenia;
    }

    public static ArrayList<Sedzia> getLista() throws SQLException {
        listaSedzia = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from sedzia;");  
        while(rs.next())
            listaSedzia.add(new Sedzia(rs.getInt("id_sedzi"),rs.getString("imie"),rs.getString("nazwisko"),rs.getDate("data_urodzenia")));
        return listaSedzia;
    }

    public void addQuery() throws SQLException {
        String query = "insert into sedzia ( imie, nazwisko, data_urodzenia) values (\""
                + imie + "\","
                + nazwisko + ",\""
                + data_urodzenia
                +"\");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from sedzia where id_sedzi = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
