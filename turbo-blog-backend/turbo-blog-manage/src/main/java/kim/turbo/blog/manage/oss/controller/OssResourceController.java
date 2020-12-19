package kim.turbo.blog.manage.oss.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.exception.MyException;
import kim.turbo.blog.entity.oss.OssResource;
import kim.turbo.blog.manage.oss.service.CloudStorageService;
import kim.turbo.blog.manage.oss.service.OssResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 云存储资源表 前端控制器
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:28
 */
@RestController
@RequestMapping("/admin/oss/resource")
public class OssResourceController {


    @Autowired
    private OssResourceService ossResourceService;

    @Autowired
    private CloudStorageService cloudStorageService;

    @PostMapping("/upload")
    public Result uploadCover(MultipartFile file) throws Exception{
        if (file!=null && file.isEmpty()) {
            throw new MyException("上传文件不能为空");
        }
        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url =cloudStorageService.uploadSuffix(file.getBytes(), suffix);
        OssResource resource=new OssResource(url,file.getOriginalFilename());
        ossResourceService.save(resource);
        return Result.ok().put("resource", resource);
    }
}
