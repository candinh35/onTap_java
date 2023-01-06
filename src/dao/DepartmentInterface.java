package dao;

import java.util.List;

import entities.Department;

public interface DepartmentInterface<T> {
	List<T> getAll();

	Department find(String departId);

	void create(Department depart);

	void update(Department depart, String departIdUpdate);

	void delete(String departId);
}
