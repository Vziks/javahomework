package info.vziks.lessons.annotation.work.two;

import info.vziks.lessons.annotation.work.two.annotation.InitClass;
import info.vziks.lessons.annotation.work.two.annotation.InitProp;
import info.vziks.lessons.annotation.work.two.annotation.RunMethod;

@InitClass
public class Server {
    @InitProp
    private ServerSettings settings;

    public Server(ServerSettings settings) {
        this.settings = settings;
    }

    @RunMethod
    public void start(){
        System.out.println("Server is running on..."
                + settings.getIp() + " " + settings.getPort());
    }
}
