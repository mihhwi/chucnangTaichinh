package model;

import java.util.Scanner;

public class NhanVien extends ConNguoi {
    Scanner sc = new Scanner(System.in);
    private String MaNV;
    private String MaPhong;
    private String ChucVu;
    private String LoaiHD;
    private String NgayKy;
    private String NgayHetHan;
    private String Gmail;
    private String luongCB;

    public NhanVien() {
        super();

    }

    public NhanVien(String MaNV, String HoTen, String MaPhong,
            String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String Gmail, String luongCB) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.Gmail = Gmail;
        this.luongCB = luongCB;
    }

    public NhanVien(String HoTen, String GioiTinh, String DiaChi, String QueQuan, String NgaySinh, String SoDT,
            String DanToc, String TonGiao, String HocVan, String MaNV, String MaPhong,
            String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String Gmail, String luongCB) {
        super(HoTen, GioiTinh, DiaChi, QueQuan, NgaySinh, SoDT, DanToc, TonGiao, HocVan);
        this.MaNV = MaNV;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.Gmail = Gmail;
        this.luongCB = luongCB;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getLoaiHD() {
        return LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = LoaiHD;
    }

    public String getNgayKy() {
        return NgayKy;
    }

    public void setNgayKy(String NgayKy) {
        this.NgayKy = NgayKy;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }
    public String getLuongCB() {
        return luongCB;
    }
    public void setLuongCB(String luongCB) {
        this.luongCB = luongCB;
    }

    public void input() {
        super.input();
        System.out.print("Nhap Ma Nhan Vien: ");
        MaNV = sc.nextLine();
        System.out.print("Nhap Ma Phong: ");
        MaPhong = sc.nextLine();
        System.out.print("Nhap Chuc Vu: ");
        ChucVu = sc.nextLine();
        System.out.print("Nhap LoaiHD: ");
        LoaiHD = sc.nextLine();
        System.out.print("Nhap Ngay Ky: ");
        NgayKy = sc.nextLine();
        System.out.print("Nhap Ngay Het Han: ");
        NgayHetHan = sc.nextLine();
        System.out.print("Nhap Gmail: ");
        Gmail = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        luongCB = sc.nextLine();
    }

    public String toString() {
        return getMaNV() + "| " + getMaPhong() + "| " + getChucVu() + "| " +
                getLoaiHD() + "| " + getNgayKy() + "| " + getNgayHetHan() + "| " + getGmail();
    }

}
