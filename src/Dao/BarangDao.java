/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class BarangDao extends tb_barang {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    tb_barang brg ;
    
    public void Save(String nama, String type, String core, String rak) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barang(nama_kabel, type_kabel, jumlah_core, nomor_rak, jumlah)values('" + nama + "','"+type+"', '" + core + "','"+rak+"',0)";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
            
        }
    }
    
    public void Update(int Id, String nama, String type, String core, String rak) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set nama_kabel ='" + nama + "', type_kabel ='"+type+"', jumlah_core= '"+core+"', nomor_rak='"+rak+"' where id_kabel = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di update");
        }
    }
    
    public void Delete(int Id) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_barang where id_kabel = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }
    
    public int ShowStokBarang(String nama, String rak){
        
        int stok =0;
        
        con = new Koneksi();
        con.connect();
        res = null;
        
        try {
            st = con.conn.createStatement();
            query = "SELECT(jumlah) as jml from tb_barang where type_kabel = '" + nama + "' AND nomor_rak = '"+rak+"'";
            res = st.executeQuery(query);
            
            if(res.next()){
                stok = res.getInt("jml");
            }
            
            st.close();
            con.conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data stok gagal di tampilkan");
        }
        
        return stok;
    };
    
    public ArrayList<tb_barang> listIdKabel() {
        
        ArrayList list = new ArrayList<tb_barang>();

        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang");
            while (res.next()) {
                
                brg = new tb_barang();
                brg.setId(res.getInt("id_kabel"));
                brg.setRak(res.getString("nomor_rak"));
                
                list.add(brg);
                
            }
        } catch (SQLException ex) {

        }

        return list;
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_kabel) AS Jumlah FROM tb_barang";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barang";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_kabel");
                data[r][1] = res.getString("nama_kabel");
                data[r][2] = res.getString("type_kabel");
                data[r][3] = res.getString("jumlah_core");
                data[r][4] = res.getString("nomor_rak");
                data[r][5] = res.getString("jumlah");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <6; c++) {
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
