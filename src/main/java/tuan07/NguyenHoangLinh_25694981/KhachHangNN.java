package NguyenHoangLinh_25694981;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class KhachHangNN extends KhachHang {
	private String quocTich;

	public KhachHangNN(String maKH, String hoTen, LocalDate ngayLHD, double soKW, double donGia,
					   String quocTich) throws Exception {
		super(maKH, hoTen, ngayLHD, soKW, donGia);
		setQuocTich(quocTich);
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) throws Exception {
		if (quocTich == null || quocTich.trim().isEmpty()) {
			throw new Exception("Loi: Quoc tich khong duoc de trong!");
		}
		this.quocTich = quocTich.trim();
	}

	@Override
	public double thanhTien() {
		return soKW * donGia;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return super.toString() + String.format(" | NN - %-23s | Thanh tien: %12s",
				quocTich, df.format(thanhTien()));
	}
}
