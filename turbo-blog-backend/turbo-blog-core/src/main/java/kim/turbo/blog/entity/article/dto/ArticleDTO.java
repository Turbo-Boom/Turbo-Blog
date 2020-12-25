package kim.turbo.blog.entity.article.dto;


import kim.turbo.blog.entity.article.Article;
import kim.turbo.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author turbo
 * @date 2019/01/08 19:04
 * @email 571002217@qq.com
 * @description
 */
@Data
public class ArticleDTO extends Article {

    private List<Tag> tagList;

}
