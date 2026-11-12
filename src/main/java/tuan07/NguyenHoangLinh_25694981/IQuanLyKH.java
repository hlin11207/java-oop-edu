package NguyenHoangLinh_25694981;

import java.util.List;

public interface IQuanLyKH {
	boolean themKH(KhachHang kh);
	boolean capNhat(String ma, double gia);
	boolean xoaMa(String ma);
	void sapXep();
	List<KhachHang> getDanhSach();
	int tongSoLuongVN();
	int tongSoLuongNN();
	double trungBinhThanhTienNN();
	List<KhachHang> xuatHoaDonTheoThangNam(int thang, int nam);
}
