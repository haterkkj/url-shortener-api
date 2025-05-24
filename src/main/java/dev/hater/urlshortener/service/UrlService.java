package dev.hater.urlshortener.service;

import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.dto.CreateShortUrlRequest;
import dev.hater.urlshortener.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public Url create(Url url){
        return urlRepository.save(url);
    }

    public Url findById(String id){
        return urlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Url not found"));
    }

    public void deleteById(String id){
        if (!urlRepository.existsById(id)) {
            throw new EntityNotFoundException("Url not found");
        }

        urlRepository.deleteById(id);
    }

}
