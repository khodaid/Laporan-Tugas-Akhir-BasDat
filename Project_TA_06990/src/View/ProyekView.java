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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import DataBase.Koneksi;
import Controller.Project_Deal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyekView {
    private static JFrame frame = new JFrame();
    private static JLabel lNamaOwnerInsert = new JLabel("Nama Owner");
    private static JLabel lAlamatProyekInsert = new JLabel("Alamat Proyek");
    private static JLabel lTahunDealInsert = new JLabel("Tahun Deal");
    private static JLabel lAlamatPenyuratanInsert = new JLabel("Alamat Penyuratan");
    private static JLabel lTelpInsert = new JLabel("No Telp");
    private static JLabel lIdArsitekInsert = new JLabel("Id Arsitek");
    private static JLabel lIdMarketingInsert = new JLabel("Id Marketing");
    private static JLabel lIdProfilInsert = new JLabel("Id Profil");
    private static JTextField tfNamaOwnerInsert = new JTextField();
    private static JTextField tfAlamatProyekInsert = new JTextField();
    private static JTextField tfTahunDealInsert = new JTextField();
    private static JTextField tfAlamatPenyuratanInsert = new JTextField();
    private static JTextField tfTelpInsert = new JTextField();
    private static JSpinner sIdArsitekInsert = new JSpinner();
    private static JSpinner sIdMarketingInsert = new JSpinner();
    private static JSpinner sIdProfilInsert = new JSpinner();
    private static JButton bInsert = new JButton("Insert");
    private static JLabel lAlamatProyekUpdate = new JLabel("Alamat Proyek");
    private static JLabel lKategoriUpdate = new JLabel("Kategori Update");
    private static JLabel lIsiUpdate = new JLabel("Masukan Data");
    private static JTextField tfAlamatProyekUpdate = new JTextField();
    private static JRadioButton rbAlamatPemyuratanUpdate = new JRadioButton("Alamat Penyuratan");
    private static JRadioButton rbTelpUpdate = new JRadioButton("No Telp");
    private static ButtonGroup buttongroup = new ButtonGroup(); // button group
    private static JTextField tfIsiUpdate = new JTextField();
    private static JButton bUpdate = new JButton("Update");
    private static JLabel lAlamatProyekDelete = new JLabel("Alamat Proyek");
    private static JTextField tfAlamatProyekDelete = new JTextField();
    private static JButton bDelete = new JButton("Delete");
    private static JTable list;
    private static JTableHeader header ;
    private static JScrollPane scroll;
    private static Object[] col = {"Alamat Proyek","Nama Owner","Tahun Deal","Alamat Penyuratan","No. Telp","Id Arsitek","Id Marketing","Id Profil"};
    private static Object[][] row = {};
    private static JButton bMarketing = new JButton("Marketing");
    private static JButton bProfil = new JButton("Profil");
    private static JButton bArsitek = new JButton("Arsitek");
    private static Koneksi koneksi = new Koneksi();
    
    public void Proyek(){
        frame.setSize(1600, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SettingInsert();
        frame.add(lAlamatProyekInsert);
        frame.add(lNamaOwnerInsert);
        frame.add(lTahunDealInsert);
        frame.add(lAlamatPenyuratanInsert);
        frame.add(lTelpInsert);
        frame.add(lIdArsitekInsert);
        frame.add(lIdMarketingInsert);
        frame.add(lIdProfilInsert);
        frame.add(tfAlamatProyekInsert);
        frame.add(tfNamaOwnerInsert);
        frame.add(tfTahunDealInsert);
        frame.add(tfAlamatPenyuratanInsert);
        frame.add(tfTelpInsert);
        frame.add(sIdArsitekInsert);
        frame.add(sIdMarketingInsert);
        frame.add(sIdProfilInsert);
        frame.add(bInsert);
        SettingUpdate();
        frame.add(lAlamatProyekUpdate);
        frame.add(lIsiUpdate);
        frame.add(lKategoriUpdate);
        frame.add(tfAlamatProyekUpdate);
        frame.add(tfIsiUpdate);
        frame.add(rbAlamatPemyuratanUpdate);
        frame.add(rbTelpUpdate);
        frame.add(bUpdate);
        buttongroup.add(rbAlamatPemyuratanUpdate);
        buttongroup.add(rbTelpUpdate);
        SettingDelete();
        frame.add(lAlamatProyekDelete);
        frame.add(tfAlamatProyekDelete);
        frame.add(bDelete);
        List();
        frame.add(header);
        scroll.add(list);
        frame.add(list);
        frame.add(scroll);
        SettingNav();
        frame.add(bArsitek);
        frame.add(bProfil);
        frame.add(bMarketing);
        Action();
        getdata();
    }
    
    private static void SettingInsert(){
        lAlamatProyekInsert.setBounds(30, 50, 125, 30);
        lNamaOwnerInsert.setBounds(30, 100, 125, 30);
        lTahunDealInsert.setBounds(30, 150, 125, 30);
        lAlamatPenyuratanInsert.setBounds(30, 200, 125, 30);
        lTelpInsert.setBounds(30, 250, 125, 30);
        lIdArsitekInsert.setBounds(30, 300, 125, 30);
        lIdMarketingInsert.setBounds(30, 350, 125, 30);
        lIdProfilInsert.setBounds(30, 400, 125, 30);
        tfAlamatProyekInsert.setBounds(160, 50, 250, 30);
        tfNamaOwnerInsert.setBounds(160, 100, 150, 30);
        tfTahunDealInsert.setBounds(160, 150, 100, 30);
        tfAlamatPenyuratanInsert.setBounds(160, 200, 250, 30);
        tfTelpInsert.setBounds(160, 250, 100, 30);
        sIdArsitekInsert.setBounds(160, 300, 50, 30);
        sIdMarketingInsert.setBounds(160, 350, 50, 30);
        sIdProfilInsert.setBounds(160, 400, 50, 30);
        bInsert.setBounds(95, 450, 75, 30);
    }
    
    private static void SettingUpdate(){
        lAlamatProyekUpdate.setBounds(450, 50, 125, 30);
        lKategoriUpdate.setBounds(450, 100, 125, 30);
        lIsiUpdate.setBounds(450, 150, 125, 30);
        tfAlamatProyekUpdate.setBounds(580, 50, 250, 30);
        rbAlamatPemyuratanUpdate.setBounds(580, 100, 150, 30);
        rbTelpUpdate.setBounds(750, 100, 100, 30);
        tfIsiUpdate.setBounds(580, 150, 250, 30);
        bUpdate.setBounds(600, 200, 75, 30);
    }
    
    private static void SettingDelete(){
        lAlamatProyekDelete.setBounds(900, 50, 125, 30);
        tfAlamatProyekDelete.setBounds(1030, 50, 250, 30);
        bDelete.setBounds(1000, 100, 75, 30);
    }
    
    private static void List(){
        DefaultTableModel model = new DefaultTableModel(row, col);
        list = new JTable(model);
        header = list.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(300, 250, 1000, 20);
        list.setBounds(300, 270, 1000, 350);
        list.setRowHeight(20);
        list.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        list.setCellEditor(null);
        // setting lebar kolom tabel
        TableColumnModel colModel = list.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(270);
        colModel.getColumn(1).setPreferredWidth(150);
        colModel.getColumn(2).setPreferredWidth(80);
        colModel.getColumn(3).setPreferredWidth(270);
        colModel.getColumn(4).setPreferredWidth(100);
        colModel.getColumn(5).setPreferredWidth(60);
        colModel.getColumn(6).setPreferredWidth(60);
        colModel.getColumn(7).setPreferredWidth(60);
        scroll = new JScrollPane();
        scroll.setVisible(true);
    }
    
    private static void getdata()
    {
        String sql = "SELECT*FROM proyek";
        ResultSet s = koneksi.GetData(sql);
        DefaultTableModel model = (DefaultTableModel)list.getModel();
//        untuk mereset baris table
        model.setRowCount(0);
//        untuk mengisi baris table
        try {
            while(s.next())
            {
                model.addRow(new Object[]{
                    s.getString("ALAMAT_PROYEK"),
                    s.getString("NAMA_OWNER"),
                    s.getDate("TAHUN_DEAL"),
                    s.getString("ALAMAT_PENYURATAN"),
                    s.getString("NO_TELP"),
                    s.getInt("ID_ARSITEK"),
                    s.getInt("ID_MARKETING"),
                    s.getInt("ID_PROFIL")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void SettingNav(){
        bArsitek.setBounds(50, 500, 100, 30);
        bProfil.setBounds(50, 550, 100, 30);
        bMarketing.setBounds(50, 600, 100, 30);
    }
    
    private static void Action(){
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
        bMarketing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MarketingView marketing = new MarketingView();
                marketing.Marketing();
                frame.setVisible(false);
            }
        });
        bInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String aProyek = tfAlamatProyekInsert.getText();
                    String owner = tfNamaOwnerInsert.getText();
                    String tahun =  tfTahunDealInsert.getText();
                    String penyuratan = tfAlamatPenyuratanInsert.getText();
                    String telp = tfTelpInsert.getText();
                    int arsitek = (Integer)sIdArsitekInsert.getValue();
                    int marketing = (Integer)sIdMarketingInsert.getValue();
                    int profil = (Integer)sIdProfilInsert.getValue();
                    Project_Deal pd = new Project_Deal();
                    pd.InsertProyek(aProyek,owner,tahun,penyuratan,telp,arsitek,marketing,profil);
                    System.out.println("test btn insert");
                } catch (SQLException ex) {
                    Logger.getLogger(ProyekView.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex);
                }
                getdata();
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(rbAlamatPemyuratanUpdate.isSelected()){
                    
                }else if(rbTelpUpdate.isSelected()){
                    
                }
                getdata();
            }
        });
    }
}
