/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Koneksi.Koneksi;
import Model.tb_barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss89
 */
public class PenggunaDao {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public void Save(String nama, String kontak, String username) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_pengguna(nama, kontak, username, password, role)values('" + nama + "','"+kontak+"', '" + username + "','123456','Admin')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Pengguna berhasil di tambahkan");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Pengguna gagal di tambahkan");
            
        }
    }
    
    public void Update(String username, String password, String nama, String kontak) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_pengguna set password ='" + password + "', nama ='"+nama+"', kontak= '"+kontak+"' where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data berhasil di update");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di update");
        }
    }
    
    public void Delete(String username) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_pengguna where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
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
            query = "SELECT COUNT(username) AS Jumlah FROM tb_pengguna";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_pengguna";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                
                data[r][0] = res.getString("nama");
                data[r][1] = res.getString("kontak");
                data[r][2] = res.getString("username");
                data[r][3] = res.getString("role");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <4; c++) {
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
