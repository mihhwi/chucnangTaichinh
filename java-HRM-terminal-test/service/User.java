package service;

import java.util.HashMap;
import java.util.Scanner;

import core.HeThong;
import model.TaiKhoan;

public class User {
    public static TaiKhoan userAcount = new TaiKhoan();

    public static boolean checkEmail(String email) {
        String ePattern = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void login() {

        int selector = 10;
        System.out.println(HeThong.state);
        if (selector == 0) {
            HeThong.state = 0;
            System.out.println("thoat");
            return;
        }
        Scanner inputs = new Scanner(System.in);

        do {
            System.out.println("chon Quyen dang nhan:");
            System.out.println("1.nhan vien");
            System.out.println("2.quan tri vien");
            System.out.println("3.quan ly nhan su");
            System.out.println("4.quan ly nhan luc");
            System.out.println("5.quan ly tai chinh");
            System.out.println("6.truong ban");
            System.out.println("hoat nhan 0 de thoat ");
            System.out.print("nhan lua chon:");
            selector = inputs.nextInt();
            if (selector > 6 || selector < 0) {
                System.out.println("lua chon khong hop le vui long nhan lai");

            }
            System.out.println(selector);
            if (selector == 0) {
                System.out.println("thoat pham men hoan tat");

                HeThong.state = 0;
                return;
            }
        } while (selector < 0 || selector > 6);
        HashMap<String, String> listAcount = HeThong.getDATA(selector);
        System.out.println("-----------------------------------");
        inputs.nextLine();
        String userName;
        do {
            System.out.print("Nhan email nguoi dung:");
            userName = inputs.nextLine();
            if (!checkEmail(userName)) {
                System.out.println("----------------------------------------------");
                System.out.println("dinh dang email khong dung hay nhap lai email!");
                System.out.println("----------------------------------------------");
            }
        } while (!checkEmail(userName));

        System.out.print("nhap mat khau:");
        String userPass = inputs.nextLine();
        userAcount = new TaiKhoan(userName, userPass, selector);

        System.out.println("----------------------------------------------");
        boolean checkuser = false;
        boolean checkpass = false;
        String key = "";

        for (String keys : listAcount.keySet()) {
            if (userAcount.getUserName().equalsIgnoreCase(keys)) {
                key = keys;
                checkuser = true;
                break;
            }

        }
        if (checkuser) {
            if (userAcount.getPass().equalsIgnoreCase(listAcount.get(key))) {
                checkpass = true;
            }
        }
        if (checkpass && checkuser) {
            System.out.println("dang nhap thanh cong ");
            System.out.println("-------------------------------------------------");
            return;
        }
        if (checkpass == false && checkuser) {
            System.out.println("danh nhan that bai! ban da nhap sai mat khau");
            System.out.println("nhan 1 de dang nhap lai");
            System.out.println("nhan 0 de thoat khoi he thong");
            System.out.print("nhan lua chon:");
            selector = inputs.nextInt();
            if (selector == 1) {
                login();
                return;
            } else if (selector == 0) {
                HeThong.state = 0;
                return;
            }

        }
        if (checkuser == false) {
            userAcount = new TaiKhoan();
            System.out.println("dang  nhap that bai! tai khoan khong ton tai");
            System.out.println("nhan 1 de dang nhap lai");
            System.out.println("nhan 0 de thoat khoi he thong");
            System.out.print("nhan lua chon:");
            selector = inputs.nextInt();
            if (selector == 1) {
                login();
                return;
            } else if (selector == 0) {
                HeThong.state = 0;
                return;
            }
        }

    }
}