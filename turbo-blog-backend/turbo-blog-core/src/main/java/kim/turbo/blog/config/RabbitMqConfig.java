package kim.turbo.blog.config;

import kim.turbo.blog.common.constants.RabbitMqConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMQConfig
 *
 * @author turbo
 * @date 2019/03/16 21:59
 * @email 571002217@qq.com
 * @description
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE);
    }
}
