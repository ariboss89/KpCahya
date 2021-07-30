/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Koneksi.Koneksi;
import Model.tb_barangmasuk;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss89
 */
public class BarangMasukDao extends tb_barangmasuk {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public int ShowJumlah(int Id){
        int jumlah = 0;
        
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang WHERE Id = '"+Id+"'");
            if(res.next()){
                jumlah = res.getInt("jumlah");
            }
            
        }catch(SQLException ex){
            
        }
        
        return jumlah;
    }
    
    public void Save(String nama, String kategori, int jumlah, Date tanggal) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barangmasuk(nama, kategori, jumlah, tanggal)values('" + nama + "','" + kategori + "', '"+jumlah+"', '"+tanggal+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(int Id, int jumlah) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set jumlah= '"+jumlah+"' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barangmasuk";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barangmasuk";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("kategori");
                data[r][3] = res.getString("jumlah");
                data[r][4] = res.getString("tanggal");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <5; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
