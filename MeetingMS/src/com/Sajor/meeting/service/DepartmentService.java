package com.Sajor.meeting.service;

import java.util.List;

import com.Sajor.meeting.dao.DepartmentDao;
import com.Sajor.meeting.vo.Department;


public class DepartmentService {
	private DepartmentDao dao=new DepartmentDao();

	//查看所有部门
	public List<Department> viewAllDepartments(){
		return dao.selectAll();
	}
	
	//添加部门
	public void addDepartment(String departmentname){
		dao.insert(departmentname);
	}
	
	//删除部门
	public void deleteDepartment(int departmentid){
		dao.delete(departmentid);
	}
}
