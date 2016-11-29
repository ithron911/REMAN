package sqlscripttests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatisConfig  extends SQLScriptLoadTests{

	private static final String MYBATIS_CONFIG_PATH = "src/main/resources/configuration/testConfig.xml";

	@Test
	public void testLoadMyBatisConfig() throws IOException {
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DATABASE));
		props.put("username", USER);
		props.put("password", PASSWORD);

		File config = new File(MYBATIS_CONFIG_PATH);
		InputStream inputStream = new FileInputStream(config);
		SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);

		inputStream.close();
		
	}
}
