package NguyenHoangLinh_25694981;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class KhachHangVN extends KhachHang {
	private String doiTuong;
	private double dinhMuc;

	public KhachHangVN(String maKH, String hoTen, LocalDate ngayLHD, double soKW, double donGia,
					   String doiTuong, double dinhMuc) throws Exception {
		super(maKH, hoTen, ngayLHD, soKW, donGia);
		setDoiTuong(doiTuong);
		setDinhMuc(dinhMuc);
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) throws Exception {
		if (doiTuong == null || doiTuong.trim().isEmpty()) {
			throw new Exception("Loi: Doi tuong khach hang khong duoc de trong!");
		}
		this.doiTuong = doiTuong.trim();
	}

	public double getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(double dinhMuc) throws Exception {
		if (dinhMuc <= 0) {
			throw new Exception("Loi: Dinh muc phai > 0!");
		}
		this.dinhMuc = dinhMuc;
	}

	@Override
	public double thanhTien() {
		return soKW <= dinhMuc
				? soKW * donGia
				: dinhMuc * donGia + (soKW - dinhMuc) * donGia * 2.5;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return super.toString() + String.format(" | VN - %-12s | DM: %6.1f | Thanh tien: %12s",
				doiTuong, dinhMuc, df.format(thanhTien()));
	}
}
