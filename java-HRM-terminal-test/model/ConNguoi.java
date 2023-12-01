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
        this.HoTen = sc.nextLine();
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = sc.nextLine();
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = sc.nextLine();
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = sc.nextLine();
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = sc.nextLine();
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = sc.nextLine();
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = sc.nextLine();
    }

    public String getTonGiao() {
        return TonGiao;
    }

    public void setTonGiao(String TonGiao) {
        this.TonGiao = sc.nextLine();
    }

    public String getHocVan() {
        return HocVan;
    }

    public void setHocVan(String HocVan) {
        this.HocVan = sc.nextLine();
    }

    public void input() {
        System.out.print("Nhap Ho Ten: ");
        setHoTen(HoTen);
        System.out.print("Nhap Gioi Tinh: ");
        setGioiTinh(GioiTinh);
        System.out.print("Nhap Dia Chi: ");
        setDiaChi(DiaChi);
        System.out.print("Nhap Que Quan: ");
        setQueQuan(QueQuan);
        System.out.print("Nhap Ngay Sinh: ");
        setNgaySinh(NgaySinh);
        System.out.print("Nhap So DT: ");
        setSoDT(SoDT);
        System.out.print("Nhap Dan Toc: ");
        setDanToc(DanToc);
        System.out.print("Nhap Ton Giao: ");
        setTonGiao(TonGiao);
        System.out.print("Nhap Hoc Van: ");
        setHocVan(HocVan);
    }

    public String toString() {
        return getHoTen() + " " + getGioiTinh() + " " + getDiaChi() + " " + getQueQuan() + " " + getNgaySinh() + " "
                + getSoDT() + " " + getDanToc() + " " + getTonGiao() + " " + getHocVan();
    }
}