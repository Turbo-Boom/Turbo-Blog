package kim.turbo.blog.mapper.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kim.turbo.blog.entity.book.BookSense;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 读后感 Mapper 接口
 * </p>
 *
 * @author turbo
 * @since 2019-02-13
 */
@Mapper
public interface BookSenseMapper extends BaseMapper<BookSense> {

}
