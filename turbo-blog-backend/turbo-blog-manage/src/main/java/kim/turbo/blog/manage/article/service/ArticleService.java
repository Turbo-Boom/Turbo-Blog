package kim.turbo.blog.manage.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.article.Article;
import kim.turbo.blog.entity.article.dto.ArticleDTO;

import java.util.Map;

/**
 * ArticleService
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 00:35
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询博文列表
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存博文文章
     *
     * @param blogArticle
     */
    void saveArticle(ArticleDTO blogArticle);

    /**
     * 批量删除
     *
     * @param articleIds
     */
    void deleteBatch(Integer[] articleIds);

    /**
     * 更新博文
     *
     * @param blogArticle
     */
    void updateArticle(ArticleDTO blogArticle);

    /**
     * 获取文章对象
     *
     * @param articleId
     * @return
     */
    ArticleDTO getArticle(Integer articleId);

    /**
     * 判断是否有文章
     *
     * @param id
     * @return
     */
    boolean checkByCategory(Integer id);

}
