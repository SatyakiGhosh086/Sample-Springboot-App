package com.practice.SampleSpringBootApplication.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.SampleSpringBootApplication.Entity.TestEntity;
import com.practice.SampleSpringBootApplication.Repository.TestEntityRepository;

@Service
public class TestEntityService 
{
	@Autowired
	private TestEntityRepository testEntityRepository;
	
	public ResponseEntity<String> addStudent(TestEntity testEntity)
	{
		testEntityRepository.save(testEntity);
		return new ResponseEntity<>(testEntity.toString(),HttpStatus.OK);
	}
	
	public TestEntity getByStudentId(int studentId)
	{
		return testEntityRepository.findByStudentId(studentId);
	}
	
	public List<TestEntity> getAllStudentsByDeptId(int deptId)
	{
		List<TestEntity> students = new ArrayList<>();
		testEntityRepository.findAllByDeptId(deptId).forEach(students::add);
		return students;
	}
	
	public TestEntity getStudentByStudentIdAndDeptId(int studentId, int deptId)
	{
		return testEntityRepository.findByStudentIdAndDeptId(studentId, deptId);
	}
	
	public ResponseEntity<String> deleteStudentById(int studentId)
	{
		testEntityRepository.deleteById(studentId);
		return new ResponseEntity<>("Student entry has been deleted : "+studentId,HttpStatus.OK);
	}
	
	public ResponseEntity<String> updateStudentById(int studentId, TestEntity updatedTestEntity)
	{
		TestEntity testEntity = testEntityRepository.findByStudentId(studentId);
		testEntity.setFirstName(updatedTestEntity.getFirstName());
		testEntity.setLastName(updatedTestEntity.getLastName());
		testEntity.setDeptId(updatedTestEntity.getDeptId());
		
		testEntityRepository.save(testEntity);
		
		return new ResponseEntity<>("Student Entry has been updated : "+studentId,HttpStatus.OK);
	}
}
