package com.qa.jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO implements Closeable {

	private final Connection conn;

	public TrainerDAO(String url, String user, String pass) throws SQLException {
		super();
		this.conn = DriverManager.getConnection(url, user, pass);
	}

	public int create(String name, int age, String specialism) {
		try (PreparedStatement stmnt = conn
				.prepareStatement("INSERT INTO trainer (name, age, specialism) VALUES (?, ?, ?)");) {
			stmnt.setString(1, name);
			stmnt.setInt(2, age);
			stmnt.setString(3, specialism);

			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Trainer> read() {
		List<Trainer> trainers = new ArrayList<>();

		try (Statement stmnt = conn.createStatement();
				ResultSet results = stmnt.executeQuery("SELECT * FROM trainer");) {
			while (results.next()) {
				int id = results.getInt(1);
				String name = results.getString("name");
				String specialism = results.getString("specialism");
				int age = results.getInt("age");

				trainers.add(new Trainer(id, name, age, specialism));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainers;
	}

	public int update(String name, int age, String specialism, int id) {
		try (PreparedStatement stmnt = conn
				.prepareStatement("UPDATE trainer SET name = ?, age = ?, specialism = ? WHERE id = ?");) {
			stmnt.setString(1, name);
			stmnt.setInt(2, age);
			stmnt.setString(3, specialism);
			stmnt.setInt(4, id);
			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try (PreparedStatement stmnt = conn.prepareStatement("DELETE FROM trainer WHERE id = ?");) {
			stmnt.setInt(1, id);
			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void close() throws IOException {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
