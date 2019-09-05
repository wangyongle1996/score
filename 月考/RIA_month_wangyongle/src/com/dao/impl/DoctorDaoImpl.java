package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Doctor;
import com.dao.IDoctorDao;
import com.uilt.BaseDao;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public class DoctorDaoImpl implements IDoctorDao {
	public List<Doctor> selectAllDoctors(){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Doctor> li = new ArrayList<Doctor>();
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from doctor";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String hobby = rs.getString("hobby");
				String birth = rs.getString("birth");
				String deptName = rs.getString("deptName");
				Doctor d = new Doctor(id, name, gender, hobby, birth, deptName);
				li.add(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm, rs);
		}
		return li;
		
	}
	public Integer insertDoctor(Doctor d){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "INSERT INTO `ria_month`.`doctor` (`id`, `name`, `gender`, `hobby`, `birth`, `deptName`) VALUES (NULL, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getGender());
			pstm.setString(3, d.getHobby());
			pstm.setString(4, d.getBirth());
			pstm.setString(5, d.getDeptName());
			Integer i = pstm.executeUpdate();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm);
		}
		return null;
		
	}
	public Integer updateDoctor(Doctor d){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "UPDATE `ria_month`.`doctor` SET `name`=?, `gender`=?, `hobby`=?, `birth`=?, `deptName`=? WHERE (`id`=?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getGender());
			pstm.setString(3, d.getHobby());
			pstm.setString(4, d.getBirth());
			pstm.setString(5, d.getDeptName());
			pstm.setInt(6, d.getId());
			Integer i = pstm.executeUpdate();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm);
		}
		return null;
		
	}
	public Integer deleteBatchByIds(String id){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "delete from doctor where id in (?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			Integer i = pstm.executeUpdate();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm);
		}
		return null;
		
	}
	@Override
	public Doctor selectOne(Integer ids) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from doctor where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ids);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String hobby = rs.getString("hobby");
				String birth = rs.getString("birth");
				String deptName = rs.getString("deptName");
				Doctor d = new Doctor(id, name, gender, hobby, birth, deptName);
				return d;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm, rs);
		}
		return null;
	}
}
