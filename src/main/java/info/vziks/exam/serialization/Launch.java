package info.vziks.exam.serialization;

import java.io.Externalizable;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Launch implements Serializable{
    private int count;
    private LocalDateTime lastLaunch;
    transient private String name = "Launch";
    static private String stat = "stat";
    private String user;
    private static final long serialVersionUID = 1L;


    public boolean isLastLaunch() {
        return count == 0 && lastLaunch == null;
    }

    public void update() {
        setCount(++count);
        setLastLaunch(LocalDateTime.now());
        setUser(System.getProperty("user.name"));
    }

    public int getCount() {
        return count;
    }

    public Launch setCount(int count) {
        this.count = count;
        return this;
    }

    public LocalDateTime getLastLaunch() {
        return lastLaunch;
    }

    public Launch setLastLaunch(LocalDateTime lastLaunch) {
        this.lastLaunch = lastLaunch;
        return this;
    }

    public String getName() {
        return name;
    }

    public Launch setName(String name) {
        this.name = name;
        return this;
    }

    public static String getStat() {
        return stat;
    }

    public static void setStat(String stat) {
        Launch.stat = stat;
    }

    public String getUser() {
        return user;
    }

    public Launch setUser(String user) {
        this.user = user;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Launch{");
        sb.append("count=").append(count);
        sb.append(", lastLaunch=").append(lastLaunch);
        sb.append(", name='").append(name).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

