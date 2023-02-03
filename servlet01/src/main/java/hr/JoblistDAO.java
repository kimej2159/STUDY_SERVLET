package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JoblistDAO {
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
	
	// 업무 목록 조회
	public ArrayList<JoblistDTO> Joblist() {
		connect();
		ArrayList<JoblistDTO> list = new ArrayList<JoblistDTO>();
		
		try {
			String sql = "select * from Jobs";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JoblistDTO dto = new JoblistDTO();
				dto.setJob_id(rs.getString("job_id"));
				dto.setJob_title(rs.getString("job_title"));
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