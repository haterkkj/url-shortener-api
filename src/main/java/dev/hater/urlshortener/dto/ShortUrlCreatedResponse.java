package dev.hater.urlshortener.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(description = "Response object to correctly created short URL")
public class ShortUrlCreatedResponse {

    @Schema(description = "Short URL", example = "xyz000")
    private String id;
    @Schema(description = "Original URL", example = "https://www.example.com/")
    private String url;

}
