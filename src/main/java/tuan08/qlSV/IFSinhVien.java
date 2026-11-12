package qlSV;

import java.util.List;

public interface IFSinhVien {
	boolean them(SinhVien sv);
	boolean sua(String maSV, SinhVien svMoi);
	boolean xoa(String maSV);
	boolean xoaTatCa();
	List<SinhVien> layTatCa();
	SinhVien timTheoMa(String maSV);
	List<SinhVien> timTheoTen(String tuKhoa);
	List<SinhVien> timTheoLop(String lop);
	List<SinhVien> timTheoloai(String loai);
	List<SinhVien> timTheoMon(MonHoc monHoc);
	int tongSoLuong();
	double tongThanhTien();
	List<SinhVien> sapXepTheoTen();
	List<SinhVien> sapXepTheoThanhTienGiamDan();
}
