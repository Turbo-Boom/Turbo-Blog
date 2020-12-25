package kim.turbo.blog.entity.book.vo;

import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.book.BookNote;
import kim.turbo.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author turbo
 * @date 2019/01/09 16:51
 * @email 571002217@qq.com
 * @description 文章列表VO
 */
@Data
public class BookNoteVO extends BookNote {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属书本
     */
    private Book book;

}
