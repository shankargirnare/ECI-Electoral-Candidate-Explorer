package com.eci.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eci.Entity.Candidate;
import com.eci.Utility.Utility;

public class Dao {
	ResultSet rs = null;
	List<Candidate> candidate = new ArrayList<Candidate>();

	public List<Candidate> getAllCandidates() {

		String query = "Select * from advjava193.Candidate";

		try {

			ResultSet rs = Utility.createConnection().createStatement().executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("name");
				String partyname = rs.getString("partyname");
				String state = rs.getString("state");
				String assembly = rs.getString("assembly");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");

				Candidate cd = new Candidate(id, name, partyname, state, assembly, gender, age);
				candidate.add(cd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return candidate;
	}

	public void insertCandidate() {

		String query = "INSERT INTO advjava193.candidate(c_id,name,partyname,state,assembly,gender,age) VALUES (?,?,?,?,?,?,?);";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id: ");
		int cid = sc.nextInt();
		System.out.println("Enter Candidate Name and Surname:");
		String name = sc.next();
		System.out.println("Enter Candidate Party:");
		String partyname = sc.next();
		sc.next();
		System.out.println("Enter Candidate State:");
		String state = sc.next();
		System.out.println("Enter Candidate Assembly Name:");
		String assembly = sc.next();
		System.out.println("Enter Candidate Gender: ");
		String gender = sc.next();
		System.out.println("Enter Candidate Age: ");
		int age = sc.nextInt();

		try {

			PreparedStatement stmt = Utility.createConnection().prepareStatement(query);

			stmt.setInt(1, cid);
			stmt.setString(2, name);
			stmt.setString(3, partyname);
			stmt.setString(4, state);
			stmt.setString(5, assembly);
			stmt.setString(6, gender);
			stmt.setInt(7, age);

			int ex = stmt.executeUpdate();
			if (ex > 0) {
				System.out.println("Data INSERTED Successfully.");
			} else {
				System.err.println("Something went Wrong.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCandidate() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Candidate New Id.");
		int updatedcid = sc.nextInt();
		System.out.println("Enter Candidate Name and Surname:");
		String name = sc.next();
		System.out.println("Enter Candidate Party:");
		String partyname = sc.next();
		System.out.println("Enter Candidate State:");
		String state = sc.next();
		System.out.println("Enter Candidate Assembly Name:");
		String assembly = sc.next();
		System.out.println("Enter Candidate Gender: ");
		String gender = sc.next();
		System.out.println("Enter Candidate Age: ");
		int age = sc.nextInt();
		System.out.println("Enter Candidate Old Id.");
		int oldcid = sc.nextInt();

		String sqlupdate = "UPDATE advjava193.candidate SET c_id = ?,name=?, partyname = ?,state = ?, assembly=?,gender = ?, age=? WHERE c_id=?; ";

		try {
			Connection conn = Utility.createConnection();
			PreparedStatement st = conn.prepareStatement(sqlupdate);
			st.setInt(1, updatedcid);
			st.setString(2, name);
			st.setString(3, partyname);
			st.setString(4, state);
			st.setString(5, assembly);
			st.setString(6, gender);
			st.setInt(7, age);
			st.setInt(8, oldcid);

			int ex = st.executeUpdate();

			if (ex > 0) {
				System.out.println("Data Updated Successfully.");

			}else {
				System.out.println("Something Went Wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteCandidate(int id) {

		String query = "DELETE FROM advjava193.candidate WHERE c_id = '" + id + "'";
		try {

			int rs = Utility.createConnection().createStatement().executeUpdate(query);
			if (rs > 0) {
				System.out.println("Data Deleted Successfully");
			} else {
				System.out.println("Something went Wrong");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
