package kim.turbo.blog.portal.operation.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogView {

    String type();
}
