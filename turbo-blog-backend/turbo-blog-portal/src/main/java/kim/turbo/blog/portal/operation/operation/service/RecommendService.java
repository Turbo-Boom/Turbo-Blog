package kim.turbo.blog.portal.operation.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.operation.Recommend;
import kim.turbo.blog.entity.operation.vo.RecommendVO;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:23
 */
public interface RecommendService extends IService<Recommend> {

    List<RecommendVO> listRecommendVo();

    List<RecommendVO> listHotRead();
}