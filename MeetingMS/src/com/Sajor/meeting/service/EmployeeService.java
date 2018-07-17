package com.Sajor.meeting.service;

import java.util.List;

import com.Sajor.meeting.dao.EmployeeDao;
import com.Sajor.meeting.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao=new EmployeeDao();
	private Employee loginedEmployee=new Employee();
	
	//登陆 查看是否通过审核
	public int login(String username,String pwd){
		int flag=3;  //无此用户
		Employee e=dao.selectByNamePwd(username, pwd);
		if(e != null){
			e.setUsername(username);
			e.setPassword(pwd);
			loginedEmployee=e;
			String status=e.getStatus();
			if(status!=null){
				if(status.equals("1")){
					flag=1;  //成功
				}
				else if(status.equals("0")){
					flag=0;	 //审核
				}
				else if(status.equals("2")){
					flag=2;  //关闭
				}
			}
		}
		return flag;
	}
	
	//得到当前登陆的用户
	public Employee getLoginedEmployee(){
		return loginedEmployee;
	}
	
	//注册   先 查看库里是否存在此用户名
	public int regist(Employee employee){
		int flag=0;
		Employee e=dao.selectByUsername(employee.getUsername());
		if(e==null){
			flag=1;
			dao.insert(employee);
		}
		return flag;
	}
	
	//修改密码  查看库里是否存在此用户名和电话（通过电话和用户名修改）
	public int change(Employee employee){
		int flag=0;
		Employee e=dao.selectByUsernameAndTel(employee.getUsername(), employee.getPhone());
		if(e!=null){
			flag=1;
			dao.updatePassword(employee);
		}
		return flag;
	}

	//查询用户  通过关键字查询用户信息是否存在此关键字
	public List<Employee> searchEmployees(String searchTxt){
		List<Employee> list=dao.selectEmployeesByAll(searchTxt);
		return list;
	}
}
