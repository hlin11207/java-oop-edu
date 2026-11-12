package NguyenHoangLinh_25694981;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyKH implements IQuanLyKH {
	private List<KhachHang> ls;

	public QuanLyKH() {
		ls = new ArrayList<KhachHang>();
	}

	@Override
	public boolean themKH(KhachHang kh) {
		if (kh == null || ls.contains(kh)) {
			return false;
		}
		return ls.add(kh);
	}

	@Override
	public boolean capNhat(String ma, double gia) {
		for (KhachHang kh : ls) {
			if (kh.getMaKH().equalsIgnoreCase(ma)) {
				try {
					kh.setDonGia(gia);
					return true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public boolean xoaMa(String ma) {
		return ls.removeIf(kh -> kh.getMaKH().equalsIgnoreCase(ma));
	}

	@Override
	public void sapXep() {
		Collections.sort(ls, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				return o1.getMaKH().compareToIgnoreCase(o2.getMaKH());
			}
		});
	}

	@Override
	public List<KhachHang> getDanhSach() {
		return ls;
	}

	@Override
	public int tongSoLuongVN() {
		int count = 0;
		for (KhachHang kh : ls) {
			if (kh instanceof KhachHangVN) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int tongSoLuongNN() {
		int count = 0;
		for (KhachHang kh : ls) {
			if (kh instanceof KhachHangNN) {
				count++;
			}
		}
		return count;
	}

	@Override
	public double trungBinhThanhTienNN() {
		double tongTien = 0;
		int count = 0;
		for (KhachHang kh : ls) {
			if (kh instanceof KhachHangNN) {
				tongTien += kh.thanhTien();
				count++;
			}
		}
		return count == 0 ? 0 : tongTien / count;
	}

	@Override
	public List<KhachHang> xuatHoaDonTheoThangNam(int thang, int nam) {
		List<KhachHang> kq = new ArrayList<>();
		for (KhachHang kh : ls) {
			if (kh.getNgayLHD().getMonthValue() == thang && kh.getNgayLHD().getYear() == nam) {
				kq.add(kh);
			}
		}
		return kq;
	}
}
