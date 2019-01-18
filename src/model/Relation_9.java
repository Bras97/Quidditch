/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Relation_9 {
    private Integer id_rel;
    private Integer pracownicy_id_pracownika;
    private Integer druzyna_id_druzyny;
    private static ArrayList<Relation_9> listaRel; 

    public Relation_9() {
    }
    
    public Relation_9(Integer id_rel, Integer pracownicy_id_pracownika, Integer druzyna_id_druzyny) {
        this.id_rel = (id_rel == null) ? null : id_rel;
        this.pracownicy_id_pracownika = (pracownicy_id_pracownika == null) ? null : pracownicy_id_pracownika;
        this.druzyna_id_druzyny = (druzyna_id_druzyny == null) ? null : druzyna_id_druzyny;
    }

    public static ArrayList<Relation_9> getLista() throws SQLException {
        listaRel = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from relation_9;");  
        while(rs.next())
            listaRel.add(new Relation_9(rs.getInt("id_rel"),rs.getInt("pracownicy_id_pracownika"),rs.getInt("druzyna_id_druzyny")));
        return listaRel;
    }

    public void addQuery() throws SQLException {
        String query = "insert into relation_9 ( pracownicy_id_pracownika, druzyna_id_druzyny) values (" 
                + pracownicy_id_pracownika + ","
                + druzyna_id_druzyny + ","
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from relation_9 where id_rel = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
}
