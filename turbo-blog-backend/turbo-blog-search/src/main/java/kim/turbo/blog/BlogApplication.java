package kim.turbo.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020/12/19 2:34 上午
 * @version v1.0.0
 */
@SpringBootApplication
@EnableCaching
public class BlogApplication {


    public static void main(String[] args) {
        /**
         * ElasticSearch 所需的临时设置，待解决
         */
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(BlogApplication.class, args);
    }
}
