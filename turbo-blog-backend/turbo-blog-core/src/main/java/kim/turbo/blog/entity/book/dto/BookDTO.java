package kim.turbo.blog.entity.book.dto;


import kim.turbo.blog.entity.book.Book;
import kim.turbo.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookDto
 *
 * @author turbo
 * @date 2019/01/28 16:44
 * @email 571002217@qq.com
 * @description
 */
@Data
public class BookDTO extends Book {

    List<Tag> tagList;
}
