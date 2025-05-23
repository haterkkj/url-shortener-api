package dev.hater.urlshortener.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateShortUrlRequest {

    @NonNull
    private String url;

}
