package probono.view;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
@Slf4j
public class RunningEndView {

	// 모든 프로젝트 출력
	public static void projectListView(ArrayList allProbonoProject) {
		// ? 데이터 수가 몇만건
		// 하단 코드 적합 부적합 고민
		int length = allProbonoProject.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allProbonoProject.get(index));
				log.info("출력되었습니다.");
			}
		}
	}

	// 특정 프로젝트 출력
	public static void projectView(ProbonoProjectDTO project) {
		System.out.println(project);
		log.info("출력되었습니다.");
	}

	// ?? 모든 DTO 정보 출력하는 메소드
	public static void allView(ProbonoDTO probonoDTO) {
		System.out.println(probonoDTO);
		log.info("출력되었습니다.");
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
		log.info("예외 발생");
	}
	
	public static void showMessage(String message) {
		System.out.println(message);
		log.info("정상 출력");
	}
}