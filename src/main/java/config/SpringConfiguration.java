package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 张文军
 * @Description:这是一个配置内，他的作用是和bean.xml一样。 spring中的新注解
 * **    @Configuration：标明这是一个配置类
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/7/1511:48
 */
@Configuration
//@ComponentScan(basePackages = {"com.njau","config"})
@ComponentScan(basePackages = {"com.njau"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
