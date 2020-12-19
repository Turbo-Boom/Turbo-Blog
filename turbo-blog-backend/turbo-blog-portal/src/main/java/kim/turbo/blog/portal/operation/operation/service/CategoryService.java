package kim.turbo.blog.portal.operation.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.operation.Category;

import java.util.List;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:22
 */

public interface CategoryService extends IService<Category> {

    /**
     * 获取categoryList
     * @param params
     * @return
     */
    List<Category> listCategory(Map<String, Object> params);
}