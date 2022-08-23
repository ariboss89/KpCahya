/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Koneksi.Koneksi;
import Model.tb_barangkeluar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss89
 */
public class BarangKeluarDao extends tb_barangkeluar {

    Koneksi con;
    Statement st;
    ResultSet res;
    String query;

    public String IdKeluar() {
        String idKeluar = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_barangkeluar ORDER BY Id DESC");
            if (res.next()) {
                String no = res.getString("Id").substring(1);
                String AN = "" + (Integer.parseInt(no) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                idKeluar = ("K" + Nol + AN);
            } else {
                idKeluar = "K0001";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return idKeluar;
    }
    
    public int ShowJumlah(int Id) {
        int jumlah = 0;

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang WHERE id_kabel = '" + Id + "'");
            if (res.next()) {
                jumlah = res.getInt("jumlah");
            }

        } catch (SQLException ex) {

        }

        return jumlah;
    }

    public void Save(String Id, Date tanggal, int total, String username) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barangkeluar(Id, tanggal, total, status, username)values('" + Id + "', '" + tanggal + "', '" + total + "', 'Pending', '"+username+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
            
        }
    }

    public void SaveDetail(String idkeluar, int idKabel, String namaKabel, String typeKabel, String core, String rak,int sisa, int jumlah, Date tanggal, String tahun) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into dt_barangkeluar(id_keluar, id_kabel, nama_kabel, type_kabel, jumlah_core, nomor_rak, sisa_kabel, jumlah, tanggal, tahun)values('" + idkeluar + "','" + idKabel + "', '" + namaKabel + "', "
                    + "'" + typeKabel + "', '" + core + "', '" + rak + "', '" + sisa + "', '" + jumlah + "', '" + tanggal + "', '"+tahun+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di tambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di tambahkan");
        }
    }

    public void Update(int Id, int jumlah) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set jumlah= '" + jumlah + "' where id_kabel = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public void UpdateStatus(String IdKeluar, String status) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barangkeluar set status= '"+status+"' where Id = '" + IdKeluar + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }

    public String[][] ShowKeluar() {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barangkeluar WHERE status ='Pending'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barangkeluar WHERE status ='Pending'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("tanggal");
                data[r][2] = res.getString("total");
                data[r][3] = res.getString("status");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 4; c++) {
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
    
    public String[][] ShowKeluarByUsername(String username) {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barangkeluar WHERE username='"+username+"'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barangkeluar WHERE username='"+username+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("tanggal");
                data[r][2] = res.getString("total");
                data[r][3] = res.getString("status");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 4; c++) {
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
    
    public String[][] ShowKeluarByDate(String status, String awal, String akhir) {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barangkeluar WHERE tanggal BETWEEN '"+awal+"' AND '"+akhir+"' AND status='"+status+"'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barangkeluar WHERE tanggal BETWEEN '"+awal+"' AND '"+akhir+"' AND status='"+status+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("tanggal");
                data[r][2] = res.getString("total");
                data[r][3] = res.getString("status");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 4; c++) {
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
    
    public String[][] ShowDetail(String idKeluar) {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_detail) AS Jumlah FROM dt_barangkeluar WHERE id_keluar = '" + idKeluar + "'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from dt_barangkeluar WHERE id_keluar = '" + idKeluar + "'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_detail");
                data[r][1] = res.getString("id_kabel");
                data[r][2] = res.getString("nama_kabel");
                data[r][3] = res.getString("jumlah");
                data[r][4] = res.getString("tanggal");
                data[r][5] = res.getString("tahun");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
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
