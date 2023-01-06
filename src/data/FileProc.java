package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.HumanDto;

// ���� ����, �б⸦ �� �� �ִ� Ŭ����
public class FileProc {
	
	// ���� ����, �б�
	private File file = null;
	
	public FileProc() {
//		file = new File("c:\\tmp\\" + fileName +".txt");
		file = new File("c:\\tmp\\newfile.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("���� ���� ����");
			} else {
//				System.out.println("�ش������� �̹� �ֽ��ϴ�.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(HumanDto[] humanArr) {
		File f = new File("c:\\tmp\\newfile.txt");
		FileInputStream is;
		
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		FileWriter fwriter;
		try {
			fwriter = new FileWriter(f);
			for (int i = 0; i < humanArr.length; i++) {
				if(humanArr[i] != null&& !humanArr[i].getName().equals("")) {
//					String jsonHuman = "{\"name\": \""+humanArr[i].getName()+","
//				            + "\"age\": \""+humanArr[i].getAge()+"/\","
//				            + "\"phone\": "+ humanArr[i].getPhone()+"/\","
//				            + "\"address\": "+ humanArr[i].getAddress()+"/\","
//				            + "\"memo\": "+humanArr[i].getMemo()
//				            + "}";
					String human = humanArr[i].getName() + ","+ humanArr[i].getAge() + ","+ humanArr[i].getPhone() + ","+ humanArr[i].getAddress() + ","+ humanArr[i].getMemo() +"\r\n"; 
					fwriter.write(human);				
				}
			}
			
			fwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public HumanDto[] load() throws IOException {
		HumanDto[] humanArr = new HumanDto[100];
        BufferedReader br = new BufferedReader(new FileReader("c:\\tmp\\newfile.txt"));
        int count = 0;
        while(true) {
            String human = br.readLine();
            if (human==null) break;  // �� �̻� ���� ������ ���� ��� while ���� ����������.
            
            String[] humanInfo = human.split(",");           
            HumanDto hu = new HumanDto(humanInfo[0], Integer.parseInt(humanInfo[1]), humanInfo[2], humanInfo[3], humanInfo[4]);
            humanArr[count] = hu;
            count++;
        }
        br.close();
        return humanArr;
	}
	
	// ������ �ش�
	public void write(String datas[]) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);				
			}
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("���Ͽ� ����Ǿ����ϴ�.");
		
	}
	
}
