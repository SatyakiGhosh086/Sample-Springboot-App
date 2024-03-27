package com.practice.SampleSpringBootApplication.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.SampleSpringBootApplication.DTO.TestModelDTO;
import com.practice.SampleSpringBootApplication.Entity.TestEntity;
import com.practice.SampleSpringBootApplication.Repository.TestEntityRepository;

@Service
public class TestEntityService 
{
	@Autowired
	private TestEntityRepository testEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<String> addStudent(TestModelDTO testModelDto)
	{
		TestEntity testEntity = modelMapper.map(testModelDto, TestEntity.class);
		testEntityRepository.save(testEntity);
		
		testModelDto = modelMapper.map(testEntity, TestModelDTO.class);
		return new ResponseEntity<>(testModelDto.toString(),HttpStatus.OK);
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
	
	public ResponseEntity<String> updateStudentById(int studentId, TestModelDTO updatedTestModel)
	{
		TestEntity testEntity = testEntityRepository.findByStudentId(studentId);
		testEntity.setFirstName(updatedTestModel.getFirstName());
		testEntity.setLastName(updatedTestModel.getLastName());
		testEntity.setDeptId(updatedTestModel.getDeptId());
		
		testEntityRepository.save(testEntity);
		
		TestModelDTO testModelDto = modelMapper.map(testEntity, TestModelDTO.class);
		
		return new ResponseEntity<>("Student Entry has been updated : "+studentId,HttpStatus.OK);
	}
}
