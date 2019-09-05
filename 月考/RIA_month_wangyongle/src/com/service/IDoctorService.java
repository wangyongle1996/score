package com.service;

import java.util.List;

import com.bean.Doctor;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public interface IDoctorService {
	public List<Doctor> queryAllDoctors();
	public Integer addDoctor(Doctor d);
	public Integer modifyDoctor(Doctor d);
	public Integer dropBatchByIds(String d);
	public Doctor queryOne(Integer id);
}
