package kim.turbo.blog.manage.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.book.BookNote;
import kim.turbo.blog.entity.book.dto.BookNoteDTO;

import java.util.Map;

/**
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:08
 */
public interface BookNoteService extends IService<BookNote> {

    /**
     * 分页查询笔记列表
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存笔记笔记
     * @param blogBookNote
     */
    void saveBookNote(BookNoteDTO blogBookNote);

    /**
     * 批量删除
     * @param bookNoteIds
     */
    void deleteBatch(Integer[] bookNoteIds);

    /**
     * 更新笔记
     * @param blogBookNote
     */
    void updateBookNote(BookNoteDTO blogBookNote);

    /**
     * 获取笔记对象
     * @param bookNoteId
     * @return
     */
    BookNoteDTO getBookNote(Integer bookNoteId);

    /**
     * 判断该类别下是否有笔记
     * @param categoryId
     * @return
     */
    boolean checkByCategory(Integer categoryId);
}
