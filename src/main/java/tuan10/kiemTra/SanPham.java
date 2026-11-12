package kiemTra;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class SanPham {
    protected String maSP;
    protected String tenSP;
    protected LocalDate ngaySanXuat;
    protected double giaNhap;
    protected int soLuongTon;

    protected DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected Locale localeVN = new Locale("vi", "VN");
    protected NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);

    public SanPham(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTon) {
        super();
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ngaySanXuat = ngaySanXuat;
        this.giaNhap = giaNhap;
        this.soLuongTon = soLuongTon;
    }

    public abstract double tinhGiaBan();

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return "Ma SP: " + maSP +
                " | Ten: " + tenSP +
                " | NSX: " + ngaySanXuat.format(dateFormatter) +
                " | Gia nhap: " + currencyFormatter.format(giaNhap) +
                " | Ton kho: " + soLuongTon +
                " | Gia ban: " + currencyFormatter.format(tinhGiaBan());
    }
}
