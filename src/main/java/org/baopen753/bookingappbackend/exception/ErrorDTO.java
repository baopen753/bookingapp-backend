package org.baopen753.bookingappbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ErrorDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date timeStamp;
    private Integer status;
    private String path;
    public Set<String> error = new HashSet<>();

    public void addError(String error) {
        this.error.add(error);
    }

}
