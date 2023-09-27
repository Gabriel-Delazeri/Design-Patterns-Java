package org.delazeri.designpatterns.builder.src;

public class EmailClientConfig {
    private final String server;
    private final int port;
    private final String username;
    private final String password;
    private final boolean useSSL;

    private EmailClientConfig(Builder builder){
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

    public static class Builder {
        private final String server;
        private final int port;
        private String username = "";
        private String password = "";
        private boolean useSSL = false;

        public Builder(String server, int port) {
            this.server = server;
            this.port = port;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder isUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public EmailClientConfig build() {
            return new EmailClientConfig(this);
        }
    }

}
