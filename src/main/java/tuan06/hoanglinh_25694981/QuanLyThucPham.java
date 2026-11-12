package hoanglinh_25694981;

import java.time.LocalDate;

public class QuanLyThucPham {
    private HangThucPham[] danhSach;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    public QuanLyThucPham() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0;
    }

    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        HangThucPham[] mangMoi = new HangThucPham[kichThuocMoi];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }

        danhSach = mangMoi;
        khaNang = kichThuocMoi;
    }

    public int timViTriTheoMa(String maHang) {
        if (maHang == null)
            return -1;

        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang))
                return i;
        }

        return -1;
    }

    public int timViTriTheoId(int id) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getId() == id)
                return i;
        }

        return -1;
    }

    public boolean them(HangThucPham h) {
        if (h == null)
            return false;

        if (timViTriTheoMa(h.getMaHang()) != -1) {
            System.out.println("Hang " + h.getMaHang() + " da ton tai!");
            return false;
        }

        if (soLuong == khaNang)
            moRongMang();

        danhSach[soLuong] = h;
        soLuong++;

        return true;
    }

    public boolean xoa(int id) {
        int viTri = timViTriTheoId(id);

        if (viTri == -1) {
            System.out.println("Khong tim thay hang co id " + id);
            return false;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }

        danhSach[soLuong - 1] = null;
        soLuong--;

        return true;
    }

    public boolean sua(int id, String tenMoi, LocalDate ngaySXMoi,
                       LocalDate ngayHHMoi, double giaMoi) {
        int viTri = timViTriTheoId(id);

        if (viTri == -1) {
            System.out.println("Khong tim thay hang co id " + id);
            return false;
        }

        HangThucPham h = danhSach[viTri];

        h.setTenHang(tenMoi);
        h.setNgaySanXuat(ngaySXMoi);
        h.setNgayHetHan(ngayHHMoi);
        h.setGia(giaMoi);

        return true;
    }

    public HangThucPham timTheoId(int id) {
        int viTri = timViTriTheoId(id);

        if (viTri == -1)
            return null;

        return danhSach[viTri];
    }

    public void sapXepTheoGia(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                        ? danhSach[i].getGia() > danhSach[j].getGia()
                        : danhSach[i].getGia() < danhSach[j].getGia();

                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println("Da sap xep theo gia " +
                (tangDan ? "tang dan" : "giam dan"));
    }

    public void sapXepTheoNgaySanXuat(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                        ? danhSach[i].getNgaySanXuat().isAfter(danhSach[j].getNgaySanXuat())
                        : danhSach[i].getNgaySanXuat().isBefore(danhSach[j].getNgaySanXuat());

                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println("Da sap xep theo ngay SX " +
                (tangDan ? "tang dan" : "giam dan"));
    }

    public void sapXepTheoNgayHetHan(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                        ? danhSach[i].getNgayHetHan().isAfter(danhSach[j].getNgayHetHan())
                        : danhSach[i].getNgayHetHan().isBefore(danhSach[j].getNgayHetHan());

                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println("Da sap xep theo ngay HH " +
                (tangDan ? "tang dan" : "giam dan"));
    }

    public QuanLyThucPham timTheoTienTo(String tuKhoa) {
        QuanLyThucPham ketQua = new QuanLyThucPham();

        if (tuKhoa == null)
            return ketQua;

        String tk = tuKhoa.toLowerCase().trim();

        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().startsWith(tk))
                ketQua.them(danhSach[i]);
        }

        return ketQua;
    }

    public QuanLyThucPham timTheoHauTo(String tuKhoa) {
        QuanLyThucPham ketQua = new QuanLyThucPham();

        if (tuKhoa == null)
            return ketQua;

        String tk = tuKhoa.toLowerCase().trim();

        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().endsWith(tk))
                ketQua.them(danhSach[i]);
        }

        return ketQua;
    }

    public QuanLyThucPham timGanGiong(String tuKhoa) {
        QuanLyThucPham ketQua = new QuanLyThucPham();

        if (tuKhoa == null)
            return ketQua;

        String tk = tuKhoa.toLowerCase().trim();

        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().contains(tk))
                ketQua.them(danhSach[i]);
        }

        return ketQua;
    }

    public QuanLyThucPham locTheoNgaySanXuat(LocalDate tuNgay, LocalDate denNgay) {
        QuanLyThucPham ketQua = new QuanLyThucPham();

        if (tuNgay == null || denNgay == null || tuNgay.isAfter(denNgay))
            return ketQua;

        for (int i = 0; i < soLuong; i++) {
            LocalDate ngaySX = danhSach[i].getNgaySanXuat();

            if (!ngaySX.isBefore(tuNgay) && !ngaySX.isAfter(denNgay))
                ketQua.them(danhSach[i]);
        }

        return ketQua;
    }

    public QuanLyThucPham trichLocTheoNgaySanXuat(LocalDate tuNgay, LocalDate denNgay) {
        return locTheoNgaySanXuat(tuNgay, denNgay);
    }

    public QuanLyThucPham trichLocTheoNgayHetHan(LocalDate tuNgay, LocalDate denNgay) {
        QuanLyThucPham ketQua = new QuanLyThucPham();

        if (tuNgay == null || denNgay == null || tuNgay.isAfter(denNgay))
            return ketQua;

        for (int i = 0; i < soLuong; i++) {
            LocalDate ngayHH = danhSach[i].getNgayHetHan();

            if (!ngayHH.isBefore(tuNgay) && !ngayHH.isAfter(denNgay))
                ketQua.them(danhSach[i]);
        }

        return ketQua;
    }

    public int tinhTongSoLuong() {
        return soLuong;
    }

    public double tinhTongGiaTri() {
        double tong = 0;

        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].getGia();
        }

        return tong;
    }

    public void thongKeTheoThang() {
        if (soLuong == 0) {
            System.out.println("Danh sach trong.");
            return;
        }

        int[] demTheoThang = new int[13];

        for (int i = 0; i < soLuong; i++) {
            int thang = danhSach[i].getNgaySanXuat().getMonthValue();
            demTheoThang[thang]++;
        }

        System.out.println("THONG KE SAN PHAM THEO THANG SAN XUAT:");

        for (int t = 1; t <= 12; t++) {
            if (demTheoThang[t] > 0)
                System.out.println("Thang " + t + ": " + demTheoThang[t] + " san pham");
        }
    }

    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sach trong.");
            return;
        }

        System.out.println("\n+------+-----------+--------------------+------------+------------+------------+");
        System.out.println("| ID   | Ma hang   | Ten hang           | Ngay SX    | Ngay HH    | Gia        |");
        System.out.println("+------+-----------+--------------------+------------+------------+------------+");

        for (int i = 0; i < soLuong; i++)
            System.out.println(danhSach[i]);

        System.out.println("+------+-----------+--------------------+------------+------------+------------+");
        System.out.println("Tong: " + soLuong + " san pham.");
    }

    public int laySoLuong() {
        return soLuong;
    }
}