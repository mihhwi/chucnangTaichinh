package model;

public class TaiKhoan {
    private String userName;
    private String pass;
    private int quyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String pass, int quyen) {
        this.userName = userName;
        this.pass = pass;
        this.quyen = quyen;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getQuyen() {
        return this.quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public String toString() {
        return this.userName + "|| " + this.pass + "||" + this.quyen;
    }
}
