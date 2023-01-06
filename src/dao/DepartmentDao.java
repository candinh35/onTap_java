package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Department;
import utill.ConnectDB;

public class DepartmentDao implements DepartmentInterface<Department> {

	@Override
	public List<Department> getAll() {
		Connection conn = ConnectDB.getConnect();
		List<Department> list = new ArrayList<>();
		PreparedStatement pmst = null;
		ResultSet res = null;

		if (conn != null) {
			try {
				pmst = conn.prepareStatement("select * from Department");
				res = pmst.executeQuery();
				while (res.next()) {
					Department department = new Department();
					department.setDepartId(res.getString("DepartId"));
					department.setDepartName(res.getNString("DepartName"));
					department.setDescription(res.getNString("Description"));
					department.setDateCreate(res.getDate("DateCreated"));
					department.setTotalEmployees(res.getInt("TotalEmployees"));
					list.add(department);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(conn);
			}
		}
		return list;
	}

	@Override
	public Department find(String departId) {
		Connection conn = ConnectDB.getConnect();
		Department department = new Department();
		PreparedStatement pmst = null;
		ResultSet res = null;

		if (conn != null) {
			try {
				pmst = conn.prepareStatement("select * from Department where DepartId = ?");
				pmst.setString(1, departId);
				res = pmst.executeQuery();
				while (res.next()) {
					department.setDepartId(res.getString("DepartId"));
					department.setDepartName(res.getNString("DepartName"));
					department.setDescription(res.getNString("Description"));
					department.setDateCreate(res.getDate("DateCreated"));
					department.setTotalEmployees(res.getInt("TotalEmployees"));
				}
				return department;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(conn);
			}
		}
		return null;
	}

	@Override
	public void create(Department depart) {
		Connection conn = ConnectDB.getConnect();
		PreparedStatement pmst = null;
		if (conn != null) {
			try {
				pmst = conn.prepareStatement("insert into Department values (?,?,?,?,?)");
				pmst.setString(1, depart.getDepartId());
				pmst.setNString(2, depart.getDepartName());
				pmst.setNString(3, depart.getDescription());
				pmst.setDate(4, new java.sql.Date(depart.getDateCreate().getTime()));
				pmst.setInt(5, depart.getTotalEmployees());
				int check = pmst.executeUpdate();
				if (check > 0) {
					System.out.println("them moi thanh cong");
				} else {
					System.out.println("them moi that bai");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(conn);
			}
		}

	}

	@Override
	public void update(Department depart, String departIdUpdate) {
		Connection conn = ConnectDB.getConnect();
		PreparedStatement pmst = null;
		if (conn != null) {
			try {
				pmst = conn.prepareStatement(
						"UPDATE Department SET DepartId =?,DepartName=?,Description=?,DateCreated =?,TotalEmployees =? where DepartId =?");
				pmst.setString(1, depart.getDepartId());
				pmst.setNString(2, depart.getDepartName());
				pmst.setNString(3, depart.getDescription());
				pmst.setDate(4, new java.sql.Date(depart.getDateCreate().getTime()));
				pmst.setInt(5, depart.getTotalEmployees());
				pmst.setString(6,departIdUpdate);
				int check = pmst.executeUpdate();
				if (check > 0) {
					System.out.println("cap nhat thanh cong");
				} else {
					System.out.println("cap nhat that bai");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(conn);
			}
		}

	}

	@Override
	public void delete(String departId) {
		Connection conn = ConnectDB.getConnect();
		PreparedStatement pmst = null;

		if (conn != null) {
			try {
				pmst = conn.prepareStatement(
						"delete from Department  where DepartId =?");
				pmst.setString(1, departId);
				int check = pmst.executeUpdate();
				if (check > 0) {
					System.out.println("xoa thanh cong");
				} else {
					System.out.println("xoa that bai");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(conn);
			}
		}

	}

}
