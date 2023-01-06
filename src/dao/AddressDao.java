package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import data.FileProc;
import dto.HumanDto;

// Data Access Object
// �����͸� �����ϰ� 
public class AddressDao {
	
	Scanner sc = new Scanner(System.in);
	
	// ������ 100�� ����
	private HumanDto[] humanArr = new HumanDto[100];
	
	private int count; // ���°�� ������ �������ִ� �ε��� ����...
	
	
	// ������
	public AddressDao() {
		for (int i = 0; i < humanArr.length; i++) {
			humanArr[i] = null;			
		}
	}
	
	
	// �ּҷ� �Է�
	public void insert() {
		
		// �ε�� �ּҷϿ� �̹� ������� ������ ������� count�� �÷��ش�.
		for(int i=0; i<humanArr.length; i++) {
			if(humanArr[i] != null) {
				count++;
			}
		}
		insertInput("������ �߰��մϴ�.", count);
		count++;
	}
	
	
	// �ּҷ� ����
	public void delete() {
		System.out.print("������ ������ �̸�:");
		String name = sc.next();		
		
		// �������� ó��
		// ������ ���������� humanArr������ index�� ���� �迭
		 int[] huIndex = new int[100];
		// �������� ������ ���
		int hucount = 0;
		for(int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null &&  name.equals(humanArr[i].getName())) {	
				huIndex[hucount] = i;
				hucount++;
			}
		}
		
		
		System.out.println("������ ���θ���Դϴ�.");
		for(int z=0; z<hucount; z++) {
			// ������ ����(��)�� ��� Ȯ��			
			System.out.println(humanArr[huIndex[z]].toAddressString()); 
		}
		System.out.println("������ ������ ������ �ֽʽÿ�");
		
		for(int a=0; a<hucount; a++) {
			int num = a+1;
			System.out.println(num+". "+num+"��°");
		}
		System.out.print(" >> ");
		
		// ������ �������� ����
		int updateWho = sc.nextInt()-1;
		humanArr[updateWho].setName("");
		humanArr[updateWho].setAge(0);
		humanArr[updateWho].setPhone("");
		humanArr[updateWho].setAddress("");
		humanArr[updateWho].setMemo("");
		System.out.println("������ ������ �����Ͽ����ϴ�.");
		
		
//		
//		// �˻�
//		int index = -1;
//		for (int i = 0; i < humanArr.length; i++) {
//			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
//				index = i;
//				break;
//			}			
//		}
//		
//		if(index == -1) {
//			System.out.println("������ ������ ã�� �� �����ϴ�.");
//		}else {
//			humanArr[index].setName("");
//			humanArr[index].setAge(0);
//			humanArr[index].setPhone("");
//			humanArr[index].setAddress("");
//			humanArr[index].setMemo("");
//			System.out.println("������ ������ �����Ͽ����ϴ�.");
//		}
		
	}
	
	
	// �ּҷ� �˻�
	public void select() {
		System.out.print("ã���� ������ �̸��� �Է��Ͻʽÿ�:");
		String name = sc.next();
		int selcount = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null && name.equals(humanArr[i].getName())) {
				int num = selcount + 1;
				System.out.println(num + ". " +humanArr[i].toAddressString());
				selcount++;
			}
		}
		
		if(count == 0) {
			System.out.println("�ش� ������ �����ϴ�.");
		}
	}
	
	// �˻�.by_������
	
	
	
	// �ּҷ� ����
	public void update() {
		System.out.print("�����Ͻ� ������ �̸��� �Է��Ͻʽÿ�:");
		String name = sc.next();
		// �������� ó��
		// ������ ������ humanArr������ index�� ���� �迭
		 int[] index = new int[100];
		// ������ ������ ���
		int huupcount = 0;
		for(int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null &&  name.equals(humanArr[i].getName())) {	
				index[huupcount] = i;
				huupcount++;
			}
		}
		
		// ã�� ������ ���� ��
		if(huupcount == 0) {
			System.out.println("�ش� ������ �����ϴ�.");
			return;
		}
		
		// hucountũ���� �����ι� ���� �迭 ����
//		HumanDto[] huDuple = new HumanDto[hucount];
		
		
		
		System.out.println("������ ���θ���Դϴ�.");
		for(int z=0; z<huupcount; z++) {
			int num = z + 1;
			// ������ ����(��)�� ��� Ȯ��			
			System.out.println(num + ". " + humanArr[index[z]].toAddressString()); 
		}
		System.out.println("������ ������ ������ �ֽʽÿ�");
		
		for(int a=0; a<huupcount; a++) {
			int num = a+1;
			System.out.println(num+". "+num+"��°");
		}
		System.out.print(" >> ");
		
		// ������ �������� ����
		int updateWho = sc.nextInt()-1;
		
		insertInput("������ �����մϴ�.", index[updateWho]);
		System.out.println("�����Ͽ����ϴ�.");
	}
	
	// �ּҷ� ���
	public void allDataPrint() {
		int cnt = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null && !humanArr[i].getName().equals("")) {
				System.out.println(i+1+". " + humanArr[i].toAddressString());
				cnt ++;
			}			
		}
		
		if(cnt < 1) {
			System.out.println("�ּ� ����� �����ϴ�.");
		}
	}
	
	
	// �ּҷ� ����
	public void addressSave() {
		FileProc fp = new FileProc();		
		fp.save(humanArr);
	}
	
	
	// �Է��ϴ� ����
	public void insertInput(String input, int count) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(input);
		System.out.print("�̸� = ");
		String name = sc.next();		

		System.out.print("���� = ");
		int age = sc.nextInt();
		System.out.print("��ȭ��ȣ = ");
		String phone = sc.next();
		System.out.print("�ּ� = ");
		String address="";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("�޸� = ");
		String memo = sc.next();

		humanArr[count] = new HumanDto(name, age, phone, address, memo);
	}
	
	
	public void addressLoad() {
		FileProc fp = new FileProc();		
		try {
			humanArr = fp.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
