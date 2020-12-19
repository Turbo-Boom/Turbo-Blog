package kim.turbo.blog.portal.operation.timeline.service;

import kim.turbo.blog.entity.timeline.Timeline;

import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:20
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     * @return
     */
    List<Timeline> listTimeLine();
}
