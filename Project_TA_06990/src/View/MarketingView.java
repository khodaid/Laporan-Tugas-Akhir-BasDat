/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author khoda
 */
import Controller.Project_Deal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import DataBase.Koneksi;

public class MarketingView {

    private static JFrame frame = new JFrame();
    private static JLabel lNamaInsert = new JLabel("Nama");
    private static JLabel lTelpInsert = new JLabel("No. Telp");
    private static JTextField tfNamaInsert = new JTextField();
    private static JTextField tfTelpInsert = new JTextField();
    private static JButton bInsert = new JButton("Insert");
    private static JLabel lIdUpdate = new JLabel("ID");
    private static JLabel lTelpUpdate = new JLabel("No. Telp");
    private static JTextField tfTelpUpdate = new JTextField();
    private static JSpinner sIdUpdate = new JSpinner();
    private static JButton bUpdate = new JButton("Update");
    private static JLabel lIdDelete = new JLabel("ID");
    private static JSpinner sIdDelete = new JSpinner();
    private static JButton bDelete = new JButton("Delete");
    private static JTable list;
    private static JTableHeader header ;
    private static JScrollPane scroll;
    private static Object[] col = {"ID","Nama Marketing","No. Telp"};
    private static Object[][] row = {};
    private static JButton bArsitek = new JButton("Arsitek");
    private static JButton bProyek = new JButton("Proyek");
    private static JButton bProfil = new JButton("Profil");
    private static Koneksi koneksi = new Koneksi();
    
    public void Marketing() {
        frame.setSize(1000, 630);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SettingInsert();
        frame.add(lNamaInsert);
        frame.add(lTelpInsert);
        frame.add(tfNamaInsert);
        frame.add(tfTelpInsert);
        frame.add(bInsert);
        SettingUpdate();
        frame.add(lIdUpdate);
        frame.add(lTelpUpdate);
        frame.add(sIdUpdate);
        frame.add(tfTelpUpdate);
        frame.add(bUpdate);
        SettingDelete();
        frame.add(lIdDelete);
        frame.add(sIdDelete);
        frame.add(bDelete);
        List();
        frame.add(header);
        frame.add(list);
        frame.add(scroll);
        SettingNav();
        frame.add(bArsitek);
        frame.add(bProfil);
        frame.add(bProyek);
        Action();
        getdata();
    }
    
    private static void SettingInsert(){
        lNamaInsert.setBounds(30, 50, 50, 30);
        lTelpInsert.setBounds(30, 100, 50, 30);
        tfNamaInsert.setBounds(100, 50, 150, 30);
        tfTelpInsert.setBounds(100, 100, 150, 30);
        bInsert.setBounds(95, 150, 75, 30);
    }
    
    private static void SettingUpdate(){
        lIdUpdate.setBounds(30, 250, 50, 30);
        lTelpUpdate.setBounds(30, 300, 50, 30);
        sIdUpdate.setBounds(100, 250, 50, 30);
        tfTelpUpdate.setBounds(100, 300, 150, 30);
        bUpdate.setBounds(95, 350, 75, 30);
    }
    
    private static void SettingDelete(){
        lIdDelete.setBounds(30, 450, 50, 30);
        sIdDelete.setBounds(100, 450, 50, 30);
        bDelete.setBounds(65, 500, 75, 30);
    }
    
    private static void List(){
        DefaultTableModel model = new DefaultTableModel(row, col);
        list = new JTable(model);
        header = list.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(400, 50, 500, 20);
        list.setBounds(400, 70, 500, 350);
        list.setRowHeight(20);
        list.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        list.setCellEditor(null);
        // setting lebar kolom tabel
        TableColumnModel colModel = list.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(50);
        colModel.getColumn(1).setPreferredWidth(300);
        colModel.getColumn(2).setPreferredWidth(150);
        scroll = new JScrollPane(list);
        scroll.setVisible(true);
    }
    
    private static void SettingNav(){
        bArsitek.setBounds(425, 500, 100, 30);
        bProfil.setBounds(600, 500, 100, 30);
        bProyek.setBounds(775, 500, 100, 30);
    }
    
    private static void getdata()
    {
        String sql = "SELECT*FROM marketing";
        ResultSet s = koneksi.GetData(sql);
        DefaultTableModel model = (DefaultTableModel)list.getModel();
//        untuk mereset baris table
        model.setRowCount(0);
//        untuk mengisi baris table
        try {
            while(s.next())
            {
                model.addRow(new Object[]{
                    s.getInt("ID_MARKETING"),
                    s.getString("NAMA_MARKETING"),
                    s.getString("NO_TELP")});
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void Action(){
        String tabel = "marketing";
        bArsitek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArsitekView arsitek = new ArsitekView();
                arsitek.Arsitek();
                frame.setVisible(false);
            }
        });
        bProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProfilView profil = new ProfilView();
                profil.Profil();
                frame.setVisible(false);
            }
        });
        bProyek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProyekView proyek = new ProyekView();
                proyek.Proyek();
                frame.setVisible(false);
            }
        });
        bInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Project_Deal pd = null;
                try {
                    pd = new Project_Deal();
                } catch (SQLException ex) {
                    Logger.getLogger(ArsitekView.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex);
                }
                pd.InsertAMP("marketing", "Id_Arsitek.nextval", tfNamaInsert.getText(), tfTelpInsert.getText());
                System.out.println("insert");
                getdata();
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Project_Deal pd = null;
                try {
                    pd = new Project_Deal();
                } catch (SQLException ex) {
                    Logger.getLogger(ArsitekView.class.getName()).log(Level.SEVERE, null, ex);
                }
                pd.UpdateAMP(tabel, (Integer)sIdUpdate.getValue(), tfTelpUpdate.getText());
                getdata();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Project_Deal pd = null;
                try {
                    pd = new Project_Deal();
                } catch (SQLException ex) {
                    Logger.getLogger(ArsitekView.class.getName()).log(Level.SEVERE, null, ex);
                }
                pd.DeleteAMP(tabel, (Integer)sIdDelete.getValue());
                getdata();
            }
        });
    }
}
