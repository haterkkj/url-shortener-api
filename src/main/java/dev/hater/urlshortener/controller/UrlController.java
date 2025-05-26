package dev.hater.urlshortener.controller;

import dev.hater.urlshortener.api.doc.OpenApiUrlController;
import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.dto.CreateShortUrlRequest;
import dev.hater.urlshortener.dto.ShortUrlCreatedResponse;
import dev.hater.urlshortener.mapper.UrlMapper;
import dev.hater.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequiredArgsConstructor
public class UrlController implements OpenApiUrlController {

    private final UrlService urlService;
    private final UrlMapper urlMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Void> findById(@PathVariable String id) {
        String originalUrl = urlService.findById(id).getUrl();
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(originalUrl)).build();
    }

    @PostMapping
    public ResponseEntity<ShortUrlCreatedResponse> save(@Valid @RequestBody CreateShortUrlRequest request) {
        Url url = urlService.create(urlMapper.createShortUrlRequestToUrl(request));
        ShortUrlCreatedResponse response = urlMapper.urlToShortUrlCreatedResponse(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        urlService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
