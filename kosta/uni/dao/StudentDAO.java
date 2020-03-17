package kosta.uni.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import kosta.uni.exception.NotFoundException;

import kosta.uni.sql.MyConnection;

import kosta.uni.vo.CompleteSubject;

import kosta.uni.vo.Grade;
import kosta.uni.vo.Major;
import kosta.uni.vo.Student;

import kosta.uni.vo.Subject;

//DB�����

public class StudentDAO {

	/**
	 * id�� �ش��ϴ� �л� �˻�
	 * 
	 * @param id ���̵�(�й�)
	 * @return Student ��ü
	 * @exception NotFoundExceprion DB��������̰ų� ���̵� �ش� ���� ������ ���� �߻�(null�� ��ȯ����)
	 */
	public Student selectById(int id) throws NotFoundException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		

		try {
			con = MyConnection.getConnection();
			
			String selectByIdSQL = "SELECT stu.student_id, stu.name, stu.pwd, stu.accumulated_grade, stu.class_level,"
				     + "m.major_number, m.major_name, m.necessary_grade , cs.subject_date,"
				     + "g.grade_point, g.score, s.subject_code, s.subject_name, s.credit, s.limit, "
				     + "s.start_time, s.major_number, s.run_time"
				     + " FROM student stu JOIN major m ON stu.major_number = m.major_number"
				     + " JOIN complete_subject cs ON cs.student_id = stu.student_id"
				     + " JOIN grade g ON cs.grade_point = g.grade_point"
				     + " JOIN subject s ON s.subject_code = cs.com_subject_code"
				     + " WHERE stu.student_id = ?";
			
			pstmt = con.prepareStatement(selectByIdSQL);
			rs = pstmt.executeQuery();
			boolean isFirst = false;
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			// 3) DB��������
			MyConnection.close(con, pstmt, rs);
		}
		return null;
	}

	public static void main(String[] args) {

		StudentDAO sdao = new StudentDAO();

		try {
			sdao.selectById(20171001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}