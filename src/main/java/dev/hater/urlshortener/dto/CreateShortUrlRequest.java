package dev.hater.urlshortener.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "Request object to create a new shortened URL")
public class CreateShortUrlRequest {

    @NotNull(message = "Url cannot be null")
    @NotBlank(message = "Url cannot be blank")
    @Pattern(
            regexp = "^(https?://)(www\\.)?([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:[0-9]{1,5})?" +
                    "(/[a-zA-Z0-9\\-._~:/?#@!$&'()*+,;=%]*)?$",
            message = "Url is not valid"
    )
    @Schema(description = "Original URL", example = "https://www.example.com/")
    private String url;

    @NotNull(message = "Lifetime cannot be null")
    @Min(value = 1, message = "Lifetime must be at least one hour")
    @Schema(description = "Quantity of hours that the link will be valid", example = "2", minimum = "1")
    private Integer lifetime;

}

