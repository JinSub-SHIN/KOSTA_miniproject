package kosta.uni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kosta.uni.exception.NotFoundException;
import kosta.uni.sql.MyConnection;
import kosta.uni.vo.Subject;

public class SubjectDAO {

	/**
	 * �����ڵ带 �Է¹޾� DB������ �ش� ���� ���� ������ �����Ѵ�.
	 * 
	 * @param subject_code
	 * @return
	 * @throws NotFoundException
	 */
	public Subject selectByCode(String subject_code) throws NotFoundException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();

			String selectByCodeSQL = "SELECT subject_name, credit, limit, start_time"
					+ " subject_major, run_time FROM SUBJECT WHERE subject_code=?";
			pstmt = con.prepareStatement(selectByCodeSQL);
			pstmt.setString(1, subject_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("subject_name");
				int credit = rs.getInt("credit");
				int limit = rs.getInt("limit");
				String start = rs.getString("start_time");
				int subject_major = rs.getInt("subject_major");
				int run_time = rs.getInt("run_time");

				return new Subject(subject_code, name, credit, limit, start, subject_major, run_time);

			} else {
				throw new NotFoundException("�ش�����ȣ ���ٱ�~");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}

	}

	/**
	 * ���� �ش��ϴ� �����ȣ�� �Է¹޾� �ش� �����ȣ�� �ش��ϴ� ������ ����
	 * 
	 * @param major
	 * @return
	 */
	public List<Subject> selectByMajor(int major_number) throws NotFoundException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Subject> list = new ArrayList<Subject>();

		try {
			con = MyConnection.getConnection();

			String selectByMajor = "SELECT * FROM SUBJECT WHERE =?";
			pstmt = con.prepareStatement(selectByMajor);
			pstmt.setInt(1, major_number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Subject(rs.getString("subject_code"), rs.getString("subject_name"), rs.getInt("credit"),
						rs.getInt("limit"), rs.getString("start_time"), major_number, rs.getInt("run_time")));
			}
			if (list.size() == 0) {
				throw new NotFoundException("�����������ٱ�~");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}
		return list;

	}

	/**
	 * ���� ���� DB�� ��ü�˻�
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	public List<Subject> selectALL() throws NotFoundException {

		List<Subject> list = new ArrayList<Subject>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = MyConnection.getConnection();

			String selectALLSQL = "SELECT * FROM SUBJECT";
			pstmt = con.prepareStatement(selectALLSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_code = rs.getString("subject_code");
				String subject_name = rs.getString("subject_name");
				int credit = rs.getInt("credit");
				int limit = rs.getInt("limit");
				String start_time = rs.getString("start_time");
				int subject_major = rs.getInt("subject_major");
				int run_time = rs.getInt("run_time");
				Subject subject = new Subject(subject_code, subject_name, credit, limit, start_time, subject_major,
						run_time);
				list.add(subject);
			}
			if (list.size() == 0) {
				throw new NotFoundException("��ü������ ����~");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}
		return list;
	}

	public static void main(String[] args) {

		Subject subject = new Subject("0001", "���������", 3, 1, "��9", 0, 3);
		SubjectDAO sdao = new SubjectDAO();

		try {
			List<Subject> list = sdao.selectALL();
			for (Subject su : list) {
				System.out.println(su);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}