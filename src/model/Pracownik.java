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
public class Pracownik {
    private Integer id_pracownika;
    private String imie;
    private String nazwisko;
    private String funkcja;
    private Float zarobki;
    private static ArrayList<Pracownik> listaPracownik; 
    
    public Pracownik() {
    }
    
    public Pracownik(Integer id_pracownika, String imie, String nazwisko, String funkcja, Float zarobki) {
        this.id_pracownika = (id_pracownika == null) ? null : id_pracownika;
        this.imie = (imie == null) ? null : imie;
        this.nazwisko = (nazwisko == null) ? null : nazwisko;
        this.funkcja = (funkcja == null) ? null : funkcja;
        this.zarobki = (zarobki == null) ? null : zarobki;
    }

    public static ArrayList<Pracownik> getLista() throws SQLException {
        listaPracownik = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from pracownik;");  
        while(rs.next())
            listaPracownik.add(new Pracownik(rs.getInt("id_pracownika"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("funkcja"),rs.getFloat("zarobki")));
        return listaPracownik;
    }

    public void addQuery() throws SQLException {
        String query = "insert into pracownik ( imie, nazwisko, funkcja, zarobki) values (\""
                + imie + "\",\""
                + nazwisko + "\",\""
                + funkcja + "\","
                + zarobki
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void updateQuery(Integer id, String imie, String nazwisko, String funkcja, Float zarobki) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE pracownik SET imie = ?, nazwisko = ?, funkcja = ?, zarobki = ? WHERE id_pracownika = ?;");
        ps.setString(1,imie);
        ps.setString(2,nazwisko);
        ps.setString(3,funkcja);
        ps.setFloat(4,zarobki);
        ps.setInt(5,id);
        ps.executeUpdate();
    }
    
    public int delQuery(Integer id) throws SQLException {
        String query1 = "delete from relation_9 where pracownicy_id_pracownika = ?;";
        PreparedStatement preparedStmt1 = Quidditch.con.prepareStatement(query1);
        preparedStmt1.setInt(1, id); //TO DO
        preparedStmt1.execute();
        String query2 = "delete from pracownik where id_pracownika = ?;";
        PreparedStatement preparedStmt2 = Quidditch.con.prepareStatement(query2);
        preparedStmt2.setInt(1, id); //TO DO
        preparedStmt2.execute();
        return 1;
    }

    public Integer getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Integer id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    public Float getZarobki() {
        return zarobki;
    }

    public void setZarobki(Float zarobki) {
        this.zarobki = zarobki;
    }

    public static ArrayList<Pracownik> getListaPracownik() {
        return listaPracownik;
    }

    public static void setListaPracownik(ArrayList<Pracownik> listaPracownik) {
        Pracownik.listaPracownik = listaPracownik;
    }
    
}
