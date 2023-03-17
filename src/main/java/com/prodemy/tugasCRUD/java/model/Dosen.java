package model;

public class Dosen {
	public String kode_dosen;
	public String nama_dosen;

	public Dosen() {
		super();
	}

	public Dosen(String kode_dosen, String nama_dosen) {
		super();
		this.kode_dosen = kode_dosen;
		this.nama_dosen = nama_dosen;
	}

	public String getKode_dosen() {
		return kode_dosen;
	}

	public void setKode_dosen(String kode_dosen) {
		this.kode_dosen = kode_dosen;
	}

	public String getNama_dosen() {
		return nama_dosen;
	}

	public void setNama_dosen(String nama_dosen) {
		this.nama_dosen = nama_dosen;
	}

	@Override
	public String toString() {
		return "Dosen [kode_dosen=" + kode_dosen + ", nama_dosen=" + nama_dosen + "]";
	}

}
