package kim.turbo.blog.manage.book.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.base.AbstractController;
import kim.turbo.blog.common.constants.RedisCacheNames;
import kim.turbo.blog.common.validator.ValidatorUtils;
import kim.turbo.blog.entity.book.BookSense;
import kim.turbo.blog.manage.book.service.BookSenseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * 读后感 控制器
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:11
 */

@RestController
@CacheConfig(cacheNames ={RedisCacheNames.RECOMMEND,RedisCacheNames.TAG,RedisCacheNames.BOOK})
@RequestMapping("/admin/book/sense")
public class BookSenseController extends AbstractController {

    @Autowired
    private BookSenseService bookSenseService;

    @GetMapping("/{bookId}")
    @RequiresPermissions("book:info")
    public Result getReadSense(@PathVariable Integer bookId) {
        BookSense bookSense = bookSenseService.getBookSense(bookId);
        return Result.ok().put("bookSense",bookSense);
    }
    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("book:save")
//    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result save(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSenseService.save(bookSense);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("book:update")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result update(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSenseService.updateById(bookSense);
        return Result.ok();
    }

}
