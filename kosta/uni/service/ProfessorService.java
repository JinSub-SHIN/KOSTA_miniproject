package kosta.uni.service;

import kosta.uni.dao.ProfessorDAO;
import kosta.uni.exception.AddException;
import kosta.uni.exception.NotFoundException;
import kosta.uni.vo.Professor;

public class ProfessorService {
	private static ProfessorService service = new ProfessorService();
	ProfessorDAO dao;
	private ProfessorService() {
		dao = new ProfessorDAO();
	}
	public static ProfessorService getInstance() {
		return service;
	}
	
	public void login(int id, String pwd) throws NotFoundException{
		Professor professor = dao.selectById(id);
		if(!professor.getPwd().equals(pwd)) {
			throw new NotFoundException("다시 입력해 주세요");
		}
	}
	
	public void changePwd (int id, String pwd) throws Exception{
	    Professor professor = dao.selectById(id);
	    if(professor.getPwd()==null) {
	       throw new AddException("등록되지 않은 회원입니다");
	    }
	    professor.setPwd(pwd);
	    dao.update(professor);
	 }
	 
	/////////////////////////////////////////////////////////////////////////
	 public void resister(int id, String pwd) throws Exception{
	    Professor professor = dao.selectById(id);
	    if(professor.getPwd()!=null) {
	       throw new AddException(" 이미 등록된 회원입니다 ");
	    }
	    professor.setPwd(pwd);
	    dao.update(professor);
	 }
	 
}
