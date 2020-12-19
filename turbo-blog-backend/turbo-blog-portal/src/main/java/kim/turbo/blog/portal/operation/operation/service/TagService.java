package kim.turbo.blog.portal.operation.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.operation.Tag;
import kim.turbo.blog.entity.operation.vo.TagVO;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:24
 */
public interface TagService extends IService<Tag> {

    /**
     * 获取tagVoList
     * @return
     */
    List<TagVO> listTagVo();
}