package com.dao;

import java.util.List;

import com.bean.Doctor;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public interface IDoctorDao {
	public List<Doctor> selectAllDoctors();
	public Integer insertDoctor(Doctor d);
	public Integer updateDoctor(Doctor d);
	public Integer deleteBatchByIds(String id);
	public Doctor selectOne(Integer id);
}
