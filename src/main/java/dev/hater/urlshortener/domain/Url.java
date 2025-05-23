package dev.hater.urlshortener.domain;

import dev.hater.urlshortener.util.generator.CompactBase64Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "url")
@Data @NoArgsConstructor
public class Url {

    @Id
    @CompactBase64Id
    @Size(min = 6, max = 6)
    @Column(name = "id")
    private String id;

    @NonNull
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

}
