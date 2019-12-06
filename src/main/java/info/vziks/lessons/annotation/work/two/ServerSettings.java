package info.vziks.lessons.annotation.work.two;

import info.vziks.lessons.annotation.work.two.annotation.ConfigClass;

@ConfigClass(prefix = "server")
public class ServerSettings {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}