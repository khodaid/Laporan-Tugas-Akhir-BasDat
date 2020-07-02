/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author khoda
 */
import Model.*;
import DataBase.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Project_Deal {
    Koneksi koneksi;
    ArrayList<Arsitek> arrArsitek;
    ArrayList<Marketing> arrMarketing;
    ArrayList<Profil_Aluminium> arrProfil;
    ArrayList<Proyek> arrProyek;

    public Project_Deal() throws SQLException{
        this.koneksi = new Koneksi();
        this.arrArsitek = new ArrayList<>();
        this.arrMarketing = new ArrayList<>();
        this.arrProfil = new ArrayList<>();
        this.arrProyek = new ArrayList<>();
    }
    
//    public static String insertDB(){
//        
//    }
    
//    insert buat marketing, arsitek dan profil
    public void InsertAMP(String table,String nama_sequence, String nama, String WT){
        String sql = "INSERT INTO "+table+" VALUES("+nama_sequence+",'"+nama+"','"+WT+"')";
        this.koneksi.ManipulasiData(sql);
    }
    
//    insert buat proyek
    public void InsertProyek(String AProyek, String NOwner, String ThnDeal,String APenyuratan, String telp, int IArsitek, int IMarketing,int IProfil){
        String sql = "INSERT INTO PROYEK VALUES('"+AProyek+"','"+NOwner+"', to_date ('"+ThnDeal+"','dd/MM/yyyy'),'"+APenyuratan+"','"+telp+"','"+IArsitek+"','"+IMarketing+"','"+IProfil+"')";
        this.koneksi.ManipulasiData(sql);
        System.out.println(sql);
    }
    
//    update untuk arsitek, marketing, profil
    public void UpdateAMP(String table,int id, String update){
        String sql = null;
        if(null != table)switch (table) {
            case "arsitek":{
                sql = "UPDATE "+table+" set telp_kantor = '"+update+"' where id_arsitek = "+id;
                    break;
                }
            case "marketing":{
                sql = "UPDATE "+table+" set no_telp = '"+update+"' where id_marketing = "+id;
                    break;
                }
            case "profil_aluminium":{
                sql = "UPDATE "+table+" set warna = '"+update+"' where id_profil = "+id;
                    break;
                }
            default:
                break;
        }
        this.koneksi.ManipulasiData(sql);
    }
    
//    update untuk proyek
    public void UpdateProyek(String alamatProyek, String kategori, String isi){
        String sql = null;
        if(kategori.equals("alamat_penyuratan")){
            sql = "UPDATE PROYEK SET alamat_penyuratan = '"+isi+"' WHERE alamat_proyek = '"+alamatProyek+"'";
        } else if (kategori.equals("no_telp")){
            sql = "UPDATE PROYEK SET no_telp = '"+isi+"' WHERE alamat_proyek = '"+alamatProyek+"'";
        }
    }
    
//    delete untuk arsitek, marketing, profil
    public void DeleteAMP(String table, int id){
        String sql = null;
        switch (table) {
            case "arsitek":
                sql = "DELETE FROM "+table+" WHERE id_arsitek = "+id;
                break;
            case "marketing":
                sql = "DELETE FROM "+table+" WHERE id_marketing = "+id;
                break;
            case "profil_aluminium":
                sql = "DELETE FROM "+table+" WHERE id_profil = "+id;
                break;
            default:
                break;
        }
        this.koneksi.ManipulasiData(sql);
    }
    
//    delete untuk proyek
    public void DeleteProyek(String alamatProyek){
        String sql = "DELETE FROM PROYEK WHERE ALAMAT_PROYEK = "+alamatProyek;
        this.koneksi.ManipulasiData(sql);
    }

//    public void InsertProyek() {
//        String sql = "INSERT INTO PROYEK ()"
//    }
}
