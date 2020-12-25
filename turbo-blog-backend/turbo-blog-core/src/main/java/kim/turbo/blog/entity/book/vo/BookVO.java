package kim.turbo.blog.entity.book.vo;


import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.book.BookNote;
import kim.turbo.blog.entity.book.BookSense;
import kim.turbo.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookVo
 *
 * @author turbo
 * @date 2019/01/29 14:17
 * @email 571002217@qq.com
 * @description
 */
@Data
public class BookVO extends Book {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属笔记
     */
    private List<BookNote> bookNoteList;

    /**
     * 读后感
     */
    private BookSense bookSense;
}
