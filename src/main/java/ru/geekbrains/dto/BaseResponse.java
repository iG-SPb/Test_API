package ru.geekbrains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL) // не включать поля с NULL
@JsonPropertyOrder({  // определяет порядок полей
        "data",
        "success",
        "status"
})

@NoArgsConstructor
@Data
public class BaseResponse<AnyData> {
    @JsonProperty("data")
    private AnyData data;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("status")
    private Integer status;
}
