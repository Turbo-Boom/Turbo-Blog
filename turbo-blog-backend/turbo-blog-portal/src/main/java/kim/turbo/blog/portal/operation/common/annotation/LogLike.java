package kim.turbo.blog.portal.operation.common.annotation;

import java.lang.annotation.*;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLike {

    String type();
}