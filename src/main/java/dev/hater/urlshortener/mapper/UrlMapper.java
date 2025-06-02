package dev.hater.urlshortener.mapper;

import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.dto.CreateShortUrlRequest;
import dev.hater.urlshortener.dto.ShortUrlCreatedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UrlMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "useCount", ignore = true)
    Url createShortUrlRequestToUrl(CreateShortUrlRequest createShortUrlRequest);

    ShortUrlCreatedResponse urlToShortUrlCreatedResponse(Url url);

}
