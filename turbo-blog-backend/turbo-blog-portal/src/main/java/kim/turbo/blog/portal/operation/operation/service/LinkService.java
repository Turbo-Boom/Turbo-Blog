package kim.turbo.blog.portal.operation.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.operation.Link;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:23
 */
public interface LinkService extends IService<Link> {

    /**
     * 获取link列表
     * @return
     */
    List<Link> listLink();
}