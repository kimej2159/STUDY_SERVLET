package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSessionFactory factory;
	
	//싱글턴 패턴으로 한번만 생성하도록 (scope)
	public static SqlSessionFactory getInstance() {
		if(factory == null) {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				factory
					= new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
			}
		}
		return factory;
	}
}
