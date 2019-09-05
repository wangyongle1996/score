package com.service.impl;

import java.util.List;

import com.bean.Doctor;
import com.dao.IDoctorDao;
import com.dao.impl.DoctorDaoImpl;
import com.service.IDoctorService;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public class DoctorServiceImpl implements IDoctorService {
	IDoctorDao idd = new DoctorDaoImpl();
	@Override
	public List<Doctor> queryAllDoctors() {
		// TODO Auto-generated method stub
		return idd.selectAllDoctors();
	}

	@Override
	public Integer addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return idd.insertDoctor(d);
	}

	@Override
	public Integer modifyDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return idd.updateDoctor(d);
	}

	@Override
	public Integer dropBatchByIds(String d) {
		// TODO Auto-generated method stub
		return idd.deleteBatchByIds(d);
	}

	@Override
	public Doctor queryOne(Integer id) {
		// TODO Auto-generated method stub
		return idd.selectOne(id);
	}

}
