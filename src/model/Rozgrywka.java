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
public class Rozgrywka {
    private Integer id_rozgrywki;
    private String punkty_druzyna1;
    private String punkty_druzyna2;
    private Date data;
    private Integer druzyna_id_druzyny;
    private Integer druzyna_id_druzyny1;
    private Integer znicz_id_znicza;
    private Integer sedzia_id_sedzi;
    private static ArrayList<Rozgrywka> listaRozgrywka; 

    public Rozgrywka() {
    }
    
    public Rozgrywka(Integer id_rozgrywki, String punkty_druzyna1, String punkty_druzyna2, Date data, Integer druzyna_id_druzyny, Integer druzyna_id_druzyny1, Integer znicz_id_znicza, Integer sedzia_id_sedzi) {
        this.id_rozgrywki = (id_rozgrywki == null) ? null : id_rozgrywki;
        this.punkty_druzyna1 = (punkty_druzyna1 == null) ? null : punkty_druzyna1;
        this.punkty_druzyna2 = (punkty_druzyna2 == null) ? null : punkty_druzyna2;
        this.data = (data == null) ? null : data;
        this.druzyna_id_druzyny = (druzyna_id_druzyny == null) ? null : druzyna_id_druzyny;
        this.druzyna_id_druzyny1 = (druzyna_id_druzyny1 == null) ? null : druzyna_id_druzyny1;
        this.znicz_id_znicza = (znicz_id_znicza == null) ? null : znicz_id_znicza;
        this.sedzia_id_sedzi = (sedzia_id_sedzi == null) ? null : sedzia_id_sedzi;
    }

    public static ArrayList<Rozgrywka> getLista() throws SQLException {
        listaRozgrywka = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from znicz;");  
        while(rs.next())
            listaRozgrywka.add(new Rozgrywka(rs.getInt("id_rozgrywki"),rs.getString("punkty_druzyna1"),rs.getString("punkty_druzyna2"),rs.getDate("data"),rs.getInt("druzyna_id_druzyny"),rs.getInt("druzyna_id_druzyny1"),rs.getInt("znicz_id_znicza"),rs.getInt("sedzia_id_sedzi")));
        return listaRozgrywka;
    }

    public void addQuery() throws SQLException {
        String query = "insert into rozgrywka ( id_rozgrywki, punkty_druzyna1, punkty_druzyna2, data, druzyna_id_druzyny, druzyna_id_druzyny1, znicz_id_znicza, sedzia_id_sedzi) values (" 
                + id_rozgrywki + ","
                + punkty_druzyna1 + ","
                + punkty_druzyna2 + ","
                + data + ","
                + druzyna_id_druzyny + ","
                + druzyna_id_druzyny1 + ","
                + znicz_id_znicza + ","
                + sedzia_id_sedzi
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from rozgrywka where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
}
