package sqlscripttests;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class SQLScriptLoadTests {

	@Test
	public void testSQLScripts() {
		try {
			Reader confReader = Resources.getResourceAsReader("configuration/testConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(confReader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			ScriptRunner runner = new ScriptRunner(sqlSession.getConnection());

			Reader createDBReader = Resources.getResourceAsReader("sqlScripts/createDB.sql");
			Reader fillUpDBReader = Resources.getResourceAsReader("sqlScripts/insertDB.sql");
			Reader deleteDBReader = Resources.getResourceAsReader("sqlScripts/dropDB.sql");
			
			runner.runScript(createDBReader);
			runner.runScript(fillUpDBReader);
			runner.runScript(deleteDBReader);

			confReader.close();
			createDBReader.close();
			fillUpDBReader.close();
			deleteDBReader.close();
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
