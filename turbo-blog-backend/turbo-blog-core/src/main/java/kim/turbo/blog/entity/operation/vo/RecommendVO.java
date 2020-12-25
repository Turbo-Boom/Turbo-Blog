package kim.turbo.blog.entity.operation.vo;


import kim.turbo.blog.entity.operation.Recommend;
import kim.turbo.blog.entity.operation.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * RecommendVo
 *
 * @author turbo
 * @date 2019/02/22 10:49
 * @email 571002217@qq.com
 * @description
 */
@Data
public class RecommendVO extends Recommend {

    private String description;

    private Long readNum;

    private Long commentNum;

    private Long likeNum;

    private String urlType;

    private String cover;

    private Date createTime;

    private List<Tag> tagList;

}
