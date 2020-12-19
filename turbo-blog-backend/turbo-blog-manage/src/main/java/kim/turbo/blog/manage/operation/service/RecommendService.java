package kim.turbo.blog.manage.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.operation.Recommend;
import kim.turbo.blog.entity.operation.vo.RecommendVO;

import java.util.List;
import java.util.Map;

/**
 * 推荐 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 00:53
 */
public interface RecommendService extends IService<Recommend> {

    /**
     * 分页查询
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取推荐列表
     * @return
     */
    List<RecommendVO> listSelect();

    /**
     * 更新置顶状态
     * @param id
     */
    void updateTop(Integer id);

    /**
     * 批量删除
     * @param articleIds
     * @param value
     */
    void deleteBatchByLinkId(Integer[] articleIds, int value);
}
