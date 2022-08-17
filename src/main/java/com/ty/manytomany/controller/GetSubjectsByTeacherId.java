package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class GetSubjectsByTeacherId {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Teacher teacher = entityManager.find(Teacher.class, 1);

		System.out.println("Teacher Id - " + teacher.getId());
		System.out.println("Teacher Name - " + teacher.getName());
		System.out.println("Tecaher Age - " + teacher.getAge());
		System.out.println("------------------------------");

		List<Subject> subjects = teacher.getSubjects();
		for (Subject sub : subjects) {
			System.out.println("Subject Id - " + sub.getId());
			System.out.println("Subject Name - " + sub.getName());
			System.out.println("Days to Complete - " + sub.getDays());
			System.out.println("------------------------------------");
		}
	}
}
