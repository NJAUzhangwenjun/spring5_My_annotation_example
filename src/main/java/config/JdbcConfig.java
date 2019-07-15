package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 张文军
 * @Description:和数据库连接池相关的配置
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1513:40
 */
@Configuration
public class JdbcConfig {

	/**
	 * 从容器中获取数据并赋值
	 */
	@Value("${jabc.driver}")
	private String driver;
	@Value("${jabc.url}")
	private String url;
	@Value("${jabc.username}")
	private String username;
	@Value("${jabc.password}")
	private String password;


	/**
	 * @param dataSource 配置QueryRunner
	 * @return
	 */
	@Bean(name = "runner")
	@Scope("prototype")
	public QueryRunner creatQueryRunner(DataSource dataSource) {
		return new QueryRunner(dataSource);
	}

	/**
	 * 配置连接池数据datasource
	 *
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource creatDataSource() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

	}

}
