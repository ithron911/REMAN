package sqlscripttests;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;

import com.mysql.cj.jdbc.Driver;



public class SQLScriptLoadTests {

	protected static String HOST;
	protected static Integer PORT;
	protected static String DATABASE;
	protected static String USER;
	protected static String PASSWORD;
	protected static String MYBATIS_CONFIG;

	@BeforeClass
	public static void beforeClass() {

		try {
			HOST = System.getProperty("database.host");
			PORT = Integer.parseInt(System.getProperty("database.port"));
			DATABASE = System.getProperty("database.db");
			USER = System.getProperty("database.user");
			PASSWORD = System.getProperty("database.password");
			MYBATIS_CONFIG = System.getProperty("mybatis.config");
		} catch (NumberFormatException ex) {
			Assume.assumeNoException(ex);
		}
		Assume.assumeNotNull(HOST,PORT,DATABASE,USER,PASSWORD,MYBATIS_CONFIG);
		runSQLScript("sqlScripts/createDB.sql");

	}

	@AfterClass
	public static void afterClass() {

		runSQLScript("sqlScripts/dropDB.sql");

	}

	@Before
	public void setUp() {
		
			runSQLScript("sqlScripts/insertDB.sql");
		
	}

	@After
	public void tearDown() {
		
			runSQLScript("sqlScripts/deleteRecords.sql");
		
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
}
