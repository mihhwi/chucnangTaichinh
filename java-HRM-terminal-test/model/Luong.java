package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ArraysInterface { 
            void ThemThongTin();
        
            void XoaThongTin();
        
            void InDanhSach();
        
            void ChinhSuaThongTin();
 
            void TimKiemThongTin();
  
}

public class Luong implements ArraysInterface{
    
    String LuongfilePath = "Data\\TaiChinh_data\\Luong.csv";
    String NhanVienfilePath = "Data\\NhanVien_data\\NhanVien.csv";
    String QuanLyfilePath= "Data\\TruongBan\\QuanLy.csv";
    ArrayList<String> list = new ArrayList<>();

    @Override // them thong tin luong
    public void ThemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma luong: ");
        String MaLuong = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String MaPhong = scanner.nextLine();
        System.out.print("Nhap luong ki luat: ");
        String LuongKL = scanner.nextLine();
        System.out.print("Nhap luong khen thuong: ");
        String LuongKT = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        String LuongCB = scanner.nextLine();
    
        boolean LuongDaTonTai = false;
        ArrayList<String> updatedList = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentMaLuong = data[0].trim(); // Mã lương trong file
                String currentMaPhong = data[1].trim(); // Mã phòng trong file
                // Kiểm tra mã phòng
                if (currentMaLuong.equals(MaLuong) &&
                    currentMaPhong.equals(MaPhong)) {
                    LuongDaTonTai = true;
                    System.out.println("Luong da ton tai trong file. Thong tin se duoc cap nhat.");
                    // Cập nhật thông tin lương nếu đã tồn tại mã phòng
                    line = MaLuong + "," + MaPhong + "," + LuongKL + "," + LuongKT + "," + LuongCB;
                }
                updatedList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Nếu mã phòng không tồn tại trong danh sách, thêm thông tin mới
        if (!LuongDaTonTai) {
            String newEntry = MaLuong + "," + MaPhong + "," + LuongKL + "," + LuongKT + "," + LuongCB;
            updatedList.add(newEntry);
        }
    
