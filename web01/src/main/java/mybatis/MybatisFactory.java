package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSessionFactory factory;
	
	static {
		String resource = "mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static SqlSessionFactory getInstance() {
		return factory;
	}
}
