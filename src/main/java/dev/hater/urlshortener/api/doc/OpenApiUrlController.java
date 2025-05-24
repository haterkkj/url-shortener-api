package dev.hater.urlshortener.api.doc;

import dev.hater.urlshortener.dto.CreateShortUrlRequest;
import dev.hater.urlshortener.dto.ShortUrlCreatedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Url", description = "Operations related to URL shortening")
public interface OpenApiUrlController {

    @Operation(summary = "Retrieve the original URL by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Redirects to the original URL"),
            @ApiResponse(responseCode = "404", description = "Shortened URL was not found")
    })
    ResponseEntity<Void> findById(@Parameter(description = "ID of the shortened URL") @PathVariable(name = "id") String id);

    @Operation(summary = "Create a new shortened URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Short URL created successfully", content = @Content(
                    schema =  @Schema(implementation = ShortUrlCreatedResponse.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid URL provided"),
            @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    ResponseEntity<ShortUrlCreatedResponse> save(@RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "URL data to be shorten",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CreateShortUrlRequest.class))
            )
            @Valid CreateShortUrlRequest request);

    @Operation(summary = "Delete an shortened URL by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Short URL deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Shortened URL not found"),
            @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    ResponseEntity<Void> delete(@Parameter(description = "ID of the shortened URL") @PathVariable(name = "id") String id);

}
