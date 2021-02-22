package ru.geekbrains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class GetResponseImage extends BaseResponse<GetResponseImage.GetData>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "title",
            "description",
            "datetime",
            "type",
            "animated",
            "width",
            "height",
            "size",
            "views",
            "bandwidth",
            "vote",
            "favorite",
            "nsfw",
            "section",
            "account_url",
            "account_id",
            "is_ad",
            "in_most_viral",
            "has_sound",
            "tags",
            "ad_type",
            "ad_url",
            "edited",
            "in_gallery",
            "deletehash",
            "name",
            "link",
            "ad_config"
    })

    @Data
    public static class GetData {
        @JsonProperty("id")
        private String id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("datetime")
        private Integer datetime;
        @JsonProperty("type")
        private String type;
        @JsonProperty("animated")
        private Boolean animated;
        @JsonProperty("width")
        private Integer width;
        @JsonProperty("height")
        private Integer height;
        @JsonProperty("size")
        private Integer size;
        @JsonProperty("views")
        private Integer views;
        @JsonProperty("bandwidth")
        private Integer bandwidth;
        @JsonProperty("vote")
        private String vote;
        @JsonProperty("favorite")
        private Boolean favorite;
        @JsonProperty("nsfw")
        private Boolean nsfw;
        @JsonProperty("section")
        private String section;
        @JsonProperty("account_url")
        private String accountUrl;
        @JsonProperty("account_id")
        private Integer accountId;
        @JsonProperty("is_ad")
        private Boolean isAd;
        @JsonProperty("in_most_viral")
        private Boolean inMostViral;
        @JsonProperty("has_sound")
        private Boolean hasSound;
        @JsonProperty("tags")
        private List<Object> tags = new ArrayList<>();
        @JsonProperty("ad_type")
        private Integer adType;
        @JsonProperty("ad_url")
        private String adUrl;
        @JsonProperty("edited")
        private String edited;
        @JsonProperty("in_gallery")
        private Boolean inGallery;
        @JsonProperty("deletehash")
        private String deletehash;
        @JsonProperty("name")
        private String name;
        @JsonProperty("link")
        private String link;
        @JsonProperty("ad_config")
        private AdConfig adConfig;
    }

    @Data
    public static class AdConfig {
        @JsonProperty("safeFlags")
        private List<String> safeFlags = new ArrayList<>();
        @JsonProperty("highRiskFlags")
        private List<Object> highRiskFlags = new ArrayList<>();
        @JsonProperty("unsafeFlags")
        private List<String> unsafeFlags = new ArrayList<>();
        @JsonProperty("wallUnsafeFlags")
        private List<Object> wallUnsafeFlags = new ArrayList<>();
        @JsonProperty("showsAds")
        private Boolean showsAds;
    }
}