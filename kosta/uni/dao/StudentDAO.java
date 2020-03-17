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

//DB연결☆

public class StudentDAO {

	/**
	 * id에 해당하는 학생 검색
	 * 
	 * @param id 아이디(학번)
	 * @return Student 객체
	 * @exception NotFoundExceprion DB연결실패이거나 아이디에 해당 고객이 없으면 예외 발생(null값 반환ㄴㄴ)
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
			// 3) DB연결해제
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