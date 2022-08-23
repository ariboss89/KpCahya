/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ariboss89
 */
public class Koneksi {
    public java.sql.Connection conn;

    public java.sql.Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi ke MySQL");

            try {

                String url = "jdbc:mysql://localhost:3306/cahya?"+ "autoReconnect=true&useSSL=false";

                String user = "root";

                String password = "";

                conn = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi sukses");

            } catch (SQLException sqle) {

                System.out.println("Koneksi gagal dilakukan");

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi ke MySQL");
        }

        return conn;
    }
}
