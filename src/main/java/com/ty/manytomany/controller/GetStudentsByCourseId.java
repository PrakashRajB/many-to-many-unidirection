package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class GetStudentsByCourseId {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Course course = entityManager.find(Course.class, 1);
		System.out.println("Course Id - " + course.getId());
		System.out.println("Course Name - " + course.getName());
		System.out.println("Course Cost - " + course.getCost());

		List<Student> students = course.getStudents();
		for (Student s : students) {
			System.out.println("Stuent Id - " + s.getId());
			System.out.println("Student Name - " + s.getName());
			System.out.println("Student Age - " + s.getAge());
			System.out.println("-------------------------------------------");
		}
	}

}
