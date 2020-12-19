package kim.turbo.blog.manage.oss.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.entity.oss.OssResource;
import kim.turbo.blog.mapper.oss.OssResourceMapper;
import kim.turbo.blog.manage.oss.service.OssResourceService;
import org.springframework.stereotype.Service;

/**
 * 云存储资源表 服务实现类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:32
 */
@Service
public class OssResourceServiceImpl extends ServiceImpl<OssResourceMapper, OssResource> implements OssResourceService {
}
