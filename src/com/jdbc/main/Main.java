package com.jdbc.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jdbc.entity.Student;
import com.jdbc.studentDao.StudentDao;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean value = false;

		while (true) {

			System.out.println("PRESS 1: Add the student");
			System.out.println("PRESS 2: Delete the student");
			System.out.println("PRESS 3: Update the student");
			System.out.println("PRESS 4: Show all student");
			System.out.println("PRESS 5: Exit");

			int choice = Integer.parseInt(br.readLine());

			if (choice == 1) {

				System.out.println("Enter student name:");
				String name = br.readLine();

				System.out.println("Enter student city:");
				String city = br.readLine();

				Student student = new Student(name, city);

				boolean b = StudentDao.insert(student);

				if (b) {
					System.out.println("Student details added succesfully.");
				} else {
					System.out.println("Something went wrong.");
				}

			} else if (choice == 2) {

				System.out.println("Enter student id:");
				int id = Integer.parseInt(br.readLine());

				boolean b = StudentDao.delete(id);

				if (b) {
					System.out.println("Student deleted succesfully.");
				} else {
					System.out.println("Something went wrong.");
				}

			} else if (choice == 3) {
				
				System.out.println("Enter student id:");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter student name:");
				String name = br.readLine();

				System.out.println("Enter student city:");
				String city = br.readLine();
				
				Student student=new Student(name, city);
				
				
				
				boolean b = StudentDao.update(id,student);
				
				if (b) {
					System.out.println("Student updated succesfully.");
				} else {
					System.out.println("Something went wrong.");
				}

			} else if (choice == 4) {

				StudentDao.show();
			} else {
				break;
			}

		}

		System.out.println("Visit again..");

	}

}
