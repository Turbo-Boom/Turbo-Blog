package kim.turbo.blog.portal.operation.article.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.common.enums.ModuleEnum;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.util.Query;
import kim.turbo.blog.entity.article.Article;
import kim.turbo.blog.entity.article.vo.ArticleVO;
import kim.turbo.blog.mapper.article.ArticleMapper;
import kim.turbo.blog.manage.operation.service.TagService;
import kim.turbo.blog.portal.operation.article.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:03
 */

@Service("ArticlePortalService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private TagService tagService;

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<ArticleVO> page = new Query<ArticleVO>(params).getPage();
        List<ArticleVO> articleList = baseMapper.queryPageCondition(page, params);
        // 封装ArticleVo
        page.setRecords(articleList);
        return new PageUtils(page);
    }

    /**
     * 获取ArticleVo对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVO getArticleVo(Integer articleId) {
        Article article = baseMapper.selectById(articleId);
        ArticleVO articleVo = new ArticleVO();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setTagList(tagService.listByLinkId(articleId, ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

    /**
     * 获取简单的Article对象
     * @param articleId
     * @return
     */
    @Override
    public ArticleVO getSimpleArticleVo(Integer articleId) {
        ArticleVO articleVo = baseMapper.getSimpleArticleVo(articleId);
        articleVo.setTagList(tagService.listByLinkId(articleId,ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

}
