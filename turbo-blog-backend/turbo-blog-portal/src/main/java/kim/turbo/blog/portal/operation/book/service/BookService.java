package kim.turbo.blog.portal.operation.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.book.vo.BookVO;

import java.util.Map;

/**
 * 图书表 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:06
 */
public interface BookService extends IService<Book> {

    /**
     * 分页分类获取列表
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取Book对象
     * @param id
     * @return
     */
    BookVO getBookVo(Integer id);
}
