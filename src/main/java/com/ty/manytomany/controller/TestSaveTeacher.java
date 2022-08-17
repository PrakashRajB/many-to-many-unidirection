package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class TestSaveTeacher {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Subject> subjects = new ArrayList<>();

//		Subject sub1 = new Subject();
//		sub1.setName("Computer");
//		sub1.setDays(60);
//
//		Subject sub2 = new Subject();
//		sub2.setName("English");
//		sub2.setDays(40);
//
//		Subject sub3 = new Subject();
//		sub3.setName("Java");
//		sub3.setDays(90);
//
//		subjects.add(sub1);
//		subjects.add(sub2);
//		subjects.add(sub3);
//
//		Teacher teacher = new Teacher();
//		teacher.setName("Bharathi");
//		teacher.setAge(29);
//		teacher.setSubjects(subjects);
//
//		entityTransaction.begin();
//		entityManager.persist(teacher);
//		entityManager.persist(sub1);
//		entityManager.persist(sub2);
//		entityManager.persist(sub3);
//		entityTransaction.commit();

		Teacher teacher2 = entityManager.find(Teacher.class, 2);
		Subject subject = entityManager.find(Subject.class, 1);
		List<Subject> subjects2 = teacher2.getSubjects();

		subjects2.add(subject);

		teacher2.setSubjects(subjects2);
		entityTransaction.begin();
		entityManager.persist(teacher2);
		entityManager.persist(subject);

		entityTransaction.commit();

		System.out.println("----Data Stored----");

	}

}
