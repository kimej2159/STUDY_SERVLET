package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class TestDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private SqlSession sql;
	
	//사원수를 반환하는 메소드
	public int select_count() {
		connect();
		int count = sql.selectOne("test.count");
		return count;
	}
	
	//현재 시각을 반환하는 메소드
	public String  select_now() {
		connect();
		String now = sql.selectOne("test.now");
		return now;
	}
	
	
	
	//오늘 날짜를 반환하는 메소드
	private void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
		
//		String resource = "mybatis/config.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory 
//				= new SqlSessionFactoryBuilder().build(inputStream);
//			sql = sqlSessionFactory.openSession(true);
//		} catch (IOException e) {
//		}
		
		/*
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection();			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	public Date select_today() {
		connect();
		Date today = sql.selectOne("test.today");
		return today;
		
//		Date today = null;
//		String sql = "select sysdate from dual";
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			rs.next();
//			today = rs.getDate("sysdate");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}finally {
//			disconnect();
//		}
//		return today;
	}
	
	private void disconnect() {
		if( rs!=null ) {
			try{ rs.close(); } catch(Exception e) {}
		}
		if( ps!=null ) {
			try{ ps.close(); } catch(Exception e) {}
		}
		if( conn!=null ) {
			try{ conn.close(); } catch(Exception e) {}
		}
	}
	
}
