package ru.geekbrains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetResponseCredit extends BaseResponse<GetResponseCredit.GetData>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "UserLimit",
            "UserRemaining",
            "UserReset",
            "ClientLimit",
            "ClientRemaining"
    })

    @Data
    public static class GetData {
        @JsonProperty("UserLimit")
        private Integer userLimit;
        @JsonProperty("UserRemaining")
        private Integer userRemaining;
        @JsonProperty("UserReset")
        private Integer userReset;
        @JsonProperty("ClientLimit")
        private Integer clientLimit;
        @JsonProperty("ClientRemaining")
        private Integer clientRemaining;
    }
}