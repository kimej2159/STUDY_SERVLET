package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class CustomerDAO {
	private SqlSession sql;
	
	private void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
	//신규고객저장
	public void customer_insert(CustomerDTO dto) {
		connect();
		sql.insert("cu.insert",dto);
	}
	//선택한 고객정보 삭제
	public void customer_delete(int id) {
		connect();
		sql.delete("cu.delete", id);
	}
	
	//선택한 고객정보 변경저장
	public int customer_update(CustomerDTO dto) {
		connect();
		int dml = sql.update("cu.update", dto);
		return dml;
	}
	
	//선택한 고객정보조회
	public CustomerDTO customer_info(int id) {
		connect();
		CustomerDTO dto = sql.selectOne("cu.info", id);
		return dto;
	}
	
	//고객목록조회
	public List<CustomerDTO> customer_list() {
		connect();
		List<CustomerDTO> list = sql.selectList("cu.list");
		return list;
	}
}
