package com.qa.jdbc;

public class Demo {

	public static void main(String[] args) {
		try (TrainerDAO dao = new TrainerDAO("jdbc:mysql://localhost:3306/global_logic", "root", "pass");) {
			System.out.println(dao.create("ED", 23, "SDET"));
			System.out.println(dao.read());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
