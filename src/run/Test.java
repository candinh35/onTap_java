package run;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dao.DepartmentDao;
import dao.DepartmentInterface;
import entities.Department;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentInterface<Department> departmentDao = new DepartmentDao();

		int luaChon = 0;

		do {
			System.out.println("*********************MENU************************* \r\n"
					+ "1. Them moi 1 phong ban \r\n" 
					+ "2. Tim kiem 1 phong ban \r\n"
					+ "3. Hien thi thong tin tat ca cac phong ban \r\n" 
					+ "4. Cap nhat thong tin phong ban da co \r\n"
					+ "5. Xoa thong tin phong ban \r\n" 
					+ "0. Thoat \r\n" 
					+ "");
			System.out.println("moi ban lua chon");
			luaChon = Integer.parseInt(sc.nextLine());

			switch (luaChon) {
			case 1:
				Department department = new Department();
				try {
					department.inputData(sc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				departmentDao.create(department);
				break;
			case 2:
				System.out.println("moi ban nhap vao Id tim kiem");
				String departId = sc.nextLine();
				Department departFind = departmentDao.find(departId);
				if (departFind.getDepartId() != null) {
					System.out.println(departFind);
				} else {
					System.out.println("khong tim thay");
				}
				break;
			case 3:
				List<Department> list = departmentDao.getAll();

				for (Department depart : list) {
					System.out.println(depart);
				}
				break;
			case 4:
				System.out.println("moi ban nhap vao Id can cap nhat");
				String id = sc.nextLine();
				Department departUpdate = departmentDao.find(id);
				System.out.println(departUpdate);
				if (departUpdate.getDepartId() != null) {
					try {
						departUpdate.inputData(sc);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					departmentDao.update(departUpdate, id);
				} else {
					System.out.println("khong tim thay");
				}
				break;
			case 5:
				System.out.println("moi ban nhap vao Id can xoa");
				String deleteId = sc.nextLine();
				departmentDao.delete(deleteId);
				break;
			default:
				break;
			}
		} while (luaChon != 0);

	}

}
