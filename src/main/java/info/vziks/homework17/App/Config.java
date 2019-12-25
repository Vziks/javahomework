package info.vziks.homework17.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

abstract public class Config {
    private Properties properties;
    private int port;
    private String ip;

    public Config() {
        InputStream input = Config.class
                .getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.port = Integer.parseInt(properties.getProperty("server.port"));
        this.ip = properties.getProperty("server.ip");
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }
}
