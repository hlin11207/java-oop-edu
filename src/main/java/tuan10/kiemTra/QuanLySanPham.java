package kiemTra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuanLySanPham {
    private List<SanPham> ds;

    public QuanLySanPham() {
        this.ds = new ArrayList<>();
    }

    public boolean themSanPham(SanPham sp) {
        boolean isExisted = ds.stream().anyMatch(p -> p.getMaSP().equals(sp.getMaSP()));
        if (isExisted) {
            System.out.println("Ma san pham da ton tai!");
            return false;
        }
        ds.add(sp);
        System.out.println("Them san pham thanh cong!");
        return true;
    }

    public boolean xoaSanPham(String maSP) {
        boolean isRemoved = ds.removeIf(sp -> sp.getMaSP().equals(maSP));
        if (isRemoved) {
            System.out.println("Da xoa san pham thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham can xoa!");
        }
        return isRemoved;
    }

    public void suaSoLuongTon(String maSP, int soLuongMoi) {
        Optional<SanPham> spCanSua = ds.stream().filter(sp -> sp.getMaSP().equals(maSP)).findFirst();
        if (spCanSua.isPresent()) {
            spCanSua.get().setSoLuongTon(soLuongMoi);
            System.out.println("Cap nhat so luong ton kho thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham can sua!");
        }
    }

    public List<SanPham> xuatSanPhamTheoLoai(String loai) {
        if (loai.equalsIgnoreCase("Dien tu")) {
            return ds.stream().filter(sp -> sp instanceof SanPhamDienTu).collect(Collectors.toList());
        } else if (loai.equalsIgnoreCase("Thuc pham")) {
            return ds.stream().filter(sp -> sp instanceof SanPhamThucPham).collect(Collectors.toList());
        } else {
            System.out.println("Loai khong hop le!");
            return new ArrayList<>();
        }
    }

    public List<SanPham> xuatSanPhamGiaBanCaoNhat() {
        if (ds.isEmpty()) {
            return new ArrayList<>();
        }
        Optional<Double> maxGiaBan = ds.stream().map(SanPham::tinhGiaBan).max(Double::compare);
        if (maxGiaBan.isPresent()) {
            double max = maxGiaBan.get();
            return ds.stream().filter(sp -> sp.tinhGiaBan() == max).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void inDanSach(List<SanPham> ls) {
        if (ls.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        for (SanPham sp : ls) {
            System.out.println(sp.toString());
        }
    }
}
