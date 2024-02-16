package cl.notices.noticesapi.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "notices")
public class Notices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDb;

    private Long id;

    private String title;

    private String url;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("news_site")
    private String newsSite;

    private String summary;

    @Temporal(TemporalType.DATE)
    @JsonProperty("published_at")
    private Date publishedAt;

    @Temporal(TemporalType.DATE)
    @JsonProperty("updated_at")
    private Date updatedAt;

    private Boolean featured;

    @Transient
    private List<Launches> launches;

    @Transient
    private List<Events> events;
}
