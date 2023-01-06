package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import data.FileProc;
import dto.HumanDto;

// Data Access Object
// 데이터를 접근하고 
public class AddressDao {
	
	Scanner sc = new Scanner(System.in);
	
	// 변수를 100개 생성
	private HumanDto[] humanArr = new HumanDto[100];
	
	private int count; // 몇번째에 들어갈건지 지정해주는 인덱스 변수...
	
	
	// 생성자
	public AddressDao() {
		for (int i = 0; i < humanArr.length; i++) {
			humanArr[i] = null;			
		}
	}
	
	
	// 주소록 입력
	public void insert() {
		
		// 로드된 주소록에 이미 사람들의 정보가 있을경우 count를 올려준다.
		for(int i=0; i<humanArr.length; i++) {
			if(humanArr[i] != null) {
				count++;
			}
		}
		insertInput("지인을 추가합니다.", count);
		count++;
	}
	
	
	// 주소록 삭제
	public void delete() {
		System.out.print("삭제할 지인의 이름:");
		String name = sc.next();		
		
		// 동명이인 처리
		// 삭제할 동명이인의 humanArr에서의 index를 받을 배열
		 int[] huIndex = new int[100];
		// 동명이인 지인의 명수
		int hucount = 0;
		for(int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null &&  name.equals(humanArr[i].getName())) {	
				huIndex[hucount] = i;
				hucount++;
			}
		}
		
		
		System.out.println("삭제할 지인목록입니다.");
		for(int z=0; z<hucount; z++) {
			// 수정할 지인(들)의 목록 확인			
			System.out.println(humanArr[huIndex[z]].toAddressString()); 
		}
		System.out.println("삭제할 지인을 선택해 주십시오");
		
		for(int a=0; a<hucount; a++) {
			int num = a+1;
			System.out.println(num+". "+num+"번째");
		}
		System.out.print(" >> ");
		
		// 누구를 수정할지 선택
		int updateWho = sc.nextInt()-1;
		humanArr[updateWho].setName("");
		humanArr[updateWho].setAge(0);
		humanArr[updateWho].setPhone("");
		humanArr[updateWho].setAddress("");
		humanArr[updateWho].setMemo("");
		System.out.println("지정한 지인을 삭제하였습니다.");
		
		
//		
//		// 검색
//		int index = -1;
//		for (int i = 0; i < humanArr.length; i++) {
//			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
//				index = i;
//				break;
//			}			
//		}
//		
//		if(index == -1) {
//			System.out.println("지인의 정보를 찾을 수 없습니다.");
//		}else {
//			humanArr[index].setName("");
//			humanArr[index].setAge(0);
//			humanArr[index].setPhone("");
//			humanArr[index].setAddress("");
//			humanArr[index].setMemo("");
//			System.out.println("지정한 지인을 삭제하였습니다.");
//		}
		
	}
	
	
	// 주소록 검색
	public void select() {
		System.out.print("찾으실 지인의 이름을 입력하십시오:");
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
			System.out.println("해당 지인이 없습니다.");
		}
	}
	
	// 검색.by_선생님
	
	
	
	// 주소록 수정
	public void update() {
		System.out.print("수정하실 지인의 이름을 입력하십시오:");
		String name = sc.next();
		// 동명이인 처리
		// 수정할 지인의 humanArr에서의 index를 받을 배열
		 int[] index = new int[100];
		// 수정할 지인의 명수
		int huupcount = 0;
		for(int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null &&  name.equals(humanArr[i].getName())) {	
				index[huupcount] = i;
				huupcount++;
			}
		}
		
		// 찾는 지인이 없을 때
		if(huupcount == 0) {
			System.out.println("해당 지인이 없습니다.");
			return;
		}
		
		// hucount크기의 동일인물 담을 배열 설정
//		HumanDto[] huDuple = new HumanDto[hucount];
		
		
		
		System.out.println("수정할 지인목록입니다.");
		for(int z=0; z<huupcount; z++) {
			int num = z + 1;
			// 수정할 지인(들)의 목록 확인			
			System.out.println(num + ". " + humanArr[index[z]].toAddressString()); 
		}
		System.out.println("수정할 지인을 선택해 주십시오");
		
		for(int a=0; a<huupcount; a++) {
			int num = a+1;
			System.out.println(num+". "+num+"번째");
		}
		System.out.print(" >> ");
		
		// 누구를 수정할지 선택
		int updateWho = sc.nextInt()-1;
		
		insertInput("지인을 수정합니다.", index[updateWho]);
		System.out.println("수정하였습니다.");
	}
	
	// 주소록 출력
	public void allDataPrint() {
		int cnt = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] !=null && !humanArr[i].getName().equals("")) {
				System.out.println(i+1+". " + humanArr[i].toAddressString());
				cnt ++;
			}			
		}
		
		if(cnt < 1) {
			System.out.println("주소 목록이 없습니다.");
		}
	}
	
	
	// 주소록 저장
	public void addressSave() {
		FileProc fp = new FileProc();		
		fp.save(humanArr);
	}
	
	
	// 입력하는 패턴
	public void insertInput(String input, int count) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(input);
		System.out.print("이름 = ");
		String name = sc.next();		

		System.out.print("나이 = ");
		int age = sc.nextInt();
		System.out.print("전화번호 = ");
		String phone = sc.next();
		System.out.print("주소 = ");
		String address="";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("메모 = ");
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
