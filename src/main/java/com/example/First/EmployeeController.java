package com.example.First;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController {
	@RequestMapping("/getallemployee")
	public ArrayList<Employee> getAllEmployee() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionClass.getConnectionValues();
		Statement stmt = connection.createStatement();
		Statement stmt1 = connection.createStatement();

		String query = "SELECT * FROM employee";
		ResultSet rs = stmt.executeQuery(query);

		ArrayList<Employee> emplist = new ArrayList<Employee>();

		while (rs.next()) {
			int id = rs.getInt("Id");
			String name = rs.getString("Name");
			String phoneno = rs.getString("Phoneno");
			String Department = rs.getString("Deptit");
			Date CreatedDate = rs.getDate("CreatedDTm");
			String Status = rs.getString("Status");
			String Created_By = rs.getString("CreatedBy");
			Date updatedDate = rs.getDate("UpdatedDTm");
			String updatedBy = rs.getString("UpdatedBy");
			int cid= rs.getInt("cid");
			String query1="Select* from country";
			ResultSet rs1=stmt1.executeQuery(query1);
			String cname=" ";
			while(rs1.next()){
				cname=rs1.getString("cname");
			}
			Country country=new Country();
			country.setCid(cid);
			country.setCname(cname);
			Employee emp = new Employee(id, name, phoneno, Department, Status, CreatedDate, Created_By, updatedDate,
					updatedBy,country);

			emplist.add(emp);
		}
		return emplist;

	}

	@RequestMapping("/getallemployeebyid/{id}")
	public Employee getAllEmployeebyid(@PathVariable int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionClass.getConnectionValues();
		Statement stmt = connection.createStatement();
		Statement stmt1 = connection.createStatement();
		String query = "SELECT * FROM employee where id=" + id;
		ResultSet rs = stmt.executeQuery(query);

		Employee emp = null;
		while (rs.next()) {
			int id1 = rs.getInt("Id");
			String name = rs.getString("Name");
			String phoneno = rs.getString("Phoneno");
			String Department = rs.getString("Deptit");
			Date CreatedDate = rs.getDate("CreatedDTm");
			String Status = rs.getString("Status");
			String Created_By = rs.getString("CreatedBy");
			Date updatedDate = rs.getDate("UpdatedDTm");
			String updatedBy = rs.getString("UpdatedBy");
			int cid = rs.getInt("cid");

			String query1 = "SELECT cname from country where cid=" + cid;
			ResultSet rs1 = stmt1.executeQuery(query1);
			String cname="";
			while (rs1.next()) {
				 cname = rs1.getString("cname");
			}
			Country country = new Country();
			country.setCid(cid);
			country.setCname(cname);

			emp = new Employee(id1, name, phoneno, Department, Status, CreatedDate, Created_By, updatedDate, updatedBy,
					country);

		}

		return emp;

	}

	@RequestMapping("/getallemployeebystatus/{status}")
	public ArrayList<Employee> getAllEmployeebystatus(@PathVariable String status)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionClass.getConnectionValues();
		Statement stmt = connection.createStatement();
		Statement stmt1 = connection.createStatement();
		String query = "SELECT * FROM employee where status='" + status + "'";
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Employee> empstatuslist = new ArrayList<Employee>();
		Employee emp = null;
		while (rs.next()) {
			int id1 = rs.getInt("Id");
			String name = rs.getString("Name");
			String phoneno = rs.getString("Phoneno");
			String Department = rs.getString("Deptit");
			Date CreatedDate = rs.getDate("CreatedDTm");
			String Status = rs.getString("Status");
			String Created_By = rs.getString("CreatedBy");
			Date updatedDate = rs.getDate("UpdatedDTm");
			String updatedBy = rs.getString("UpdatedBy");
			int cid = rs.getInt("cid");

			String query1 = "SELECT cname from country where cid=" + cid;
			ResultSet rs1 = stmt1.executeQuery(query1);
			String cname="";
			while (rs1.next()) {
				 cname = rs1.getString("cname");
			}
			Country country = new Country(cid,cname);
			country.setCid(cid);
			country.setCname(cname);


			emp = new Employee(id1, name, phoneno, Department, Status, CreatedDate, Created_By, updatedDate, updatedBy,country);

			empstatuslist.add(emp);

		}

		return empstatuslist;

	}

	@PostMapping("/addemployee")

	public String addEmployee(@RequestBody Employee employee) throws ClassNotFoundException, SQLException {
		System.out.println(employee.getName());
		System.out.println(employee.getCountry().getCid());
		System.out.println(employee.getCountry().getCname());
		Connection connection = ConnectionClass.getConnectionValues();
		PreparedStatement psmt = connection.prepareStatement(
				"insert into employee(Name,Phoneno,Deptit,Status,CreatedDTm,CreatedBy,UpdatedDTm,UpdatedBy,cid) values(?,?,?,?,?,?,?,?,?)");

		psmt.setString(1, employee.getName());
		psmt.setString(2, employee.getPhoneno());
		psmt.setString(3, employee.getDeptit());
		psmt.setString(4, employee.getStatus());

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		psmt.setDate(5, date);
		psmt.setString(6, employee.getCreatedBy());
		psmt.setDate(7, date);
		psmt.setString(8, employee.getUpdatedBy());
		psmt.setInt(9, employee.getCountry().getCid());
		int i = psmt.executeUpdate();
		if (i > 0) {
			return "Employee inserted succesfully";

		} else {
			return "error";
		}

	}

	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee employee) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionClass.getConnectionValues();
		PreparedStatement psmt = con.prepareStatement(
				"update employee set Name=?,Phoneno=?,Deptit=?,Status=?,CreatedDTm=? ,CreatedBy=?,UpdatedDTm=?,UpdatedBy=?,cid=? where id=?");

		psmt.setString(1, employee.getName());
		psmt.setString(2, employee.getPhoneno());
		psmt.setString(3, employee.getDeptit());
		psmt.setString(4, employee.getStatus());

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		psmt.setDate(5, employee.getCreatedDTm());

		psmt.setString(6, employee.getCreatedBy());

		psmt.setDate(7, employee.getUpdatedDTm());
		psmt.setDate(8, date);
		psmt.setInt(9, employee.getCountry().getCid());
		psmt.setInt(10, employee.getId());

		int i = psmt.executeUpdate();
		if (i > 0) {
			return "employee" + employee.getName() + "updated Successfully";
		} else {
			return "error";
		}

	}

	@DeleteMapping("/deleterecordfromemployeebyid/{id}")
	public String deleteEmployee(@PathVariable int id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionClass.getConnectionValues();
		Statement stmt = conn.createStatement();
		String query = "DELETE FROM Employee where id=" + id;
		int i = stmt.executeUpdate(query);
		if (i > 0) {
			return "Employee record of" + id + "get deleted";
		} else {
			return "Error";
		}

	}

	@GetMapping("/getlistbeforetoday")
	public ArrayList<Employee> listBefore() throws ClassNotFoundException, SQLException

	{
		Connection conn = ConnectionClass.getConnectionValues();
		Statement stmt = conn.createStatement();
		Statement stmt1=conn.createStatement();
		ArrayList<Employee> arrlistemp = new ArrayList<>();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		System.out.println("Todays Date is" + " " + date);
		String query = "SELECT * From Employee where CreatedDTm <'" + date + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("Id");
			String name = rs.getString("Name");
			String Phone = rs.getString("Phoneno");
			String Department = rs.getString("Deptit");
			String Status = rs.getString("Status");

			Date Createddate = rs.getDate("CreatedDTm");
			String createdby = rs.getString("CreatedBy");
			Date UpdatedDate = rs.getDate("UpdatedDTm");
			String UpdatedBy = rs.getString("UpdatedBy");
			int cid=rs.getInt("cid");

			String query1 = "SELECT cname from country where cid=" + cid;
			ResultSet rs1 = stmt1.executeQuery(query1);
			String cname="";
			while (rs1.next()) {
				 cname = rs1.getString("cname");
			}
			Country country = new Country(cid,cname);
			country.setCid(cid);
			country.setCname(cname);

			Employee emp = new Employee(id, name, Phone, Department, Status, Createddate, createdby, UpdatedDate,
					UpdatedBy,country);
			arrlistemp.add(emp);
		}
		return arrlistemp;
	}
	  @GetMapping("/getcountrybyid/{cid}")
	public Country getcountrybyid(@PathVariable  int cid) throws ClassNotFoundException, SQLException{
		  System.out.println(cid);
		  Connection con = ConnectionClass.getConnectionValues();
		  Statement stmt=con.createStatement();
		  String query="select cname from country where cid="+cid;
		 ResultSet rs= stmt.executeQuery(query);
		 Country country= new Country();
		 country.setCid(cid);
		 if(rs.next()){
			
			 String cname=rs.getString("cname");
			 country.setCname(cname);
		 }
		return country;
		
		
	}
	  @PostMapping("/addcountry")
	  public String addCountry(@RequestBody Country country) throws ClassNotFoundException, SQLException{
		  Connection con= ConnectionClass.getConnectionValues();
		  Statement stmt= con.createStatement();
		  String query="insert into country (cname) values('"+country.getCname()+"')";
		  int i= stmt.executeUpdate(query);
		  if(i>0){
			  return"country"+country.getCname()+"added succesfully";
		  }else{
			  return "error";
		  }
	
		  
	  }

	  @PutMapping("/updatecountry")
	  public String getcountry(@RequestBody Country country) throws ClassNotFoundException, SQLException{
		  Connection con= ConnectionClass.getConnectionValues();
		  Statement stmt=con.createStatement();
		  System.out.println(country.getCid());
		  String query="update country set cname='"+country.getCname()+"' where cid="+country.getCid();
	  int i= stmt.executeUpdate(query);
	  if(i>0){
		  return"country"+country.getCid()+"updated Successfully";
	  }else
		  return "Error";
	  }
	  
	  @DeleteMapping("deletecountrybyid/{cid}")
	   public String deleteCountrybyid(@PathVariable int cid) throws ClassNotFoundException, SQLException
	   {
		  Connection con=ConnectionClass.getConnectionValues();
		  Statement stmt=con.createStatement();
		  String query="delete from country where cid="+cid;
		  int i=stmt.executeUpdate(query);
		  if(i>0){
			  return"country"+cid+"deleted successfully";
		  }
		return "Error";
		  
	   }
}
