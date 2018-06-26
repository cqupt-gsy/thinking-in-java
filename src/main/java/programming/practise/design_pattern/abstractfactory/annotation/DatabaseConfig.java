package programming.practise.design_pattern.abstractfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseConfig {
    String databaseType();

    String basePackage() default "programming.practise.design_pattern.abstractfactory.factory";
}
