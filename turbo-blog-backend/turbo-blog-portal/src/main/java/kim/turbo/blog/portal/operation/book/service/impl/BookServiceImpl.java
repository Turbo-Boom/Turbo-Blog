package kim.turbo.blog.portal.operation.book.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.util.Query;
import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.book.vo.BookVO;
import kim.turbo.blog.mapper.book.BookMapper;
import kim.turbo.blog.portal.operation.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:09
 */
@Service("bookPortalService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<BookVO> page = new Query<BookVO>(params).getPage();
        List<BookVO> bookList = baseMapper.queryPageCondition(page, params);
        page.setRecords(bookList);
        return new PageUtils(page);
    }

    /**
     * 获取Book对象
     *
     * @param id
     * @return
     */
    @Override
    public BookVO getBookVo(Integer id) {
        return this.baseMapper.selectByIdWithSubList(id);
    }
}