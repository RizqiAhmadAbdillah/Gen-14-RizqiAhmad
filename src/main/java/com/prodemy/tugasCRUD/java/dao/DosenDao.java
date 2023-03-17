package dao;

import model.Dosen;
import java.sql.*;
import java.util.*;

public class DosenDao {
	private String url = "jdbc:postgresql://localhost:5432/kampusprodemy";
	private String username = "postgres";
	private String password = "nkmsprs.123";

	public List<Dosen> getAllDosen() {
		String query = "SELECT * FROM dosen ORDER BY kode_dosen ASC";
		List<Dosen> list = new ArrayList<Dosen>();

		try {
			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement st = db.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Dosen dosen = new Dosen();
				dosen.setKode_dosen(rs.getString("kode_dosen"));
				dosen.setNama_dosen(rs.getString("nama_dosen"));
				list.add(dosen);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	public Dosen getDosen(String kode_dosen) {
//		String query = "SELECT * FROM dosen WHERE LOWER(kode_dosen) LIKE LOWER('%?%') OR LOWER(nama_dosen) LIKE LOWER('%?%')";
		String query = "SELECT * FROM dosen WHERE LOWER(kode_dosen)=?";
//		List<Dosen> list = new ArrayList<Dosen>();
		Dosen dosen = new Dosen();
		dosen.setKode_dosen(kode_dosen);
		dosen.setNama_dosen(dosen.getNama_dosen());
		try {
			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, dosen.kode_dosen);
//			st.setString(2, dosen.kode_dosen);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				dosen.setKode_dosen(rs.getString("kode_dosen"));
				dosen.setNama_dosen(rs.getString("nama_dosen"));
//				list.add(dosen);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dosen;
	}

	public boolean addDosen(Dosen dosen) {
		String query = "INSERT INTO dosen(kode_dosen, nama_dosen) VALUES (?, ?)";
		boolean updated = false;
		try {
			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, dosen.kode_dosen);
			st.setString(2, dosen.nama_dosen);
			updated = st.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return updated;
	}

	public boolean editDosen(String kode_dosen, String nama_dosen) {
		String query = "UPDATE dosen SET nama_dosen=? WHERE kode_dosen=?";
//		String query = "UPDATE dosen SET nama_dosen='?' WHERE ?";
//		List<Dosen> list = new ArrayList<Dosen>();
//		Dosen dosenOld = new Dosen();
//		dosenOld.setKode_dosen(dosen.nama_dosen);
//		dosenOld.setNama_dosen(dosen.kode_dosen);
		boolean updated = false;
		try {
			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, nama_dosen);
			st.setString(2, kode_dosen);
			updated = st.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return updated;
	}

	public boolean deleteDosen(Dosen dosen) {
		String query = "DELETE FROM dosen WHERE kode_dosen=?";
//		List<Dosen> list = new ArrayList<Dosen>();
		boolean updated = false;
		try {
			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, dosen.kode_dosen);
			updated = st.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return updated;
	}
}
