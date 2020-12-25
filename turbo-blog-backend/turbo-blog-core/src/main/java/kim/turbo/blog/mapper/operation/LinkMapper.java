package kim.turbo.blog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kim.turbo.blog.entity.operation.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 友链 Mapper 接口
 * </p>
 *
 * @author turbo
 * @since 2019-02-14
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}
