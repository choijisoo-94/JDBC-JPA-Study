package baby.view;

import java.util.ArrayList;

import baby.model.dto.OrdersDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j

public class RunningEndView {

	// 모든 프로젝트 출력
	public static void allListView(ArrayList alllist) {
	//public static void projectListView(ArrayList<ActivistDTO> allProbonoProject) {
	//public static void projectListView(ArrayList<ProbonoProjectDTO> allProbonoProject) {
		
		int length = alllist.size();
		for (int index = 0; index < length; index++) {
			System.out.println("검색정보 " + (index + 1) + " - " + alllist.get(index));
		}
		log.info("모든 요청 기록");
	}

	// 특정 프로젝트 출력
	public static void OrdersView(OrdersDTO orders) {
		System.out.println(orders);
		log.info("해당 요청 " + orders + "출력 기록");
	}

	// 모든 DTO 정보 출력하는 메소드
	public static void allView(Object o) {
		System.out.println(o);
		log.info("해당 정보 출력");
	}
	
	public static void nameView(Object o) {
		for (int i=0;i<o.length;i++){
		       System.out.println(o[i][0]);
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
		log.info("예외 상황 발생");
	}
	
	public static void showMessage(String message) {
		System.out.println(message);
	}
}
