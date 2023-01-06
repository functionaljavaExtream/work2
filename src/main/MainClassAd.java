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

			System.out.println(" << �ּҷ� >>");
			System.out.println(" 1.�����߰�");
			System.out.println(" 2.���λ���");
			System.out.println(" 3.���ΰ˻�");
			System.out.println(" 4.���μ���");
			System.out.println(" 5.������");
			System.out.println(" 6.�ּҷ� ����");
			System.out.println(" 7.����");

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
					System.out.println("�̿����ּż� �����մϴ�.");
					// �� �Ⱦ���... ��... ����ϱ� �ѵ�
					return;

				default:
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
					break;
			}

		}



	}

}
