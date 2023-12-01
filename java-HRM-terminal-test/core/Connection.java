package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Action {
    public void get();

    public void set();

    public void create();

    public void change();
}

public class Connection implements Action {
    public static class State {
        public static String path_data_QuanTri = "Data\\QuanTri_data\\QuanTri.csv";
        public static String path_data_Nhansu = "Data\\NhanSu_data\\Nhansu.csv";
        public static String path_data_NhanVien = "Data\\NhanVien_data\\NhanVien.csv";
        public static String path_data_TaiChinh = "Data\\TaiChinh_data\\Luong.csv";
        public static String path_data_TruongBan = "Data\\TruongBan_data\\QuanLy.csv";
        public static String path_data_inforNV = "Data\\NhanVien_data\\NV_ThongTin.csv";

        public List<String[]> getData(String selector) {
            List<String[]> result = new ArrayList<>();
            try {
                FileReader fileread = new FileReader(selector);
                BufferedReader br = new BufferedReader(fileread);
                String line;
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String arr[] = line.split(",");
                    result.add(arr);
                }
                br.close();
                fileread.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return result;

        }

        public void setData(String selector, List<String[]> newData) {
            try {
                FileWriter fileWriter = new FileWriter(selector);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                for (String[] s : newData) {
                    for (String value : s) {
                        System.out.println(value);
                    }
                }
                bw.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void get() {

    }

    @Override
    public void set() {
        int select = 0;
        do {
            System.out.println("----chon du lieu can cap nhat------");
            System.out.println("1.du lieu quan tri");
            System.out.println("2.du lieu nhan su");
            System.out.println("3.du lieu nhan vien");
            System.out.println("4.du lieu tai chinh");
            System.out.println("5.du lieu truong ban");
            System.out.println("6.du lieu chi tiet nhan vien");
            System.out.println("7 thoat ");
            if (select < 1 || select > 7) {
                System.out.println("--------------------------------");
                System.out.println("lua chon khong hop le vui long nhap lai");
            }
        } while (select < 1 || select > 7);
        if (select == 7) {
            System.out.println("-----------------------------");
            System.out.println("thoat trinh sua doi du lieu");
            System.out.println("--------------------------------");
            return;
        }
        String path = "";
        State newState = new State();
        if (select == 1) {
            path = State.path_data_QuanTri;
        } else if (select == 2) {
            path = State.path_data_Nhansu;
        } else if (select == 3) {
            path = State.path_data_NhanVien;
        } else if (select == 4) {
            path = State.path_data_TaiChinh;
        } else if (select == 5) {
            path = State.path_data_TruongBan;
        } else if (select == 6) {
            path = State.path_data_inforNV;
        }

    }

    @Override
    public void create() {

    }

    @Override
    public void change() {

    }
}
