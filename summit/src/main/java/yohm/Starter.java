package yohm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 鍔熻兘绠�杩� (summit)
 *
 * @author tarena
 * @date 2018/8/13
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("yohm.web.mapper")
public class Starter {
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
