package kim.turbo.blog.portal.operation.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.common.enums.ModuleEnum;
import kim.turbo.blog.entity.article.vo.ArticleVO;
import kim.turbo.blog.entity.book.vo.BookNoteVO;
import kim.turbo.blog.entity.operation.Recommend;
import kim.turbo.blog.entity.operation.vo.RecommendVO;
import kim.turbo.blog.manage.operation.mapper.RecommendMapper;
import kim.turbo.blog.portal.operation.article.service.ArticleService;
import kim.turbo.blog.portal.operation.book.service.BookNoteService;
import kim.turbo.blog.portal.operation.operation.service.RecommendService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:25
 */

@Service("recommendPortalService")
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    @Resource
    private ArticleService articleService;

    @Resource
    private BookNoteService bookNoteService;


    @Override
    public List<RecommendVO> listRecommendVo() {
        List<RecommendVO> recommendList =this.baseMapper.listRecommendVo();
        return genRecommendList(recommendList);
    }

    @Override
    public List<RecommendVO> listHotRead() {
        List<RecommendVO> hotReadList =this.baseMapper.listHotRead();
        genRecommendList(hotReadList);
        hotReadList.get(0).setTop(true);
        return hotReadList;
    }

    private List<RecommendVO> genRecommendList(List<RecommendVO> recommendList) {
        recommendList.forEach(recommendVo -> {
            if(ModuleEnum.ARTICLE.getValue() == recommendVo.getType()){
                ArticleVO simpleArticleVo = articleService.getSimpleArticleVo(recommendVo.getLinkId());
                BeanUtils.copyProperties(simpleArticleVo,recommendVo);
                recommendVo.setUrlType("article");
            }else if(ModuleEnum.BOOK_NOTE.getValue() == recommendVo.getType()) {
                BookNoteVO simpleBookNoteVo = bookNoteService.getSimpleBookNoteVo(recommendVo.getLinkId());
                recommendVo.setUrlType("bookNote");
                BeanUtils.copyProperties(simpleBookNoteVo,recommendVo);
            }
        });
        return recommendList;
    }
}

