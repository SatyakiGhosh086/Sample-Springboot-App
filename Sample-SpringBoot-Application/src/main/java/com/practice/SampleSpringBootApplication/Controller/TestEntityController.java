package com.practice.SampleSpringBootApplication.Controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SampleSpringBootApplication.Entity.TestEntity;
import com.practice.SampleSpringBootApplication.Service.TestEntityService;

@RestController
public class TestEntityController 
{
	@Autowired
	private TestEntityService testEntityService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/test/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody TestEntity testEntity)
	{
		return testEntityService.addStudent(testEntity);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/test/student/{studentId}/get")
	public TestEntity getByStudentId(@PathVariable int studentId)
	{
		return testEntityService.getByStudentId(studentId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/test/student/all/dept/{deptId}/get")
	public List<TestEntity> getAllStudentsByDeptId(int deptId)
	{
		return testEntityService.getAllStudentsByDeptId(deptId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/test/getStudent/query")
	public TestEntity getStudentByStudentIdAndDeptId(@QueryParam("studentId") int studentId, @QueryParam("deptId") int deptId)
	{
		return testEntityService.getStudentByStudentIdAndDeptId(studentId, deptId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/test/student/{studentId}/delete")
	public ResponseEntity<String> deleteStudentById(@PathVariable int studentId)
	{
		return testEntityService.deleteStudentById(studentId);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/test/student/{studentId}/update")
	public ResponseEntity<String> updateStudentByStudentId(@PathVariable int studentId, @RequestBody TestEntity updatedTestEntity)
	{
		return testEntityService.updateStudentById(studentId, updatedTestEntity);
	}
}
