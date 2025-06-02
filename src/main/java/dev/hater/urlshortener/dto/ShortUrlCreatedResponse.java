package dev.hater.urlshortener.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data @AllArgsConstructor
@Schema(description = "Response object to correctly created short URL")
public class ShortUrlCreatedResponse {

    @Schema(description = "Short URL", example = "xyz000")
    private String id;
    @Schema(description = "Original URL", example = "https://www.example.com/")
    private String url;
    @Schema(description = "Number of times the short URL was used", example = "100")
    private Integer useCount;
    @Schema(description = "Lifetime of the short URL in hours", example = "2")
    private Integer lifetime;
    @Schema(description = "Timestamp when the short URL was created (UTC, ISO-8601 format)")
    private Instant createdAt;

}