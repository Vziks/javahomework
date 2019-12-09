package info.vziks.lessons.annotation.work.two;


import info.vziks.lessons.annotation.work.two.annotation.ConfigClass;

@ConfigClass(prefix="server")
public class ServerSettings {
    private String ip;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "ServerSettings{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
