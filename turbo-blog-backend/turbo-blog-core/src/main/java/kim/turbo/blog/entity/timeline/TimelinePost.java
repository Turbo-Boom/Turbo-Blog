package kim.turbo.blog.entity.timeline;

import lombok.Data;

import java.util.Date;

/**
 * TimeLineData
 *
 * @author turbo
 * @date 2019/02/24 20:39
 * @email 571002217@qq.com
 * @description
 */
@Data
public class TimelinePost {

    private Integer id;

    private String title;

    private String description;

    private String postType;

    private Date createTime;

}
