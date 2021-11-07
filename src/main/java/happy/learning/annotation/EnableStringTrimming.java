package happy.learning.annotation;

import happy.outer.StringTrimmingConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Import(StringTrimmingConfiguration.class)
public @interface EnableStringTrimming {
}
