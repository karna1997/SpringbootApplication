package com.example.First;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/show")
	public String showAll() {

		return "all employees";
	}

	@RequestMapping("/poststring")
	public String getString(@RequestBody String post) {
		System.out.println(post);
		return "value added successfully";
	}

	@RequestMapping(value = "/postint", method = RequestMethod.POST)
	public String getInteger(@RequestBody String post) {
		System.out.println(post);
		return "value inserted";
	}

	@RequestMapping("/putpost")
	public String putString(@RequestBody String post) {
		String value;
		value = "hello world";
		value = "post";
		System.out.println("updated value" + value);
		return "value updated";
	}

	@RequestMapping(value = "/putpostint", method = RequestMethod.PUT)
	public String putInteger(@RequestBody int post) {
		int a;
		a = 10;
		a = post;

		System.out.println("Updated value:-" + a);
		return "Value updated!";

	}

	@RequestMapping("/hashsetapi")
	public HashSet<Integer> HashSetAPI() {
		HashSet<Integer> set = new HashSet<>();
		set.add(12);
		set.add(30);
		set.add(15);
		set.add(40);
		return set;

	}

	@RequestMapping("/treesetapi")
	public TreeSet<Integer> TreeSetAPI() {
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(12);
		tset.add(2);
		tset.add(1);
		tset.add(5);
		tset.add(10);
		return tset;
	}

	@RequestMapping("/getstudentbyid/{id}")
	public String getEmployeebyid(@PathVariable String id) {
		Student s1 = new Student();
		int id1 = Integer.parseInt(id);
		boolean flag = false;
		s1.setId(10);
		s1.setAge(35);
		s1.setName("ABC");

		Student s2 = new Student();
		s2.setAge(40);
		s2.setId(20);
		s2.setName("XYZ");

		ArrayList<Student>studlist = new ArrayList<Student>();
		studlist.add(s1);
		studlist.add(s2);

		for (Student stud : studlist) {
			if (stud.getId() == id1) {
				flag = true;
			System.out.println(stud);
			}
		}
		if (flag == true) {

			return "Student found..!";
			
		} else {
			return "Student not found..!";
		}
	}
}
