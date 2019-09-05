package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.IUserDao;
import com.uilt.BaseDao;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public class UserDaoImpl implements IUserDao {
	public String selectUser(String userName,String userPwd){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from user where userName = ? and userPwd = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, userPwd);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getString("username");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstm);
		}
		
		return null;
		
	}
}
