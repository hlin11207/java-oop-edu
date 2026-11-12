package kiemTra;

import java.time.LocalDate;

public class TestSanPham {

    public static void main(String[] args) {
        QuanLySanPham ql = new QuanLySanPham();

        LocalDate nsx1 = LocalDate.of(2023, 10, 1);
        LocalDate hsd1 = LocalDate.of(2026, 10, 1);
        LocalDate hsd2 = LocalDate.of(2022, 10, 1);

        SanPham sp1 = new SanPhamDienTu("DT01", "Tivi Sony", nsx1, 10000000, 10, 24);
        SanPham sp2 = new SanPhamDienTu("DT02", "Tu lanh Toshiba", nsx1, 15000000, 5, 12);
        SanPham sp3 = new SanPhamDienTu("DT03", "Dien thoai Samsung", nsx1, 5000000, 20, 12);
        SanPham sp4 = new SanPhamThucPham("TP01", "Sua tuoi Vinamilk", nsx1, 20000, 100, hsd1);
        SanPham sp5 = new SanPhamThucPham("TP02", "Mi Hao Hao", nsx1, 10000, 50, hsd2);

        ql.themSanPham(sp1);
        ql.themSanPham(sp2);
        ql.themSanPham(sp3);
        ql.themSanPham(sp4);
        ql.themSanPham(sp5);

        SanPham spTrungMa = new SanPhamDienTu("DT01", "Tivi Sony", nsx1, 8000000, 10, 12);
        ql.themSanPham(spTrungMa);

        System.out.println("\n--- Sua so luong ton kho ---");
        ql.suaSoLuongTon("DT01", 15);
        ql.suaSoLuongTon("Sp_khong_ton_tai", 10);

        System.out.println("\n--- Danh sach theo loai dien tu ---");
        ql.inDanSach(ql.xuatSanPhamTheoLoai("Dien tu"));

        System.out.println("\n--- Danh sach theo loai thuc pham ---");
        ql.inDanSach(ql.xuatSanPhamTheoLoai("Thuc pham"));

        System.out.println("\n--- San pham co gia ban cao nhat ---");
        ql.inDanSach(ql.xuatSanPhamGiaBanCaoNhat());

        System.out.println("\n--- Xoa san pham ---");
        ql.xoaSanPham("DT02");

        System.out.println("\n--- Danh sach sau khi xoa san pham ---");
        ql.inDanSach(ql.xuatSanPhamTheoLoai("Dien tu"));
    }
}
