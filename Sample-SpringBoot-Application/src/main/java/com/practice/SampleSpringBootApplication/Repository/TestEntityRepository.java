package com.practice.SampleSpringBootApplication.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.SampleSpringBootApplication.Entity.TestEntity;

public interface TestEntityRepository extends CrudRepository<TestEntity, Integer>
{
	public TestEntity findByStudentId(int studentId);
	public List<TestEntity> findAllByDeptId(int deptId);
	public TestEntity findByStudentIdAndDeptId(int studentId, int deptId);
}
