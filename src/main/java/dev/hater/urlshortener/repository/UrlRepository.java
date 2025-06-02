package dev.hater.urlshortener.repository;

import dev.hater.urlshortener.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {

    @Query(value = """
            SELECT * FROM url
            WHERE created_at + make_interval(hours => lifetime) < now()
            """, nativeQuery = true)
    List<Url> findExpiredUrls();

}
