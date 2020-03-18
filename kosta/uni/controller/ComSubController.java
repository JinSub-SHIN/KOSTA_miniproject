package kosta.uni.controller;

import java.util.List;
import java.util.Map;

import kosta.uni.exception.NotFoundException;
import kosta.uni.service.ComSubService;
import kosta.uni.view.FailView;
import kosta.uni.view.SuccessView;
import kosta.uni.vo.CompleteSubject;

public class ComSubController {

	public void showMyAppInfo(int id, String term) {

		try {
			List<CompleteSubject> list = ComSubService.getInstance().showMyAppInfo(id, term);
			for (CompleteSubject cs : list) {
				SuccessView.successMessage(cs.toString());
			}

		} catch (NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public void showAllGrade(int id) {

		try {
			List<CompleteSubject> list = ComSubService.getInstance().showAllGrade(id);
			SuccessView.grademessage(list);
		} catch (NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ComSubController css = new ComSubController();
		css.showAllGrade(20171001);
	}

}
