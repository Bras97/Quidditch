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
public class Zawodnik {
    private Integer id_zawodnika;
    private String imie;
    private String nazwisko;
    private String pozycja;
    private Date data_urodzenia;
    private Boolean plec;
    private Integer druzyna_id_druzyny;
    private static ArrayList<Zawodnik> listaZawodnik; 
    
    public Zawodnik() {
    }
    
    public Zawodnik(Integer id_zawodnika, String imie, String nazwisko, String pozycja, Date data_urodzenia, Boolean plec, Integer druzyna_id_druzyny) {
        this.id_zawodnika = (id_zawodnika == null) ? null : id_zawodnika;
        this.imie = (imie == null) ? null : imie;
        this.nazwisko = (nazwisko == null) ? null : nazwisko;
        this.pozycja = (pozycja == null) ? null : pozycja;
        this.data_urodzenia = (data_urodzenia == null) ? null : data_urodzenia;
        this.plec = (plec == null) ? null : plec;
        this.druzyna_id_druzyny = (druzyna_id_druzyny == null) ? null : druzyna_id_druzyny;
    }

    public static ArrayList<Zawodnik> getLista() throws SQLException {
        listaZawodnik = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from zawodnik;");  
        while(rs.next())
            listaZawodnik.add(new Zawodnik(rs.getInt("id_zawodnika"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("pozycja"),rs.getDate("data_urodzenia"), rs.getBoolean("plec"),rs.getInt("druzyna_id_druzyny")));
        return listaZawodnik;
    }

    public void addQuery() throws SQLException {
        String query = "insert into zawodnik ( id_zawodnika, imie, nazwisko, pozycja, data_urodzenia, plec, druzyna_id_druzyny) values (" 
                + id_zawodnika + ",\""
                + imie + "\",\""
                + nazwisko + "\",\""
                + pozycja + "\","
                + data_urodzenia + ","
                + plec + ","
                + druzyna_id_druzyny
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from zawodnik where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
