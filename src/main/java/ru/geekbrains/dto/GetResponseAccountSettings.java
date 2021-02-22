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
public class GetResponseAccountSettings extends BaseResponse<GetResponseAccountSettings.GetData>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "account_url",
            "email",
            "avatar",
            "cover",
            "public_images",
            "album_privacy",
            "pro_expiration",
            "accepted_gallery_terms",
            "active_emails",
            "messaging_enabled",
            "comment_replies",
            "blocked_users",
            "show_mature",
            "newsletter_subscribed",
            "first_party"
    })

    @Data
    public static class GetData {
        @JsonProperty("account_url")
        private String accountUrl;
        @JsonProperty("email")
        private String email;
        @JsonProperty("avatar")
        private String avatar;
        @JsonProperty("cover")
        private String cover;
        @JsonProperty("public_images")
        private Boolean publicImages;
        @JsonProperty("album_privacy")
        private String albumPrivacy;
        @JsonProperty("pro_expiration")
        private Boolean proExpiration;
        @JsonProperty("accepted_gallery_terms")
        private Boolean acceptedGalleryTerms;
        @JsonProperty("active_emails")
        private List<Object> activeEmails = new ArrayList<>();
        @JsonProperty("messaging_enabled")
        private Boolean messagingEnabled;
        @JsonProperty("comment_replies")
        private Boolean commentReplies;
        @JsonProperty("blocked_users")
        private List<Object> blockedUsers = new ArrayList<>();
        @JsonProperty("show_mature")
        private Boolean showMature;
        @JsonProperty("newsletter_subscribed")
        private Boolean newsletterSubscribed;
        @JsonProperty("first_party")
        private Boolean firstParty;
    }
}