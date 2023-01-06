package entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Department {
	private String departId;
	private String departName;
	private String description;
	private Date dateCreate;
	private int totalEmployees;

	public Department(String departId, String departName, String description, Date dateCreate, int totalEmployees) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.description = description;
		this.dateCreate = dateCreate;
		this.totalEmployees = totalEmployees;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	@Override
	public String toString() {
		return "Department [departId=" + departId + ", departName=" + departName + ", description=" + description
				+ ", dateCreate=" + dateCreate + ", totalEmployees=" + totalEmployees + "]";
	}

	public void inputData(Scanner sc) throws ParseException {
	
		System.out.println("Moi ban nhap vao Id");
		this.departId = sc.nextLine();
		System.out.println("Moi ban nhap vao Name");
		this.departName = sc.nextLine();
		System.out.println("Moi ban nhap vao Description");
		this.description = sc.nextLine();
		System.out.println("Moi ban nhap vao ngay tao");
//		java.util.Date utilDate = new java.util.Date();
//		java.sql.Date sqlDate = new java.sql.Date(utilDate.parse(sc.nextLine()));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		this.dateCreate =  sf.parse(sc.nextLine());
		System.out.println("Moi ban nhap vao tong nhan vien");
		this.totalEmployees = Integer.parseInt(sc.nextLine());
	
	}
	

}
