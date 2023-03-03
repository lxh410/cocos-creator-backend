package cocos.creator.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"cocos.creator"})
@MapperScan("cocos.creator.account.mapper")
public class CocosCreatorAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocosCreatorAccountApplication.class, args);
    }

}
