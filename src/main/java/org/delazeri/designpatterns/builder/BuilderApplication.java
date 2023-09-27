package org.delazeri.designpatterns.builder;

import org.delazeri.designpatterns.builder.src.EmailClientConfig;

public class BuilderApplication {
    public static void main(String[] args) {
        EmailClientConfig emailClientConfigRaw = new EmailClientConfig.EmailClientConfigBuilder(
                "https://server-url.com",
                8080)
                .build();

        EmailClientConfig emailClientConfigWithUsername = new EmailClientConfig.EmailClientConfigBuilder(
                "https://server-url.com",
                8080)
                .setUsername("username")
                .build();
    }
}
