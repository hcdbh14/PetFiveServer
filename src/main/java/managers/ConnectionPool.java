package managers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
* This class uses HikariCP library to manage the connection pool.
<p>
*/
public class ConnectionPool {

	private static HikariConfig config = new HikariConfig();
	static HikariDataSource ds;
	private static ConnectionPool instance = null;
	
	static {
		config.setJdbcUrl("jdbc:mysql://localhost:3306/Lost_Pets");
		config.setUsername("root");
		config.setPassword("lostpetdb");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}


	Hashtable<String, Connection> conList;



	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}

		return instance;
	}

	public static Connection getConnection() {

		try (Connection con = ds.getConnection()) {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	public Connection restoreConnection(String clientIP) {
		return null;
	}

	public void closeAllConnections() {
		for (String key : conList.keySet()) {
			try {
				conList.get(key).close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
