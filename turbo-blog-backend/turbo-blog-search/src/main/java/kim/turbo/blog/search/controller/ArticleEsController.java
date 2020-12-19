package kim.turbo.blog.search.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.rabbitmq.client.Channel;
import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.constants.RabbitMqConstants;
import kim.turbo.blog.entity.article.Article;
import kim.turbo.blog.portal.operation.article.service.ArticleService;
import kim.turbo.blog.search.mapper.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:32
 */

@RestController
@Slf4j
public class ArticleEsController {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private ArticleService articleService;


    /**
     * 搜索标题，描述，内容
     * @param keywords
     * @return
     */
    @GetMapping("articles/search")
    public Result search(@RequestParam("keywords") String keywords){
        // 对所有索引进行搜索
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(keywords);

        Iterable<Article> listIt =  articleRepository.search(queryBuilder);

        //Iterable转list
        List<Article> articleList= Lists.newArrayList(listIt);

        return Result.ok().put("articleList",articleList);
    }

    @RabbitListener(queues= RabbitMqConstants.REFRESH_ES_INDEX_QUEUE)
    public void refresh(Message message, Channel channel){
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            articleRepository.deleteAll();
            List<Article> list = articleService.list(new QueryWrapper<Article>().lambda().eq(Article::getPublish,true));
            articleRepository.saveAll(list);
            log.info(message.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}