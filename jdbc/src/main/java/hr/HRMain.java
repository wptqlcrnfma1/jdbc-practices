package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 :> ");
		String name = scanner.nextLine();
		
		EmployeeVo employeeVo = new EmployeeVo();
		employeeVo.setFirstName(name);
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.FindByName(employeeVo);
		
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
	
		scanner.close();
		
	}

}
