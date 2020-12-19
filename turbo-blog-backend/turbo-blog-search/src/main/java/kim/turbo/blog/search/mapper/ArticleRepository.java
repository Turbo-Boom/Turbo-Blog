package kim.turbo.blog.search.mapper;

import kim.turbo.blog.entity.article.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:33
 */
@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
}
