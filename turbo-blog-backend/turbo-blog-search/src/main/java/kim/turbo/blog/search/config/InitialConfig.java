package kim.turbo.blog.search.config;

import com.rabbitmq.client.ConnectionFactory;
import kim.turbo.blog.common.constants.RabbitMqConstants;
import kim.turbo.blog.common.util.RabbitMqUtils;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:31
 */
@Configuration
@ConditionalOnClass(ElasticsearchClient.class)
public class InitialConfig {

    @Resource
    private RabbitMqUtils rabbitMqUtils;

    /**
     * 项目启动时重新导入索引
     */
    @PostConstruct
    public void initEsIndex(){
        rabbitMqUtils.send(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE,"turbo-search init index");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setAutomaticRecoveryEnabled(false);
    }
}
