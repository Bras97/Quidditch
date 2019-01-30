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

    public static ArrayList<Sedzia> wyszukaj(String szukane) throws SQLException {
        listaSedzia = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from sedzia where nazwisko LIKE '%" + szukane + "%';");  
        while(rs.next())
            listaSedzia.add(new Sedzia(rs.getInt("id_sedzi"),rs.getString("imie"),rs.getString("nazwisko"),rs.getDate("data_urodzenia")));
        return listaSedzia;
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
    
    public void updateQuery(Integer id, String imie, String nazwisko, Date data_urodzenia) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE sedzia SET imie = ?, nazwisko = ?, data_urodzenia = ? WHERE id_sedzi = ?;");
        ps.setString(1,imie);
        ps.setString(2,nazwisko);
        ps.setDate(3,data_urodzenia);
        ps.setInt(4,id);
        ps.executeUpdate();
    }
    
    public int delQuery(Integer id) throws SQLException {
        Rozgrywka x = new Rozgrywka();
        ArrayList<Rozgrywka> lista = x.getLista();
        for(Rozgrywka y: lista)
        {
            if(y.getSedzia_id_sedzi() == id)
                return -2;
        }
        String query = "delete from sedzia where id_sedzi = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
        return 1;
    }

    public Integer getId_sedzi() {
        return id_sedzi;
    }

    public void setId_sedzi(Integer id_sedzi) {
        this.id_sedzi = id_sedzi;
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

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public static ArrayList<Sedzia> getListaSedzia() {
        return listaSedzia;
    }

    public static void setListaSedzia(ArrayList<Sedzia> listaSedzia) {
        Sedzia.listaSedzia = listaSedzia;
    }
    
}
