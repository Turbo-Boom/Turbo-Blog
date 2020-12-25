package kim.turbo.blog.mapper.oss;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kim.turbo.blog.entity.oss.OssResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 云存储资源表 Mapper 接口
 * </p>
 *
 * @author turbo
 * @since 2018-11-30
 */
@Mapper
public interface OssResourceMapper extends BaseMapper<OssResource> {

}
