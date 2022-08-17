package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class SaveCourses {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Student> students = new ArrayList<>();

//		Student student1 = new Student();
//		student1.setAge(23);
//		student1.setName("Akash");
//
//		Student student2 = new Student();
//		student2.setAge(28);
//		student2.setName("Siva");
//
//		Student student3 = new Student();
//		student3.setAge(30);
//		student3.setName("bharathi");

		Student student1 = entityManager.find(Student.class, 1);
		Student student2 = entityManager.find(Student.class, 2);
		Student student3 = entityManager.find(Student.class, 3);

		students.add(student1);
		students.add(student2);
		students.add(student3);

		Course course = new Course();
		course.setName("Hibernate");
		course.setCost(300000);
		course.setStudents(students);

		entityTransaction.begin();
		entityManager.persist(course);
		entityManager.persist(student1);// ===
		entityManager.persist(student2);// =====first time we need to persist the objects
		entityManager.persist(student3);// ===
		entityTransaction.commit();
		System.out.println("-----Data Stored-----");
	}
}
