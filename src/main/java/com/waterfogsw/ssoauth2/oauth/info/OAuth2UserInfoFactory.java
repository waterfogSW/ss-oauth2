package com.waterfogsw.ssoauth2.oauth.info;


import com.waterfogsw.ssoauth2.oauth.entity.ProviderType;
import com.waterfogsw.ssoauth2.oauth.info.impl.GoogleOAuth2UserInfo;
import com.waterfogsw.ssoauth2.oauth.info.impl.KakaoOAuth2UserInfo;
import com.waterfogsw.ssoauth2.oauth.info.impl.NaverOAuth2UserInfo;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(ProviderType providerType, Map<String, Object> attributes) {
        return switch (providerType) {
            case GOOGLE -> new GoogleOAuth2UserInfo(attributes);
            case NAVER -> new NaverOAuth2UserInfo(attributes);
            case KAKAO -> new KakaoOAuth2UserInfo(attributes);
        };
    }
}
