package info.vziks.lessons.annotation.work.two;


import info.vziks.lessons.annotation.work.two.annotation.InitClass;
import info.vziks.lessons.annotation.work.two.annotation.InitProp;
import info.vziks.lessons.annotation.work.two.annotation.RunMethod;

@InitClass
public class Server {
    @InitProp
    private ServerSettings settings;


    @RunMethod
    public void start(){
        System.out.println("Server is running on..."
                + settings.getIp() + " " + settings.getPort());
    }

    @Override
    public String toString() {
        return "Server{" +
                "settings=" + settings +
                '}';
    }
}
