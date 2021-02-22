package ru.geekbrains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostResponseNegative extends BaseResponse<PostResponseNegative.GetData>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "error",
            "request",
            "method"
    })

    @Data
    public static class GetData {
        @JsonProperty("error")
        private String error;
        @JsonProperty("request")
        private String request;
        @JsonProperty("method")
        private String method;
    }
}