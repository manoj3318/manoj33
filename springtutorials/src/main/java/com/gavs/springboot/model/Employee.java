package com.gavs.springboot.model;

public class Employee {
	private static int id;

	private int x;

	private int y;
	
	private  String name;
	
	public static int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	}

