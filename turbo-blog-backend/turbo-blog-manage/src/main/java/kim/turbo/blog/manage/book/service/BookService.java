package kim.turbo.blog.manage.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.book.dto.BookDTO;

import java.util.Map;

/**
 * 图书表 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:04
 */
public interface BookService extends IService<Book> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存图书
     *
     * @param book
     */
    void saveBook(BookDTO book);

    /**
     * 获取图书对象
     *
     * @param id
     * @return
     */
    BookDTO getBook(String id);

    /**
     * 更新图书
     *
     * @param book
     */
    void updateBook(BookDTO book);

    /**
     * 批量删除
     *
     * @param bookIds
     */
    void deleteBatch(Integer[] bookIds);

    /**
     * 判断是否有图书
     *
     * @param categoryId
     * @return
     */
    boolean checkByCategory(Integer categoryId);
}
