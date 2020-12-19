package kim.turbo.blog.entity.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kim.turbo.blog.common.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 读后感
 * </p>
 *
 * @author bobbi
 * @since 2019-02-13
 */
@Data
@ApiModel(value="ReadBookSense对象", description="读后感")
public class BookSense extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "关联图书Id")
    private Integer bookId;



}
