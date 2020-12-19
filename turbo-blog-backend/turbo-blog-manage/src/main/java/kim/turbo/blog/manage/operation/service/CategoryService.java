package kim.turbo.blog.manage.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.operation.Category;

import java.util.List;
import java.util.Map;

/**
 * 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 00:47
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询所有菜单
     * @param params
     * @return
     */
    List<Category> queryWithParentName(Map<String, Object> params);

    /**
     * 根据父级别查询子级别
     * @param id
     * @return
     */
    List<Category> queryListParentId(Integer id);

    /**
     * 根据类别Id数组查询类别数组
     * @param categoryIds
     * @param categoryList
     * @return
     */
    String renderCategoryArr(String categoryIds, List<Category> categoryList);
}
