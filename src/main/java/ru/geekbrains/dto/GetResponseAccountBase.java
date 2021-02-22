package ru.geekbrains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetResponseAccountBase extends BaseResponse<GetResponseAccountBase.GetData>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "url",
            "bio",
            "avatar",
            "avatar_name",
            "cover",
            "cover_name",
            "reputation",
            "reputation_name",
            "created",
            "pro_expiration",
            "user_follow",
            "is_blocked"
    })

    @Data
    public static class GetData {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("url")
        private String url;
        @JsonProperty("bio")
        private String bio;
        @JsonProperty("avatar")
        private String avatar;
        @JsonProperty("avatar_name")
        private String avatarName;
        @JsonProperty("cover")
        private String cover;
        @JsonProperty("cover_name")
        private String coverName;
        @JsonProperty("reputation")
        private Integer reputation;
        @JsonProperty("reputation_name")
        private String reputationName;
        @JsonProperty("created")
        private Integer created;
        @JsonProperty("pro_expiration")
        private Boolean proExpiration;
        @JsonProperty("user_follow")
        private UserFollow userFollow;
        @JsonProperty("is_blocked")
        private Boolean isBlocked;
    }

    @Data
    public static class UserFollow {
        @JsonProperty("status")
        private Boolean status;
    }
}