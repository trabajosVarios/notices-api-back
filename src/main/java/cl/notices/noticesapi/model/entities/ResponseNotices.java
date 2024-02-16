package cl.notices.noticesapi.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseNotices {

    public String count;
    public String next;
    public String previous;

    @JsonProperty("results")
    public List<Notices> notices;
}
