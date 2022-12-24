package com.jdbc.studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.connection.ConnectionProvider;
import com.jdbc.entity.Student;

public class StudentDao {

	private static Connection con = null;
	private static PreparedStatement ps = null;

	public static boolean insert(Student student) throws SQLException {

		try {
			con = ConnectionProvider.getConnection();

			String sql = "insert into student(sname,scity) values(?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, student.getSname());
			ps.setString(2, student.getScity());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

		return true;
	}

	public static boolean delete(int id) throws SQLException {

		try {
			con = ConnectionProvider.getConnection();

			String sql = "delete from student where sid=?";

			ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

		return true;

	}

	public static void show() throws SQLException {

		try {
			con = ConnectionProvider.getConnection();

			String sql = "select * from student";

			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println("*************************");
			}

			statement.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

	}

	public static boolean update(int id, Student student) throws SQLException {
		try {
			con = ConnectionProvider.getConnection();

			String sql = "update student set sname=? ,scity=? where sid=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, student.getSname());
			ps.setString(2, student.getScity());
			ps.setInt(3, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

		return true;

	}

}
