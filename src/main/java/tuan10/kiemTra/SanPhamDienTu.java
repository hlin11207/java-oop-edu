package kiemTra;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham {
    private int thoiGianBaoHanh;

    public SanPhamDienTu(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTon,
                         int thoiGianBaoHanh) {
        super(maSP, tenSP, ngaySanXuat, giaNhap, soLuongTon);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    @Override
    public double tinhGiaBan() {
        return giaNhap + (giaNhap * 0.10) + (thoiGianBaoHanh * 50000);
    }

    @Override
    public String toString() {
        return super.toString() + " | Bao hanh: " + thoiGianBaoHanh + "thang";
    }
}
