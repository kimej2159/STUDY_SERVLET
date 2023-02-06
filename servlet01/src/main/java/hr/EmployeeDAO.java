package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void connect() {
	
		try {
			//1. 드라이버로딩 : 드라이버 관리자가 생성됨
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.DB에 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "0000");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 사원정보를 신규저장
	public void employee_regist(EmployeeDTO dto) {
		//DB연결
		connect();
		
		// 쿼리문 작성
		String sql = "insert into employees"
				+ "(employee_id, last_name, first_name, email, phone_number,"
				+ "salary, job_id, department_id, hire_date)"
				+ "values(employees_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		// 쿼리문 실행
		// 1. 조회 : executeQurey()
		// 2. DML :  executeUpdate()
		try {
			ps = conn.prepareCall(sql);
			ps.setString(1, dto.getLast_name());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPhone_number());
			ps.setInt(5, dto.getSalary());
			ps.setString(6, dto.getJob_id());
			ps.setInt(7, dto.getDepartment_id());
			
			int count = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// 삭제한 사원 리스트 조회
	public void employee_delete(int id) {
		//DB연결
		connect();
		
		// 쿼리문 작성
		String sql = "delete from employees where employee_id = ? ";
				
		// 쿼리문 실행
		// 1. 조회 : executeQurey()
		// 2. DML :  executeUpdate()
		try {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmployee_id(id);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		
	}
	
	
	
	
	// 전체 부서 목록 조회
	public ArrayList<DepartmentDTO> department_list() {
		connect();
		
		ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		try {
			String sql = "select * from departments";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setDepartment_name(rs.getString("department_name"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		}finally {
			disconnect();
		}
		return list;
	}
	

	
	
	//선택한 사원정보 조회
	public EmployeeDTO employee_info(int employee_id) {
		EmployeeDTO dto = new EmployeeDTO();	
		// DB 연결
		connect();
		try {
			// 쿼리문 선언 	
			
			String sql = "select last_name ||' ' || first_name name, e.*  " 
					+ "from department d right outer join employees e "
					+ "on e.department_id= d.department_id"
					+ "where employee_id = ?";
			
			
			// 쿼리문 실행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			//조회결과값을 dto에 담기
			rs.next();
			{
				dto.setDepartment_name(rs.getString("department_name"));
				dto.setName(rs.getString("last_name") + " "
								+ rs.getString("first_name"));
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		// 자원회수
		// 사원정보 반환
			
			
		return dto;
	}
	
	
	// 전체 사원정보를 조회
	public ArrayList<EmployeeDTO> employee_list() {
		connect();
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			String sql = "select * from employees "
					+"order by employee_id desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setName(rs.getString("last_name") + " "
								+ rs.getString("first_name"));
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		
		return list;
	}
	//자원회수
		private void disconnect() {
			if( rs!=null ) {
				try{ rs.close(); }catch(Exception e) {}
			}
			if( ps!=null ) {
				try{ ps.close(); }catch(Exception e) {}
			}
			if( conn!=null ) {
				try{ conn.close(); }catch(Exception e) {}
			}
		}
	}























