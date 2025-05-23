package dev.hater.urlshortener.util.generator;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@IdGeneratorType(UrlIdGenerator.class)
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompactBase64Id {
}
