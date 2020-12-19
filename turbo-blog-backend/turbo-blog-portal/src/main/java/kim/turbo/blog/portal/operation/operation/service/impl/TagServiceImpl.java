package kim.turbo.blog.portal.operation.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.entity.operation.Tag;
import kim.turbo.blog.entity.operation.vo.TagVO;
import kim.turbo.blog.mapper.operation.TagMapper;
import kim.turbo.blog.portal.operation.operation.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:26
 */

@Service("TagPortalService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /**
     * 获取tagVoList
     *
     * @return
     */
    @Override
    public List<TagVO> listTagVo() {
        return baseMapper.listTagVo();
    }
}