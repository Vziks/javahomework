package info.vziks.lessons.annotation.work.two;

import info.vziks.lessons.annotation.work.two.annotation.ConfigClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.Set;

public class Container {
    Set<Class> classes;

    public Container(Set<Class> classes) {
        this.classes = classes;
    }

    public void init() throws IllegalAccessException, InstantiationException, IOException {
        ServerSettings serverSettings;

        for (Class cls :
                this.classes) {

            //@TODO need to finish

            if (cls.isAnnotationPresent(ConfigClass.class)) {

                ConfigClass annotation = (ConfigClass) cls.getAnnotation(ConfigClass.class);
                cls.newInstance();

                InputStream inputStream = Container.class.getClassLoader().getResourceAsStream("config.properties");
                Properties prop = new Properties();

                prop.load(inputStream);

                String ip = prop.getProperty(annotation.prefix() + ".ip");
                int port = Integer.parseInt(prop.getProperty(annotation.prefix() + ".port"));
                serverSettings = (ServerSettings) cls.newInstance();
                serverSettings.setIp(ip);
                serverSettings.setPort(port);

            } else {


            }


        }


    }

}