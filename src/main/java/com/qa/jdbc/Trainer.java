package com.qa.jdbc;

public class Trainer {

	private int id;

	private String name;

	private int age;

	private String specialism;

	public Trainer(int id, String name, int age, String specialism) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.specialism = specialism;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialism() {
		return this.specialism;
	}

	public void setSpecialism(String specialism) {
		this.specialism = specialism;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", specialism="
				+ this.specialism + "]";
	}

}
