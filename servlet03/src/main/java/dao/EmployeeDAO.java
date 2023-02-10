package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.EmployeeDTO;
import mybatis.MybatisFactory;

public class EmployeeDAO {
	private SqlSession sql;
	private void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
	
	// 사원목록조회 
	public List<EmployeeDTO> employee_list() {
		connect();
		List<EmployeeDTO> list = sql.selectList("hr.list");
		return list;
	}
	
	//해당 사원정보조회
		public EmployeeDTO employee_info(int employee_id) {
			connect();
			EmployeeDTO dto = sql.selectOne("hr.info", employee_id);
			return dto;
		}
		
//	// 사원 정보 조회
//	public List<EmployeeDTO> employee_info(int employee_id) {
//		connect();
//		List<EmployeeDTO> info = sql.selectList("hr.info", employee_id);
//		return info;
//		
//	}
	

	
}
