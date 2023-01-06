package main;

import java.util.Scanner;

import dao.AddressDao;

public class MainClassAd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressDao dao = new AddressDao();
		dao.addressLoad();
		// menu
		while(true) {

			System.out.println(" << 주소록 >>");
			System.out.println(" 1.지인추가");
			System.out.println(" 2.지인삭제");
			System.out.println(" 3.지인검색");
			System.out.println(" 4.지인수정");
			System.out.println(" 5.모두출력");
			System.out.println(" 6.주소록 저장");
			System.out.println(" 7.종료");

			System.out.print(" >> ");
			int choice = sc.nextInt();

			switch(choice) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:
					dao.addressSave();
					break;
				case 7:
					System.out.println("이용해주셔서 감사합니다.");
					// 잘 안쓴다... 흠... 깔끔하긴 한데
					return;

				default:
					System.out.println("잘못입력하셨습니다.");
					break;
			}

		}



	}

}
