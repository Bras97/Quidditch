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
import java.sql.Types;
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
    private String dataString;
    private String plec;
    private Integer druzyna_id_druzyny;
    private static ArrayList<Zawodnik> listaZawodnik; 
    
    public Zawodnik() {
    }

    public Integer getId_zawodnika() {
        return id_zawodnika;
    }

    public void setId_zawodnika(Integer id_zawodnika) {
        this.id_zawodnika = id_zawodnika;
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

    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Integer getDruzyna_id_druzyny() {
        return druzyna_id_druzyny;
    }

    public void setDruzyna_id_druzyny(Integer druzyna_id_druzyny) {
        this.druzyna_id_druzyny = druzyna_id_druzyny;
    }

    public static ArrayList<Zawodnik> getListaZawodnik() {
        return listaZawodnik;
    }

    public static void setListaZawodnik(ArrayList<Zawodnik> listaZawodnik) {
        Zawodnik.listaZawodnik = listaZawodnik;
    }
    
    public Zawodnik(Integer id_zawodnika, String imie, String nazwisko, String pozycja, Date data_urodzenia, String plec, Integer druzyna_id_druzyny, String dataString) {
        this.id_zawodnika = (id_zawodnika == null) ? null : id_zawodnika;
        this.imie = (imie == null) ? null : imie;
        this.nazwisko = (nazwisko == null) ? null : nazwisko;
        this.pozycja = (pozycja == null) ? null : pozycja;
        this.data_urodzenia = (data_urodzenia == null) ? null : data_urodzenia;
        this.plec = (plec == null) ? null : plec;
        this.druzyna_id_druzyny = (druzyna_id_druzyny == null) ? null : druzyna_id_druzyny;
        this.dataString = (data_urodzenia == null) ? null : dataString;
    }

    
    public static ArrayList<Zawodnik> getLista() throws SQLException {
        listaZawodnik = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select *, dataString(data_urodzenia, \",\") AS fun from zawodnik;");  
        while(rs.next())
            listaZawodnik.add(new Zawodnik(rs.getInt("id_zawodnika"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("pozycja"),rs.getDate("data_urodzenia"), rs.getString("plec"),rs.getInt("druzyna_id_druzyny"),rs.getString("fun")));
        return listaZawodnik;
    }
    
    public static ArrayList<Zawodnik> wyszukaj(String szukane) throws SQLException {
        listaZawodnik = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select *, dataString(data_urodzenia, \",\") AS function from zawodnik where nazwisko LIKE '%" + szukane + "%';");
        while(rs.next())            
            listaZawodnik.add(new Zawodnik(rs.getInt("id_zawodnika"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("pozycja"),rs.getDate("data_urodzenia"), rs.getString("plec"),rs.getInt("druzyna_id_druzyny"),rs.getString("function")));
        return listaZawodnik;
    }
    
    public void addQuery() throws SQLException {
        System.out.println(imie + " " + nazwisko + " " + pozycja + " " + data_urodzenia + " " + plec + " " + druzyna_id_druzyny);
        String query = "insert into zawodnik ( imie, nazwisko, pozycja, data_urodzenia, plec, druzyna_id_druzyny) values (\""
                + imie + "\",\""
                + nazwisko + "\",\""
                + pozycja + "\","
                + data_urodzenia + ",\""
                + plec + "\","
                + druzyna_id_druzyny
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void updateQuery(Integer id, String imie, String nazwisko, String pozycja, String data_urodzenia, String plec, Integer druzyna_id_druzyny) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE zawodnik SET imie = ?, nazwisko = ?, pozycja = ?, data_urodzenia = ?, plec = ?, druzyna_id_druzyny = ? WHERE id_zawodnika = ?;");
        ps.setString(1,imie);
        ps.setString(2,nazwisko);
        ps.setString(3,pozycja);
        ps.setString(4,data_urodzenia);
        ps.setString(5,plec);
        ps.setInt(6,druzyna_id_druzyny);
        ps.setInt(7,id);
        ps.executeUpdate();
    }
    
    public int checkQuery(Integer id) throws SQLException {
        //Sprawdza czy jest jakas powiazana Kara
        Kara x2 = new Kara();
        ArrayList<Kara> lista2 = x2.getLista();
        for(Kara y2: lista2)
        {
            if(y2.getZawodnik_id_zawodnika() == id)
                return -1;
        }
        return 1;
    }
    
    public int delQuery(Integer id) throws SQLException {
        Miotla x1 = new Miotla();
        ArrayList<Miotla> lista1 = x1.getLista();
        for(Miotla y1: lista1)
        {
            if(y1.getZawodnik_id_zawodnika() == id)
                return -1;
        }
        Kara x2 = new Kara();
        ArrayList<Kara> lista2 = x2.getLista();
        for(Kara y2: lista2)
        {
            if(y2.getZawodnik_id_zawodnika() == id)
                return -1;
        }
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE miotla SET zawodnik_id_zawodnika = ? WHERE zawodnik_id_zawodnika = ?;");
        ps.setNull(1, Types.INTEGER);
        ps.setInt(2,id);
        ps.executeUpdate();
        String query1 = "delete from kara where zawodnik_id_zawodnika = ?;";
        PreparedStatement preparedStmt1 = Quidditch.con.prepareStatement(query1);
        preparedStmt1.setInt(1, id); //TO DO
        preparedStmt1.execute();
        String query2 = "delete from zawodnik where id_zawodnika = ?;";
        PreparedStatement preparedStmt2 = Quidditch.con.prepareStatement(query2);
        preparedStmt2.setInt(1, id); //TO DO
        preparedStmt2.execute();
        return 1;
    }
    
}
