package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KiLuat implements ArraysInterface {
    String filePath = "Data\\TruongBan_data\\QuanLy.csv";

    @Override // them thong tin nhan vien ki luat
    public void ThemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap ma bo phan: ");
        String maBoPhan = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhap chuc vu: ");
        String chucVu = scanner.nextLine();
        System.out.print("Nhap ngay dang ky: ");
        String ngayDangKy = scanner.nextLine();
        System.out.print("Nhap ngay het han: ");
        String ngayHetHan = scanner.nextLine();
        System.out.print("Nhap luong ki luat: ");
        String luongKiLuat = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(filePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            // printWriter.println();
            printWriter.println(hoTen + "," + maBoPhan + "," + maPhong + "," + chucVu + "," + ngayDangKy + ","
                    + ngayHetHan + "," + luongKiLuat);

            System.out.println("Nhan vien da duoc them vao file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // xoa thong tin nhan vien ki luat
    public void XoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can xoa: ");
        String hoTenToDelete = scanner.nextLine();
        System.out.print("Nhap ma bo phan: ");
        String maBoPhanToDelete = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String maPhongToDelete = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentHoTen = data[0].trim();
                String currentMaBoPhan = data[1].trim();
                String currentMaPhong = data[2].trim();

                // Kiểm tra xem có phải nhân viên cần xóa không
                if (currentHoTen.equals(hoTenToDelete) &&
                        currentMaBoPhan.equals(maBoPhanToDelete) &&
                        currentMaPhong.equals(maPhongToDelete)) {
                    continue; // Bỏ qua dòng dữ liệu cần xóa
                }
                lines.add(line);
            }
            if (lines.size() > 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (String data : lines) {
                        writer.write(data);
                        writer.newLine();
                    }
                    System.out.println("Thong tin nhan vien da duoc xoa.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Khong tim thay nhan vien can xoa.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // In danh sach nhan vien ki luat
    public void InDanhSach() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-30s%-15s%-15s%-15s\n", "Ho Ten", "Ma Bo Phan", "Ma Phong", "Luong Ki Luat");
            // Bỏ qua dòng đầu tiên (ghi chú)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // kiểm tra và bỏ qua dòng trống
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");
                // Kiểm tra nếu nhân viên có lương khen thưởng
                if (data.length >= 7 && !data[7].trim().isEmpty()) {
                    String hoTen = data[0].trim();
                    String maBoPhan = data[1].trim();
                    String maPhong = data[2].trim();
                    String luongkiluat = data[7].trim();
                    System.out.printf("%-30s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong, luongkiluat);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // chinh sua thong tin ki luat
    public void ChinhSuaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can chinh sua: ");
        String hoTenToEdit = scanner.nextLine();
        // scanner.nextLine();
        System.out.print("Nhap thong tin moi:");
        System.out.print("Ho ten: ");
        String newHoTen = scanner.nextLine();
        System.out.print("Ma bo phan: ");
        String newMaBoPhan = scanner.nextLine();
        System.out.print("Ma phong: ");
        String newMaPhong = scanner.nextLine();
        System.out.print("Chuc vu: ");
        String newChucVu = scanner.nextLine();
        System.out.print("Ngay dang ky: ");
        String newNgayDangKy = scanner.nextLine();
        System.out.print("Ngay het han: ");
        String newNgayHetHan = scanner.nextLine();
        System.out.print("Luong ky luat: ");
        String newLuongKiLuat = scanner.nextLine();
        String filePath = "Data\\TruongBan_data\\QuanLy.csv";
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            long currentPosition = 0;
            boolean found = false;

            while (file.getFilePointer() < file.length()) {
                String line = file.readLine();
                String[] data = line.split(",");
                String currentHoTen = data[0].trim();

                if (currentHoTen.equals(hoTenToEdit)) { // kiem tra nhan vien can chinh sua
                    found = true;
                    break;
                }
                currentPosition = file.getFilePointer();

                if (file.getFilePointer() >= file.length()) {
                    break;
                }
            }
            // tim thay , di chuyen den vi tri can chỉnh sua
            if (found) {
                file.seek(currentPosition);
                file.writeBytes(newHoTen + "," + newMaBoPhan + "," + newMaPhong + "," + newChucVu + ","
                        + newNgayDangKy + "," + newNgayHetHan + "," + newLuongKiLuat + "\n");
                System.out.println("Thong tin nhan vien da duoc chinh sua.");
            } else {
                System.out.println("Khong tim thay nhan vien can chinh sua.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // tim kiem nhan vien ki luat
    public void TimKiemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Nhap thong tin can tim ( ho ten/ ma bo phan/ ma phong/ ngay ky(dd-mm-yyyy)/ ngay het han(dd-mm-yyyy) ): ");
        String timkiem = scanner.nextLine();
        try {
            // Đọc dữ liệu từ file và thực hiện tìm kiếm khen thưởng
            readDataFromFileAndSearch(timkiem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readDataFromFileAndSearch(String timkiem) throws FileNotFoundException {
        // Đường dẫn tới file CSV
        String filePath = "Data\\TruongBan_data\\QuanLy.csv";
        // Sử dụng Scanner để đọc dữ liệu từ file
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Bỏ qua dòng tiêu đề
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("Result:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String hoten = data[0];
                String mabophan = data[1];
                String maphong = data[2];
                String chucvu = data[3];
                String ngayky = data[4];
                String ngayhethan = data[5];
                String luongkiluat = data[7];

                if (hoten.contains(timkiem)
                        || mabophan.equals(timkiem)
                        || maphong.equals(timkiem)
                        || chucvu.equals(timkiem)
                        || ngayky.equals(timkiem)
                        || ngayhethan.equals(timkiem)) {

                    System.out.println("Ho ten: " + hoten);
                    System.out.println("Chuc vu: " + chucvu);
                    System.out.println("Luong ki luat: " + luongkiluat);
                    System.out.println("------------------------");
                } else {
                    System.out.println("khong co thong tin can tim");
                }
            }
        }
    }

}
