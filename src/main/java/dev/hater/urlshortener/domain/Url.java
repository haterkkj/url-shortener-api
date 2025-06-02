package dev.hater.urlshortener.domain;

import dev.hater.urlshortener.util.generator.CompactBase64Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;

@Entity
@Table(name = "url")
@Data @NoArgsConstructor
public class Url {

    @Id
    @CompactBase64Id
    @Size(min = 6, max = 6)
    @Column(name = "id")
    private String id;

    @Column(name = "url", columnDefinition = "TEXT", nullable = false)
    private String url;

    @Column(name = "use_count", columnDefinition = "INTEGER")
    private Integer useCount;

    @Column(name = "lifetime", columnDefinition = "INTEGER", nullable = false)
    private Integer lifetime;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ", nullable = false)
    private Instant createdAt;

}
