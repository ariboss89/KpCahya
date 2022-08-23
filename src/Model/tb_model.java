/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariboss89
 */
public class tb_model {
    public void SetTabel(JTable tabel, String [][] data, String [] namaKolom, int jmlKolom, int [] lebar){
        tabel.setModel(new DefaultTableModel(data, namaKolom));
       
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        for (int i = 0; i<jmlKolom; i++)
            tabel.getColumnModel().getColumn(i).setPreferredWidth(lebar[i]);
    }   
}
