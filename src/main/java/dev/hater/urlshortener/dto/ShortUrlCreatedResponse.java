package dev.hater.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ShortUrlCreatedResponse {

    private String id;
    private String url;

}
