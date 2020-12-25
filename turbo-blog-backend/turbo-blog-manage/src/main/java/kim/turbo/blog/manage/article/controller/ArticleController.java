package kim.turbo.blog.manage.article.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.base.AbstractController;
import kim.turbo.blog.common.constants.RedisCacheNames;
import kim.turbo.blog.common.enums.ModuleEnum;
import kim.turbo.blog.common.mq.annotation.RefreshEsMqSender;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.validator.ValidatorUtils;
import kim.turbo.blog.entity.article.Article;
import kim.turbo.blog.entity.article.dto.ArticleDTO;
import kim.turbo.blog.manage.article.service.ArticleService;
import kim.turbo.blog.manage.operation.service.RecommendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * ArticleController
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 00:32
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleController extends AbstractController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RecommendService recommendService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/list")
    @RequiresPermissions("article:list")
    public Result listArticle(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);
        return Result.ok().put("page", page);
    }

    @GetMapping("/info/{articleId}")
    @RequiresPermissions("article:list")
    public Result info(@PathVariable Integer articleId) {
        ArticleDTO article = articleService.getArticle(articleId);
        return Result.ok().put("article", article);
    }

    @PostMapping("/save")
    @RequiresPermissions("article:save")
    //    @CacheEvict(allEntries = true)(allEntries = true,cacheNames = "saveArticle")
    @RefreshEsMqSender(sender = "dbblog-manage-saveArticle")
    public Result saveArticle(@RequestBody ArticleDTO article) {
        ValidatorUtils.validateEntity(article);
        articleService.saveArticle(article);
        return Result.ok();
    }

    @PutMapping("/update")
    @RequiresPermissions("article:update")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    @RefreshEsMqSender(sender = "dbblog-manage-updateArticle")
    public Result updateArticle(@RequestBody ArticleDTO article) {
        ValidatorUtils.validateEntity(article);
        articleService.updateArticle(article);
        return Result.ok();
    }

    @PutMapping("/update/status")
    @RequiresPermissions("article:update")
    //    @CacheEvict(allEntries = true)(allEntries = true, cacheNames = "updateStatus")
    @RefreshEsMqSender(sender = "dbblog-manage-updateStatus")
    public Result updateStatus(@RequestBody Article article) {

        articleService.updateById(article);
        return Result.ok();
    }


    @DeleteMapping("/delete")
    @RequiresPermissions("article:delete")
    @Transactional(rollbackFor = Exception.class)
    //    @CacheEvict(allEntries = true)(allEntries = true)
    @RefreshEsMqSender(sender = "dbblog-manage-deleteArticle")
    public Result deleteBatch(@RequestBody Integer[] articleIds) {
        recommendService.deleteBatchByLinkId(articleIds, ModuleEnum.ARTICLE.getValue());
        articleService.deleteBatch(articleIds);
        return Result.ok();
    }

    @DeleteMapping("/cache/refresh")
    @RequiresPermissions("article:cache:refresh")
    public Result flush() {
        Set<String> keys = redisTemplate.keys(RedisCacheNames.PROFIX + "*");
        redisTemplate.delete(keys);
        return Result.ok();
    }

}
