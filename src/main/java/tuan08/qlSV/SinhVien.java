package qlSV;

import java.time.LocalDate;

public class SinhVien {
	protected String maSV;
	protected String hoTen;
	protected LocalDate ngaySinh;
	protected String lop;
	protected int soTinChi;
	protected MonHoc monHoc;

	public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, MonHoc monHoc) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.soTinChi = soTinChi;
		this.monHoc = monHoc;
	}

	public double thanhTien() {
		return soTinChi * monHoc.getDonGia();
	}

	public String getLoai() {
		return "Sinhvien";
	}

	public String getThongTinRieng() {
		return "";
	}

	public String getMaSV() {
		return maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public String getLop() {
		return lop;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public float getDonGia() {
		return monHoc.getDonGia();
	}

	public String getTenMonHoc() {
		return monHoc.getTenMon();
	}

	@Override
	public String toString() {
		return String.format("[%s] %s | Lop: %s | NS: %s | Mon: %s | (%d tin x %,.0f) | TT: %,.0f VND",
				maSV, hoTen, lop, ngaySinh, monHoc.getTenMon(), soTinChi, monHoc.getDonGia(), thanhTien());
	}
}
