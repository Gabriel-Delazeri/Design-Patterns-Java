package org.delazeri.designpatterns.builder.src;

public class EmailClientConfig {
    private final String server;
    private final int port;
    private final String username;
    private final String password;
    private final boolean useSSL;

    private EmailClientConfig(EmailClientConfigBuilder builder){
        this.server = builder.server;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.useSSL = builder.useSSL;
    }

    public String getServer() {
        return server;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public static class EmailClientConfigBuilder {
        private final String server;
        private final int port;
        private String username = "";
        private String password = "";
        private boolean useSSL = false;

        public EmailClientConfigBuilder(String server, int port) {
            this.server = server;
            this.port = port;
        }

        public EmailClientConfigBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public EmailClientConfigBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public EmailClientConfigBuilder isUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public EmailClientConfig build() {
            return new EmailClientConfig(this);
        }
    }

}
