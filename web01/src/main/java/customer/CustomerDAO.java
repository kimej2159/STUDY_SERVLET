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
	
	
	//고객목록조회
	public List<CustomerDTO> customer_list() {
		connect();
		List<CustomerDTO> list = sql.selectList("cu.list");
		return list;
	}
}
