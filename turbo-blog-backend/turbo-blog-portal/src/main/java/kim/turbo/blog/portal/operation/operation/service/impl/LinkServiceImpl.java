package kim.turbo.blog.portal.operation.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.entity.operation.Link;
import kim.turbo.blog.mapper.operation.LinkMapper;
import kim.turbo.blog.portal.operation.operation.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:25
 */

@Service("linkPortalService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    /**
     * 获取link列表
     *
     * @return
     */
    @Override
    public List<Link> listLink() {
        return baseMapper.selectList(null);
    }
}