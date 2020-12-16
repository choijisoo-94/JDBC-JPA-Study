package baby.view;

import java.sql.SQLException;
import java.util.Scanner;

import baby.controller.OrdersController;

public class RunningStartView {

	public static void main(String[] args) {
		OrdersController controller = OrdersController.getInstance();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("안녕하세요 염아정님 어떤 권시터가 필요하신가요?");
//
//		System.out.println("언제 필요하신가요? : ");
//		String when = scan.nextLine();
//		System.out.println(when + " 기간에 필요하시군요!!");
//
//		System.out.println("어느 기간동안 필요하신가요?");
//		System.out.println("1. 1일");
//		System.out.println("2. 단기");
//		System.out.println("3. 장기");
//	System.out.println("4. 입주\n");
//		String gigan = scan.nextLine();
//		String parentid = "7a";
//		String duration = "장기";
//		int hourlywage = 10000;
//		OrdersController.getSitters1(parentid, duration, hourlywage);
		search();

	}

	private static void search() {
		OrdersController controller = OrdersController.getInstance();

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("0:검색, 1:입력, 2:수정, 3:삭제  ---> ");

			System.out.println("아이디 검색");
			System.out.print("ID 를 입력해주세요. : ");
			String a = sc.nextLine();
			OrdersController.getParent(a);
			// Parent data에서 네임 추출

			System.out.println("어느 기간동안 필요하신가요? 1.장기, 2.단기, 3,1일, 4,입주");
			String b = sc.nextLine();

			System.out.println("예상하는 시터 페이를 입력해주세요. (예: 10000)");
			int c = sc.nextInt();

			System.out.println("딱 맞는 근처 시터들의 정보입니다.");
			controller.getSitters1(a, b, c);
		} catch (Exception s) {
			s.printStackTrace();
			throw s;
		}
	}
}