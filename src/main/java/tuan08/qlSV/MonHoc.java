package qlSV;

public enum MonHoc {
	LAP_TRINH_JAVA("Lap trinh Java", 450_000f),
	CO_SO_DU_LIEU("Co so du lieu", 450_000f),
	TOAN_ROI_RAC("Toan roi rac", 450_000f),
	MANG_MAY_TINH("Mang may tinh", 500_000f),
	TRI_TUE_NHAN_TAO("Tri tue nhan tao", 600_000f),
	KY_THUAT_PHAN_MEM("Ky thuat phan mem", 480_000f),
	LAP_TRINH_WEB("Lap trinh Web", 500_000f),
	HE_DIEU_HANH("He dieu hanh", 420_000f);

	private final String tenMon;
	private final float donGia;

	MonHoc(String tenMon, float donGia) {
		this.tenMon = tenMon;
		this.donGia = donGia;
	}

	public String getTenMon() {
		return tenMon;
	}

	public float getDonGia() {
		return donGia;
	}

	public static MonHoc fromTenMon(String tenMon) {
		for (MonHoc mh : values()) {
			if (mh.tenMon.equalsIgnoreCase(tenMon)) return mh;
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("%s (%,.0f VND/tin chi)", tenMon, donGia);
	}
}