        // Ghi lại thông tin vào file
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(LuongfilePath))) {
            for (String line : updatedList) {
                printWriter.println(line);
            }
            System.out.println("Luong da duoc them vao file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    @Override // xoa thong tin Luong
    public void XoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma luong can xoa: ");
        String MaLuongToDelete = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String MaPhongToDelete = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentMaLuong = data[0].trim();
                String currentMaPhong = data[1].trim();
                // Kiem tra xem co phai nhan vien can xoa
                if (currentMaLuong.equals(MaLuongToDelete) && currentMaPhong.equals(MaPhongToDelete)) {
                    continue; // Bo qua dong du lieu can xoa
                }
                list.add(line);
            }
            if (list.size() > 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(LuongfilePath))) {
                    for (String data : list) {
                        writer.write(data);
                        writer.newLine();
                    }
                    System.out.println("Thong tin Luong da duoc xoa.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Khong tim thay Luong can xoa.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        

    @Override // chinh sua thong tin luong
    public void ChinhSuaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma luong can chinh sua: ");
        String MaLuongToEdit = scanner.nextLine();
         // doc tu file va xuat ra mang
        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // nhap thong tin vao mang
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            String[] data = list.get(i).split(",");
            String currentMaLuong = data[0].trim();
            if (currentMaLuong.equals(MaLuongToEdit)) {
                System.out.print("Nhap thong tin moi:\nMa Luong: ");
                String newMaLuong = scanner.nextLine();
                System.out.print("Ma phong: ");
                String newMaPhong = scanner.nextLine();
                System.out.print("Luong ki luat: ");
                String newLuongKL = scanner.nextLine();
                System.out.print("Luong khen thuong: ");
                String newLuongKT = scanner.nextLine();
                System.out.print("Luong co ban: ");
                String newLuongCB = scanner.nextLine();
                list.set(i, newMaLuong + "," + newMaPhong + "," + newLuongKL + ","
                        + newLuongKT + "," + newLuongCB);
                found = true;
                break;
            }
        }
            // ghi vao file
        try (FileWriter fileWriter = new FileWriter(LuongfilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
           for (String line : list) {
               printWriter.println(line);
           }
           if (found) {
               System.out.println("Thong tin luong da duoc chinh sua.");
           } else {
               System.out.println("Khong tim thay ma luong can chinh sua.");
           }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
    
    @Override // tiem kiem luong
    public void TimKiemThongTin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap thong tin can tim ( ma luong/ ma phong): ");
    String timkiem = scanner.nextLine();
    try {
        // doc du lieu tu file goc
        readDataFromFileAndSearch(timkiem);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }
    private void readDataFromFileAndSearch(String timkiem) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(LuongfilePath))) {
        // Bo qua dong dau tien
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("Result:");
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String MaLuong = data[0];
                String MaPhong = data[1];
                String LuongKL = data[2];
                String LuongKT = data[3];
                String LuongCB = data[4];
                if (MaLuong.contains(timkiem)// tim kiem theo tieu chi
                        || MaPhong.equals(timkiem)
                        || LuongKL.equals(timkiem)
                        || LuongKT.equals(timkiem)
                        || LuongCB.equals(timkiem) ) {
                    System.out.println("Ma Luong: " + MaLuong);
                    System.out.println("Ma Phong: " + MaPhong);
                    System.out.println("Luong ki luat: " + LuongKL);
                    System.out.println("Luong khen thuong: " + LuongKT);
                    System.out.println("Luong co ban: " + LuongCB);
                    System.out.println("------------------------");
                    found = true ;
                    break;
                } 
            }
            if(!found) {
                System.out.println("khong co thong tin can tim");
            }
        }
    }


    private List<String[]> readData() {
        List<String[]> combinedList = new ArrayList<>();
        List<String[]> nhanVienList = readFile("Data\\NhanVien_data\\NhanVien.csv", 1, 2, 3, 8, 9);
        List<String[]> quanLyList = readFile("Data\\TruongBan_data\\QuanLy.csv", 1, 2, 3, 6, 7);
        List<String[]> luongList = readFile("Data\\TaiChinh_data\\Luong.csv", 0, 1, 2, 3, 4);
    // Combine thông tin từ ba danh sách
    for (String[] nhanVienData : nhanVienList) {
        for (String[] quanLyData : quanLyList) {
            for (String[] luongData : luongList) {
                if (nhanVienData[0].equals(quanLyData[0]) && quanLyData[0].equals(luongData[0])) {
                    String[] combinedData = new String[7];
                    combinedData[0] = nhanVienData[0]; // MANV
                    combinedData[1] = nhanVienData[1]; // Ma Phong
                    combinedData[2] = nhanVienData[2]; // Chuc Vu
                    combinedData[3] = luongData[0];    // Ma Luong
                    combinedData[4] = nhanVienData[3]; // Luong Co Ban
                    combinedData[5] = quanLyData[3];   // Luong Khen Thuong
                    combinedData[6] = luongData[2];    // Luong Ki Luat
                    combinedList.add(combinedData);
                }
            }
        }
    }

    return combinedList;
}

    private List<String[]> readFile(String filePath, int... columns) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String[] selectedData = new String[columns.length];
                for (int i = 0; i < columns.length; i++) {
                    selectedData[i] = data[columns[i]].trim();
                }
                dataList.add(selectedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
}
    public void TinhLuong(){
        
    }


    @Override // In danh sach luong
    public void InDanhSach() {
        List<String[]> combinedDataList = readData();
        List<String[]> luongList = new ArrayList<>();

        for (String[] data : combinedDataList) {
            String maNV = data[0];
            String maPhong = data[1];
            String chucVu = data[2];
            String maLuong = data[3];
            String luongCoBan = data[4];
            String luongKhenThuong = data[5];
            String luongKiLuat = data[6];

            int luongCoBanInt = Integer.parseInt(luongCoBan);
            int luongKhenThuongInt = Integer.parseInt(luongKhenThuong);
            int luongKiLuatInt = Integer.parseInt(luongKiLuat);

            int tongLuong = luongCoBanInt + luongKhenThuongInt - luongKiLuatInt;

            String[] luongData = {maNV, maPhong, chucVu, maLuong, String.valueOf(tongLuong),
                    luongCoBan, luongKhenThuong, luongKiLuat};

            luongList.add(luongData);
        }

        // Ghi kết quả vào file Luong_NV.csv
        String luongNVFilePath = "Data\\TaiChinh_data\\Luong_NV.csv";
        ghiFile(luongList, luongNVFilePath);
    }

    // Các hàm đọc dữ liệu và readFile() ở đây...

    private void ghiFile(List<String[]> luongList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] luongData : luongList) {
                String line = String.join(",", luongData);
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã ghi danh sách lương vào file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
