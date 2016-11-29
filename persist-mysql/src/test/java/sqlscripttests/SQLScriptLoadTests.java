package sqlscripttests;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.cj.jdbc.Driver;



public class SQLScriptLoadTests {

	private static String HOST;
	private static Integer PORT;
	private static String DATABASE;
	private static String USER;
	private static String PASSWORD;

	@BeforeClass
	public static void beforeClass() {

		try {
			HOST = System.getProperty("database.host");
			PORT = Integer.parseInt(System.getProperty("database.port"));
			DATABASE = System.getProperty("database.db");
			USER = System.getProperty("database.user");
			PASSWORD = System.getProperty("database.password");
		} catch (NumberFormatException ex) {
			Assume.assumeNoException(ex);
		}

		runSQLScript("sqlScripts/createDB.sql");

	}

	@AfterClass
	public static void afterClass() {

		runSQLScript("sqlScripts/dropDB.sql");

	}

	private static void runSQLScript(String scriptFilePath) {

		try {
			Class.forName(Driver.class.getName());
		} catch (ClassNotFoundException e) {
			Assume.assumeNoException(e);
		}
		final String connectionURL = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DATABASE);
		Connection connection;
		try {
			connection = DriverManager.getConnection(connectionURL, USER, PASSWORD);
			connection.setAutoCommit(false);
			ScriptRunner runner = new ScriptRunner(connection);

			Reader createDBReader = Resources.getResourceAsReader(scriptFilePath);
			runner.runScript(createDBReader);
			createDBReader.close();
		} catch (SQLException e) {
			Assume.assumeNoException(e);
		} catch (IOException e) {
			Assume.assumeNoException(e);
		}
		
	}

	@Before
	public void setUp() {
		
			runSQLScript("sqlScripts/insertDB.sql");
		
	}

	@After
	public void tearDown() {
		
			runSQLScript("sqlScripts/deleteRecords.sql");
		
	}

	@Test
	public void testSQLScripts() {
		System.out.println("Test 001");
	}
	
	@Test
	public void testSQLScripts1() {
		System.out.println("Test 02");
	}
}
