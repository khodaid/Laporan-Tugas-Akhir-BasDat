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
import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.ActionListener;
import DataBase.Koneksi;

public class MainView {
    private static JFrame frame = new JFrame("Main View");
    private static JButton buttonArsitek = new JButton("Arsitek");
    private static JButton buttonMarketing = new JButton("Marketing");
    private static JButton buttonProfil = new JButton("Profil Aluminium");
    private static JButton buttonProyek = new JButton("Proyek");
    
    private static void SettingFrame(){
        frame.setSize(300, 320);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SettingButton();
        frame.add(buttonArsitek);
        frame.add(buttonMarketing);
        frame.add(buttonProfil);
        frame.add(buttonProyek);
        Action();
    }
    
    private static void SettingButton() {
        buttonArsitek.setBounds(70, 50, 150, 30);
        buttonArsitek.setText("Arsitek");
        
        buttonMarketing.setBounds(70, 100, 150, 30);
        buttonMarketing.setText("Marketing");
        
        buttonProfil.setBounds(70, 150, 150, 30);
        buttonProfil.setText("Profil Aluminium");
        
        buttonProyek.setBounds(70, 200, 150, 30);
        buttonProyek.setText("Proyek");
    }
    
    private static void Action(){
        buttonArsitek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArsitekView arsitek = new ArsitekView();
                arsitek.Arsitek();
                frame.setVisible(false);
            }
        });
        buttonMarketing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MarketingView marketing = new MarketingView();
                marketing.Marketing();
                frame.setVisible(false);
            }
        });
        buttonProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProfilView profil = new ProfilView();
                profil.Profil();
                frame.setVisible(false);
            }
        });
        buttonProyek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProyekView proyek = new ProyekView();
                proyek.Proyek();
                frame.setVisible(false);
            }
        });
    }
    
    public static void main(String[] args) {
        SettingFrame();
        Koneksi con = new Koneksi();
    }
}
