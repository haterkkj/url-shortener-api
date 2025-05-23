package dev.hater.urlshortener.controller;

import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.dto.CreateShortUrlRequest;
import dev.hater.urlshortener.dto.ShortUrlCreatedResponse;
import dev.hater.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{id}")
    public ResponseEntity<Void> findById(@PathVariable String id) {
        String originalUrl = urlService.findById(id).getUrl();
        System.out.println(originalUrl);
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", originalUrl).build();
    }

    @PostMapping
    public ResponseEntity<ShortUrlCreatedResponse> save(@RequestBody CreateShortUrlRequest request) {
        Url url = urlService.create(request);
        ShortUrlCreatedResponse response = new ShortUrlCreatedResponse(url.getId(), url.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        urlService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
