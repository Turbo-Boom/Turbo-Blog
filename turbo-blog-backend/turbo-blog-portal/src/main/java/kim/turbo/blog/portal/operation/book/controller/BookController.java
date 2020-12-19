package kim.turbo.blog.portal.operation.book.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.constants.RedisCacheNames;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.book.vo.BookVO;
import kim.turbo.blog.portal.operation.book.service.BookService;
import kim.turbo.blog.portal.operation.common.annotation.LogLike;
import kim.turbo.blog.portal.operation.common.annotation.LogView;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:10
 */
@RestController("bookPortalController")
@CacheConfig(cacheNames = {RedisCacheNames.BOOK})
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    @LogView(type = "book")
    public Result getBook(@PathVariable Integer bookId){
        BookVO book = bookService.getBookVo(bookId);
        return Result.ok().put("book",book);
    }

    @GetMapping("/books")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = bookService.queryPageCondition(params);
        return Result.ok().put("page",page);
    }

    @PutMapping("/book/like/{id}")
    @LogLike(type = "book")
    public Result likeBook(@PathVariable Integer id) {
        return Result.ok();
    }


}