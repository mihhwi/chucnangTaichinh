package model;

import java.util.Scanner;

public class ConNguoi {
    Scanner sc = new Scanner(System.in);
    protected String HoTen;
    protected String GioiTinh;
    protected String DiaChi;
    protected String QueQuan;
    protected String NgaySinh;
    protected String SoDT;
    protected String DanToc;
    protected String TonGiao;
    protected String HocVan;

    public ConNguoi() {
     
    }

    public ConNguoi(String HoTen, String GioiTinh, String DiaChi, String QueQuan, String NgaySinh, String SoDT,
            String DanToc, String TonGiao, String HocVan) {
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.QueQuan = QueQuan;
        this.NgaySinh = NgaySinh;
        this.SoDT = SoDT;
        this.DanToc = DanToc;
        this.TonGiao = TonGiao;
        this.HocVan = HocVan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = DanToc;
    }

    public String getTonGiao() {
        return TonGiao;
    }

    public void setTonGiao(String TonGiao) {
        this.TonGiao = TonGiao;
    }

    public String getHocVan() {
        return HocVan;
    }

    public void setHocVan(String HocVan) {
        this.HocVan = HocVan;
    }

    public void input() {
        System.out.print("Nhap Ho Ten: ");
        HoTen = sc.nextLine();
        System.out.print("Nhap Gioi Tinh: ");
        GioiTinh = sc.nextLine();
        System.out.print("Nhap Dia Chi: ");
        DiaChi = sc.nextLine();
        System.out.print("Nhap Que Quan: ");
        QueQuan = sc.nextLine();
        System.out.print("Nhap Ngay Sinh: ");
        NgaySinh = sc.nextLine();
        System.out.print("Nhap So DT: ");
        SoDT = sc.nextLine();
        System.out.print("Nhap Dan Toc: ");
        DanToc = sc.nextLine();
        System.out.print("Nhap Ton Giao: ");
        TonGiao = sc.nextLine();
        System.out.print("Nhap Hoc Van: ");
        HocVan = sc.nextLine();
    }

    public String toString() {
        return getHoTen() + " " + getGioiTinh() + " " + getDiaChi() + " " + getQueQuan() + " " + getNgaySinh() + " "
                + getSoDT() + " " + getDanToc() + " " + getTonGiao() + " " + getHocVan();
    }
}
