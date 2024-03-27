package com.practice.SampleSpringBootApplication.DTO;

public class TestModelDTO 
{
	private int studentId;
	private String firstName;
	private String lastName;
	private int deptId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public TestModelDTO(int studentId, String firstName, String lastName, int deptId) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptId = deptId;
	}
	
	public TestModelDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "TestEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptId=" + deptId + "]";
	}
	
}
