package ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import business.ProjectBusiness;
import dao.ProjectDao;
import entity.Employee;
import entity.Project;

public class MainTest {
	public static void main(String[] args) {
		
		
		try {
			ProjectBusiness projectBusiness = new ProjectBusiness();


			Set<String> versions = new HashSet<String>();
			versions.add("1.0.0");
			versions.add("1.0.1");
			versions.add("1.0.2");
			Project prj = new Project(899990l, "Project hjkhkj", "Software", versions);
			Project prj2 = new Project(90878678600l, "Project guygjjgj", "Software", new HashSet<String>(Arrays.asList("1.0.0", "1.0.1")));

			Employee employee = new Employee();
			employee.setEmployeeID(10l);
			prj.addDetail(employee, 15);
			prj2.addDetail(employee, 25);
			
			System.out.println("\n=========1. Thêm một đối tượng Project và EmployeeProject vào MongoDB=========");
			try {
				boolean result1 = projectBusiness.addProject(prj);
				boolean result2 = projectBusiness.addProject(prj2);
				if(result1)
					System.out.println("Inserted!");

				if(result2)
					System.out.println("Inserted!");

			}catch (Exception e) {
				System.out.println("Error!");
				System.out.println(e.getMessage());
			}
			System.out.println("\n=========2. Tìm 1 dự án khi biết tên dự án (projectName)============");
			Project prjx = projectBusiness.getProject(null);
			if(prjx == null)
				System.out.println("Not found!");
			else
				System.out.println(prjx);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
