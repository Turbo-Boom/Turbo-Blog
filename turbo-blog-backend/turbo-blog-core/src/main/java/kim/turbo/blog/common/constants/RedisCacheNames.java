package kim.turbo.blog.common.constants;

/**
 * RedisCacheNames
 *
 * @author trubo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 00:11
 * description redis 缓存名称
 */
public class RedisCacheNames {

    public final static String PROFIX = "DBBLOG:";

    /**
     * 文章缓存空间名称
     */
    public final static String ARTICLE = PROFIX + "ARTICLE";
    /**
     * 图书缓存空间名称
     */
    public final static String BOOK = PROFIX + "BOOK";

    /**
     * 笔记缓存空间名称
     */
    public final static String BOOKNOTE = PROFIX + "BOOKNOTE";

    /**
     * 友情链接列表
     */
    public final static String LINK = PROFIX + "LINK";

    /**
     * 推荐列表
     */
    public final static String RECOMMEND = PROFIX + "RECOMMEND";

    /**
     * 标签列表
     */
    public final static String TAG = PROFIX + "TAG";

    /**
     * 分类列表
     */
    public final static String CATEGORY = PROFIX +"CATEGORY";

    /**
     * 时光轴
     */
    public static final String TIMELINE =  PROFIX +"TIMELINE";

}
