package NguyenHoangLinh_25694981;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class KhachHang {
	protected String maKH;
	protected String hoTen;
	protected LocalDate ngayLHD;
	protected double soKW;
	protected double donGia;

	public KhachHang(String maKH, String hoTen, LocalDate ngayLHD, double soKW, double donGia) throws Exception {
		setMaKH(maKH);
		setHoTen(hoTen);
		setNgayLHD(ngayLHD);
		setSoKW(soKW);
		setDonGia(donGia);
	}

	public abstract double thanhTien();

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) throws Exception {
		if (maKH == null || maKH.trim().isEmpty()) {
			throw new Exception("Loi: Ma khach hang khong duoc de trong!");
		}
		this.maKH = maKH.trim();
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen == null || hoTen.trim().isEmpty()) {
			throw new Exception("Loi: Ho ten khong duoc de trong!");
		}
		this.hoTen = hoTen.trim();
	}

	public LocalDate getNgayLHD() {
		return ngayLHD;
	}

	public void setNgayLHD(LocalDate ngay) throws Exception {
		if (ngay == null || ngay.isAfter(LocalDate.now())) {
			throw new Exception("Loi: Ngay lap hoa don khong hop le hoac la ngay tuong lai!");
		}
		this.ngayLHD = ngay;
	}

	public double getSoKW() {
		return soKW;
	}

	public void setSoKW(double soKW) throws Exception {
		if (soKW < 0) {
			throw new Exception("Loi: So KW tieu thu phai >= 0!");
		}
		this.soKW = soKW;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia <= 0) {
			throw new Exception("Loi: Don gia phai > 0!");
		}
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof KhachHang))
			return false;
		KhachHang other = (KhachHang) obj;
		return maKH != null && maKH.equalsIgnoreCase(other.maKH);
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return String.format("%-10s | %-20s | %-12s | %8.1f | %10s",
				maKH, hoTen, ngayLHD.format(dtf), soKW, df.format(donGia));
	}
}
