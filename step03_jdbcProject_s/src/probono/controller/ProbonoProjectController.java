package probono.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import probono.exception.NotExistException;
import probono.model.ActivistDAO;
import probono.model.ProbonoDAO;
import probono.model.ProbonoProjectDAO;
import probono.model.ProbonoService;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.view.RunningEndView;

//현 로직 : view.RunningStrartView에서 호출 
public class ProbonoProjectController {
	
	
	//모든 프로젝트 검색 로직
	public static void getAllProbonoProjects() {
		ArrayList<ProbonoProjectDTO> allProject = null;
		try {
			allProject = ProbonoService.getAllProbonoUsers();
			if (allProject.size() != 0) {
				RunningEndView.projectListView(allProject);
			} else {
				RunningEndView.showError("현재 진행중인 프로젝트는 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}

	}
	
	//새로운 프로젝트 저장 로직
	public static void addProbonoProject(ProbonoProjectDTO probonoProject) {
		boolean result = false;

		try {
			result = ProbonoService.addProbonoUser(probonoProject);
			if (result == true) {
				RunningEndView.showMessage("저장 성공");
			} else {
				RunningEndView.showError("저장 실패");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 저장시 에러 발생");
		}
	}
	
	//모든 프로젝트 검색 로직
	public static void getAllActivists() {
		ArrayList<ActivistDTO> allProject = null;
		try {
			allProject = ProbonoService.getAllActivists();
			if (allProject.size() != 0) {
				RunningEndView.projectListView(allProject);				
			} else {RunningEndView.showError("기부자는 존재하지 않습니다.");}


		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 재능 기부자 검색시 에러 발생");
		}
	}
	
	//프로보노 아이디로 프로보노 목적 수정
	public static boolean updateProbono(String probonoId, String probonoPurpose){
		boolean result = false;
		try{
			result = ProbonoService.updateProbono(probonoId, probonoPurpose);
			if(result == true) {
				RunningEndView.showMessage("수정 성공");
			}else {
				RunningEndView.showError("수정 실패");
			}
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("프로보노 id로 프로보노 목적 변경 오류");
		}catch(NotExistException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//프로보노 정보 검색
	public static void getProbono(String probonoId) {
		ProbonoDTO probono = null;
		try {
			probono = ProbonoService.getProbono(probonoId);
			RunningEndView.allView(probono);
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("프로보노 id로 해당 프로보노 검색 오류 ");
		} catch (NotExistException e) {
			e.printStackTrace();
		}
	}

}