package kiemTra;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {
    private LocalDate ngayHetHan;

    public SanPhamThucPham(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTon,
                           LocalDate ngayHetHan) {
        super(maSP, tenSP, ngaySanXuat, giaNhap, soLuongTon);
        this.ngayHetHan = ngayHetHan;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public double tinhGiaBan() {
        LocalDate today = LocalDate.now();
        if (ngayHetHan.isBefore(today)) {
            return 0;
        }
        return giaNhap + (giaNhap * 0.05);
    }

    @Override
    public String toString() {
        return super.toString() + " | Han su dung: " + ngayHetHan.format(dateFormatter);
    }
}
