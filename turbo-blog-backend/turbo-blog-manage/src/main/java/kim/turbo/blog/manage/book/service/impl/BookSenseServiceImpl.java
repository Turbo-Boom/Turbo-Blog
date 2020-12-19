package kim.turbo.blog.manage.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.entity.book.BookSense;
import kim.turbo.blog.mapper.book.BookSenseMapper;
import kim.turbo.blog.manage.book.service.BookSenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 读后感 服务实现类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:13
 */
@Service
@Slf4j
public class BookSenseServiceImpl extends ServiceImpl<BookSenseMapper, BookSense> implements BookSenseService {

    /**
     * 获取读后感
     *
     * @param bookId
     * @return
     */
    @Override
    public BookSense getBookSense(Integer bookId) {
        BookSense readSense = this.baseMapper.selectOne(new QueryWrapper<BookSense>().lambda()
                .eq(bookId!=null, BookSense::getBookId,bookId));
        return Optional.ofNullable(readSense)
                .orElse(null);
    }
}
