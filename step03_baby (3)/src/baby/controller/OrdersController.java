package baby.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import baby.exception.NotExistException;
import baby.model.OrdersService;
import baby.model.dto.ChildDTO;
import baby.model.dto.OrdersDTO;
import baby.model.dto.ParentDTO;
import baby.model.dto.SitterDTO;
import baby.view.RunningEndView;

public class OrdersController {

	private static OrdersController instance = new OrdersController();
//	private ProbonoService service = ProbonoService.getInstance();

	private OrdersController() {
	}

	public static OrdersController getInstance() {
		return instance;
	}

	public static void getAllOrders() {
		ArrayList<OrdersDTO> allOrders = null;
		try {
			allOrders = OrdersService.getAllOrders();
			if (allOrders.size() != 0) {
				RunningEndView.allListView(allOrders);
			} else {
				RunningEndView.showError("현재 진행중인 매칭은 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("모든 매칭 검색시 에러 발생");
		}

	}

	public static void addOrders(OrdersDTO orders) {
		boolean result = false;

		try {
			result = OrdersService.addOrders(orders);
			if (result == true) {
				RunningEndView.showMessage("매칭 저장 성공");
			} else {
				RunningEndView.showError("매칭 저장 실패");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("SQL문 에러 발생");
		}
	}

	public static void getAllParents() {
		ArrayList<ParentDTO> allParents = null;
		try {
			allParents = OrdersService.getAllParents();

			if (allParents.size() != 0) {
				RunningEndView.allListView(allParents);
			} else {
				RunningEndView.showError("해당 parents는 존재하지 않습니다.");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("SQL문 에러 발생");
		}
	}

	public static void getSitters1(String parentid, String duration, int hourlywage) {
		ArrayList<SitterDTO> allSitters = null;
		try {
			allSitters = OrdersService.getSitters1(parentid, duration, hourlywage);

			if (allSitters.size() != 0) {
				RunningEndView.allListView(allSitters);
			} else {
				RunningEndView.showError("해당 parents는 존재하지 않습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("SQL문 에러 발생");
		} catch (NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("Notexist 에러 발생");
		}
	}

	public static void getParent(String parentId) {
		try {
			RunningEndView.allView(OrdersService.getParent(parentId));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("parentid로 해당 프로보노 검색 오류 ");
		} catch (NotExistException e) {
			e.printStackTrace();
		}
	}

	public static void getAllSitters() {
		ArrayList<SitterDTO> allSitters = null;
		try {
			allSitters = OrdersService.getAllSitters();

			if (allSitters.size() != 0) {
				RunningEndView.allListView(allSitters);
			} else {
				RunningEndView.showError("해당 sitters는 존재하지 않습니다.");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("SQL문 에러 발생");
		}
	}

	public static void getAllChilds() {
		ArrayList<ChildDTO> allChilds = null;
		try {
			allChilds = OrdersService.getAllChilds();

			if (allChilds.size() != 0) {
				RunningEndView.allListView(allChilds);
			} else {
				RunningEndView.showError("해당 childs는 존재하지 않습니다.");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("SQL문 에러 발생");
		}
	}

}