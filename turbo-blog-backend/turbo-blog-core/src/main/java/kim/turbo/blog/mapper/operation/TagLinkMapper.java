package kim.turbo.blog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kim.turbo.blog.entity.operation.TagLink;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章标签多对多维护表 Mapper 接口
 * </p>
 *
 * @author turbo
 * @since 2019-01-07
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
