package com.mcz.docmanager.repository;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JdbcTemplate {
	private Connection conn = null;

	private Connection connect() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			synchronized (JdbcTemplate.class) {
				Class.forName("org.h2.Driver");
				Connection conn = DriverManager.getConnection("jdbc:h2:~/documents", "sa", "");
				this.conn = conn;
			}
		}
		return this.conn;
	}

	public long save(String data) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = connect();

		String latestId = "SELECT TOP 1 ID FROM DOCUMENT ORDER BY ID DESC";
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(latestId);
		result.next();
		int id = result.getInt("id");
		String sql = "INSERT INTO DOCUMENT VALUES(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setLong(1, ++id);
		Clob clob = st.getConnection().createClob();
		clob.setString(1, data);
		st.setClob(2, clob);
		boolean execute = st.execute();
		return id;
	}

	public Clob findById(Integer id) throws SQLException, ClassNotFoundException {

		Connection conn = connect();

		String sql = "SELECT FILE FROM DOCUMENT WHERE ID = " + id;
		Statement st = conn.createStatement();

		ResultSet resultSet = st.executeQuery(sql);
		resultSet.next();
		return resultSet.getClob("file");

	}

}
