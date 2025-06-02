package dev.hater.urlshortener.jobs;

import dev.hater.urlshortener.domain.Url;
import dev.hater.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UrlScheduledJob {

    private final UrlRepository urlRepository;

    @Scheduled(cron = "0 */30 * * * *")
    @Transactional
    public void deleteExpiredUrls() {
        List<Url> urls = urlRepository.findExpiredUrls();
        if (urls.isEmpty()) {
            log.info("Found no url to be deleted");
            return;
        }
        urlRepository.deleteAll(urls);
        log.info("Deleted {} urls", urls.size());
    }

}
