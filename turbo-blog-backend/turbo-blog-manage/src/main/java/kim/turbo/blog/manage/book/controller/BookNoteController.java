package kim.turbo.blog.manage.book.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.base.AbstractController;
import kim.turbo.blog.common.constants.RedisCacheNames;
import kim.turbo.blog.common.enums.ModuleEnum;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.validator.ValidatorUtils;
import kim.turbo.blog.entity.book.BookNote;
import kim.turbo.blog.entity.book.dto.BookNoteDTO;
import kim.turbo.blog.manage.book.service.BookNoteService;
import kim.turbo.blog.manage.operation.service.RecommendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * BookNoteController
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:07
 */
@RestController
@RequestMapping("/admin/book/note")
@CacheConfig(cacheNames ={RedisCacheNames.RECOMMEND,RedisCacheNames.TAG,RedisCacheNames.BOOK,RedisCacheNames.BOOKNOTE,RedisCacheNames.TIMELINE})

public class BookNoteController extends AbstractController {



    @Autowired
    private BookNoteService bookNoteService;

    @Autowired
    private RecommendService recommendService;

    @GetMapping("/list")
    @RequiresPermissions("book:note:list")
    public Result listBookNote(@RequestParam Map<String, Object> params) {
        PageUtils page = bookNoteService.queryPage(params);
        return Result.ok().put("page",page);
    }

    @GetMapping("/info/{bookNoteId}")
    @RequiresPermissions("book:note:list")
    public Result info(@PathVariable Integer bookNoteId) {
        BookNoteDTO bookNote = bookNoteService.getBookNote(bookNoteId);
        return Result.ok().put("bookNote",bookNote);
    }

    @PostMapping("/save")
    @RequiresPermissions("book:note:save")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result saveBookNote(@RequestBody BookNoteDTO bookNote){
        ValidatorUtils.validateEntity(bookNote);
        bookNoteService.saveBookNote(bookNote);
        return Result.ok();
    }

    @PutMapping("/update")
    @RequiresPermissions("book:note:update")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result updateBookNote(@RequestBody BookNoteDTO bookNote){
        ValidatorUtils.validateEntity(bookNote);
        bookNoteService.updateBookNote(bookNote);
        return Result.ok();
    }

    @PutMapping("/update/status")
    @RequiresPermissions("book:note:update")
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result updateStatus(@RequestBody BookNote bookNote) {
        bookNoteService.updateById(bookNote);
        return Result.ok();
    }


    @DeleteMapping("/delete")
    @RequiresPermissions("book:note:delete")
    @Transactional(rollbackFor = Exception.class)
    //    @CacheEvict(allEntries = true)(allEntries = true)
    public Result deleteBatch(@RequestBody Integer[] bookNoteIds){
        recommendService.deleteBatchByLinkId(bookNoteIds, ModuleEnum.BOOK_NOTE.getValue());
        bookNoteService.deleteBatch(bookNoteIds);
        return Result.ok();
    }

}
