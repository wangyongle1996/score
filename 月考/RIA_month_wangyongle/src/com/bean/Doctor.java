package com.bean;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public class Doctor {
	private Integer id;
	private String name;
	private String gender;
	private String hobby;
	private String birth;
	private String deptName;
	public Doctor() {
		super();
	}
	public Doctor(Integer id, String name, String gender, String hobby,
			String birth, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.hobby = hobby;
		this.birth = birth;
		this.deptName = deptName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
