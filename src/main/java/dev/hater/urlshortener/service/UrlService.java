package dev.hater.urlshortener.service;

import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    @Transactional
    public Url create(Url url){
        url.setCreatedAt(Instant.now());
        url.setUseCount(0);
        return urlRepository.save(url);
    }

    @Transactional
    public Url findById(String id){
        Url url = urlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Url not found"));
        url.setUseCount(url.getUseCount() + 1);
        urlRepository.save(url);
        return url;
    }

    @Transactional
    public void deleteById(String id){
        if (!urlRepository.existsById(id)) {
            throw new EntityNotFoundException("Url not found");
        }

        urlRepository.deleteById(id);
    }

}
