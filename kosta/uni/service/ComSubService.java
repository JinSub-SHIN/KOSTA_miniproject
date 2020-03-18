package kosta.uni.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kosta.uni.dao.CompleteSubjectDAO;
import kosta.uni.exception.NotFoundException;
import kosta.uni.vo.CompleteSubject;

public class ComSubService {

	private static ComSubService service = new ComSubService();
	private CompleteSubjectDAO cdao;

	private ComSubService() {
		cdao = new CompleteSubjectDAO();

	}

	public static ComSubService getInstance() {
		return service;
	}

	public List<CompleteSubject> showMyAppInfo(int id, String term) throws NotFoundException {

		return cdao.selectByIdTerm(id, term);
	}

	public List<CompleteSubject> showAllGrade(int id) throws NotFoundException {

		return cdao.selectById(id);

	}
}
