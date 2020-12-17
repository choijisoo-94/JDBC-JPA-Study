package probono.view;

import java.util.ArrayList;

import probono.controller.ProbonoProjectController;
import probono.model.dto.ProbonoProjectDTO;

public class RunningStartView {
	
	public static void main(String [] args){
		System.out.println("***** 모든 진행되는 실제 Project 검색 *****");
		ProbonoProjectController.getAllProbonoProjects();
					
		
		//모든 재능 기부자들 검색
		System.out.println("\n***** 모든 재능 기부자 검색 *****");
		ProbonoProjectController.getAllActivists();
		
		//특정 프로보노 정보 검색
		System.out.println("\n***** 특정 프로보노 정보 검색 *****");
		ProbonoProjectController.getProbono("schweitzer");
		
		
		//프로보노 id로 프로보노 목적 수정	
		//test data - id : schweitzer,  목적 : 애완동물사랑
		System.out.println("\n***** 특정 프로보노 정보 수정후 재 검색 *****");
		ProbonoProjectController.updateProbono("schweitzer", "애완동물너무 싫어해요");
		ProbonoProjectController.getProbono("schweitzer");
	}
}
		
//		System.out.println("***** 모든 진행되는 실제 Project 검색 *****");
//		ArrayList<ProbonoProjectDTO> allProbonoProject = ProbonoProjectController.getAllProbonoProjects();
//		Runni
