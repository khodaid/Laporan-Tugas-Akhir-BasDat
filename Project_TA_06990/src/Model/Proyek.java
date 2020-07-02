/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author khoda
 */
import java.util.Date;

public class Proyek {
    private String Alamat_Proyek;
    private String Nama_Owner;
    private Date Tahun_Deal;
    private String Alamat_Penyuratan;
    private String No_Telp;
    private Arsitek Arsitek;
    private Marketing Marketing;
    private Profil_Aluminium Profil;

    public String getAlamat_Proyek() {
        return Alamat_Proyek;
    }

    public void setAlamat_Proyek(String Alamat_Proyek) {
        this.Alamat_Proyek = Alamat_Proyek;
    }

    public String getNama_Owner() {
        return Nama_Owner;
    }

    public void setNama_Owner(String Nama_Owner) {
        this.Nama_Owner = Nama_Owner;
    }

    public Date getTahun_Deal() {
        return Tahun_Deal;
    }

    public void setTahun_Deal(Date Tahun_Deal) {
        this.Tahun_Deal = Tahun_Deal;
    }

    public String getAlamat_Penyuratan() {
        return Alamat_Penyuratan;
    }

    public void setAlamat_Penyuratan(String Alamat_Penyuratan) {
        this.Alamat_Penyuratan = Alamat_Penyuratan;
    }

    public String getNo_Telp() {
        return No_Telp;
    }

    public void setNo_Telp(String No_Telp) {
        this.No_Telp = No_Telp;
    }

    public Arsitek getArsitek() {
        return Arsitek;
    }

    public void setArsitek(Arsitek Arsitek) {
        this.Arsitek = Arsitek;
    }

    public Marketing getMarketing() {
        return Marketing;
    }

    public void setMarketing(Marketing Marketing) {
        this.Marketing = Marketing;
    }

    public Profil_Aluminium getProfil() {
        return Profil;
    }

    public void setProfil(Profil_Aluminium Profil) {
        this.Profil = Profil;
    }
    
    
}
