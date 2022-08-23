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
            res = st.executeQuery("SELECT *FROM tb_barang WHERE id_kabel = '"+Id+"'");
            if(res.next()){
                jumlah = res.getInt("jumlah");
            }
            
        }catch(SQLException ex){
            
        }
        
        return jumlah;
    }
    
    public void Save(int Id, String nama, String type, String core, String rak, int jumlah, Date tanggal, String tahun) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barangmasuk(id_kabel, nama_kabel, type_kabel, jumlah_core, nomor_rak , jumlah, tanggal, tahun)values('" + Id + "','" + nama + "','" + type + "','" + core + "','" + rak + "', '"+jumlah+"', '"+tanggal+"', '"+tahun+"')";
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
            query = "update tb_barang set jumlah= '"+jumlah+"' where id_kabel = '" + Id + "'";
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
            data = new String[jumlahBaris][8];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama_kabel");
                data[r][2] = res.getString("type_kabel");
                data[r][3] = res.getString("jumlah_core");
                data[r][4] = res.getString("nomor_rak");
                data[r][5] = res.getString("jumlah");
                data[r][6] = res.getString("tanggal");
                data[r][7] = res.getString("tahun");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <8; c++) {
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
