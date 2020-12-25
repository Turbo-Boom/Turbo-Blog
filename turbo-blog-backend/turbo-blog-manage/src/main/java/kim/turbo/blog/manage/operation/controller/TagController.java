package kim.turbo.blog.manage.operation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.base.AbstractController;
import kim.turbo.blog.common.constants.RedisCacheNames;
import kim.turbo.blog.common.enums.ModuleEnum;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.validator.ValidatorUtils;
import kim.turbo.blog.entity.operation.Tag;
import kim.turbo.blog.entity.operation.TagLink;
import kim.turbo.blog.mapper.operation.TagLinkMapper;
import kim.turbo.blog.manage.operation.service.TagService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 标签 前端控制器
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:18
 */
@RestController
@CacheConfig(cacheNames = RedisCacheNames.TAG)
@RequestMapping("/admin/operation/tag")
public class TagController extends AbstractController {
    @Resource
    private TagService tagService;

    @Resource
    private TagLinkMapper tagLinkMapper;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("operation:tag:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = tagService.queryPage(params);

        return Result.ok().put("page", page);
    }

    @GetMapping("/select")
    @RequiresPermissions("operation:tag:list")
    public Result select(@RequestParam("type") Integer type){
        List<Tag> tagList = tagService.list(new QueryWrapper<Tag>().lambda().eq(type != null,Tag::getType,type));
        return Result.ok().put("tagList",tagList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("operation:tag:info")
    public Result info(@PathVariable("id") String id){
        Tag tag = tagService.getById(id);

        return Result.ok().put("tag", tag);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("operation:tag:save")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result save(@RequestBody Tag tag){
        ValidatorUtils.validateEntity(tag);
        tagService.save(tag);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("operation:tag:update")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result update(@RequestBody Tag tag){
        ValidatorUtils.validateEntity(tag);
        tagService.updateById(tag);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("operation:tag:delete")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result delete(@RequestBody String[] ids){
        for (String id : ids) {
            List<TagLink> tagLinkList = tagLinkMapper.selectList(new QueryWrapper<TagLink>().lambda().eq(TagLink::getTagId, id));
            if(!CollectionUtils.isEmpty(tagLinkList)) {
                TagLink tagLink = tagLinkList.get(0);
                if (tagLink.getType().equals(ModuleEnum.ARTICLE.getValue())) {
                    return Result.error("该标签下有文章，无法删除");
                }
                if (tagLink.getType().equals(ModuleEnum.BOOK.getValue())) {
                    return Result.error("该标签下有图书，无法删除");
                }
                if(tagLink.getType().equals(ModuleEnum.BOOK_NOTE.getValue())) {
                    return Result.error("该标签下有笔记，无法删除");
                }
            }
        }
        tagService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
