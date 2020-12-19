package kim.turbo.blog.manage.operation.controller;

import kim.turbo.blog.common.base.AbstractController;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:18
 */
@RestController
@RequestMapping("/admin/operation/redis")
public class RedisCacheController extends AbstractController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
}
