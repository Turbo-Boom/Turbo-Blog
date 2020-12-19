package kim.turbo.blog.manage.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.book.BookSense;

/**
 * 读后感 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:13
 */
public interface BookSenseService extends IService<BookSense> {
    /**
     * 获取读后感
     * @param bookId
     * @return
     */
    BookSense getBookSense(Integer bookId);
}
