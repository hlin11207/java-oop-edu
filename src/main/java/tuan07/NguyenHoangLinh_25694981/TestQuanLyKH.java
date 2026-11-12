package NguyenHoangLinh_25694981;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TestQuanLyKH {
	private static QuanLyKH ql = new QuanLyKH();
	private static Scanner sc = new Scanner(System.in);
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		napDuLieuMau();
		int chon = -1;
		do {
			System.out.println("\n================ QUAN LY HOA DON TIEN DIEN ================");
			System.out.println("1. Xuat danh sach khach hang");
			System.out.println("2. Them khach hang moi");
			System.out.println("3. Cap nhat don gia theo ma khach hang");
			System.out.println("4. Xoa khach hang theo ma");
			System.out.println("5. Sap xep danh sach tang dan theo ma khach hang");
			System.out.println("6. Thong ke tong so luong tung loai khach hang");
			System.out.println("7. Tinh trung binh thanh tien cua khach hang nuoc ngoai");
			System.out.println("8. Xuat hoa don theo thang/nam");
			System.out.println("0. Thoat");
			System.out.print("Chon chuc nang: ");

			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				chon = -1;
			}

			switch (chon) {
			case 1:
				xuatDanhSach(ql.getDanhSach());
				break;
			case 2:
				themKhachHangTuBanPhim();
				break;
			case 3:
				System.out.print("Nhap ma KH can cap nhat gia: ");
				String maCN = sc.nextLine();
				System.out.print("Nhap don gia moi: ");
				double giaMoi = Double.parseDouble(sc.nextLine());
				if (ql.capNhat(maCN, giaMoi)) {
					System.out.println("-> Cap nhat thanh cong!");
				} else {
					System.out.println("-> Khong tim thay ma KH hoac gia khong hop le!");
				}
				break;
			case 4:
				System.out.print("Nhap ma KH can xoa: ");
				String maXoa = sc.nextLine();
				if (ql.xoaMa(maXoa)) {
					System.out.println("-> Xoa thanh cong!");
				} else {
					System.out.println("-> Khong tim thay ma KH can xoa!");
				}
				break;
			case 5:
				ql.sapXep();
				System.out.println("-> Da sap xep danh sach theo ma KH!");
				xuatDanhSach(ql.getDanhSach());
				break;
			case 6:
				System.out.println("Tong so luong khach hang Viet Nam: " + ql.tongSoLuongVN());
				System.out.println("Tong so luong khach hang Nuoc Ngoai: " + ql.tongSoLuongNN());
				break;
			case 7:
				DecimalFormat df = new DecimalFormat("#,##0.00");
				System.out.println("Trung binh thanh tien khach hang nuoc ngoai: "
						+ df.format(ql.trungBinhThanhTienNN()));
				break;
			case 8:
				System.out.print("Nhap thang: ");
				int thang = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap nam: ");
				int nam = Integer.parseInt(sc.nextLine());
				List<KhachHang> dsThangNam = ql.xuatHoaDonTheoThangNam(thang, nam);
				System.out.println("--- Hoa don thang " + thang + "/" + nam + " ---");
				xuatDanhSach(dsThangNam);
				break;
			case 0:
				System.out.println("Ket thuc chuong trinh.");
				break;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		} while (chon != 0);
	}

	private static void napDuLieuMau() {
		try {
			ql.themKH(new KhachHangVN("VN02", "Nguyen Van An", LocalDate.of(2026, 9, 15),
					120, 2000, "Sinh hoat", 100));
			ql.themKH(new KhachHangVN("VN01", "Tran Thi Binh", LocalDate.of(2026, 10, 20),
					80, 2000, "Kinh doanh", 100));
			ql.themKH(new KhachHangNN("NN02", "John Smith", LocalDate.of(2026, 9, 25),
					200, 3000, "My"));
			ql.themKH(new KhachHangNN("NN01", "Tanaka Kenji", LocalDate.of(2026, 11, 5),
					150, 3000, "Nhat Ban"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void xuatDanhSach(List<KhachHang> list) {
		if (list.isEmpty()) {
			System.out.println("Danh sach trong!");
			return;
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-20s | %-12s | %8s | %10s | %s%n",
				"Ma KH", "Ho Ten", "Ngay LHD", "So KW", "Don Gia", "Thong Tin Chi Tiet & Thanh Tien");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (KhachHang kh : list) {
			System.out.println(kh);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}

	private static void themKhachHangTuBanPhim() {
		try {
			System.out.print("Chon loai khach hang (1 - Viet Nam, 2 - Nuoc Ngoai): ");
			int loai = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap ma KH: ");
			String ma = sc.nextLine();
			System.out.print("Nhap ho ten: ");
			String ten = sc.nextLine();
			System.out.print("Nhap ngay lap hoa don (dd/MM/yyyy): ");
			LocalDate ngay = LocalDate.parse(sc.nextLine(), dtf);
			System.out.print("Nhap so KW tieu thu: ");
			double kw = Double.parseDouble(sc.nextLine());
			System.out.print("Nhap don gia: ");
			double gia = Double.parseDouble(sc.nextLine());

			KhachHang kh;
			if (loai == 1) {
				System.out.print("Nhap doi tuong (Sinh hoat / Kinh doanh / San xuat): ");
				String dt = sc.nextLine();
				System.out.print("Nhap dinh muc: ");
				double dm = Double.parseDouble(sc.nextLine());
				kh = new KhachHangVN(ma, ten, ngay, kw, gia, dt, dm);
			} else if (loai == 2) {
				System.out.print("Nhap quoc tich: ");
				String qt = sc.nextLine();
				kh = new KhachHangNN(ma, ten, ngay, kw, gia, qt);
			} else {
				System.out.println("Loai khach hang khong hop le!");
				return;
			}

			if (ql.themKH(kh)) {
				System.out.println("-> Them khach hang thanh cong!");
			} else {
				System.out.println("-> Them that bai (Trung ma khach hang)!");
			}
		} catch (Exception e) {
			System.out.println("Loi nhap lieu: " + e.getMessage());
		}
	}
}
