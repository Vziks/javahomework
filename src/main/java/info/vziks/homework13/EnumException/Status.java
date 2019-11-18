package info.vziks.homework13.EnumException;



import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public enum Status {
    FILE_NOT_FOUND(()->{
        throw new FileNotFoundException();
    }),
    ACCESS_DENIED(()->{
        throw new AccessDeniedException("");
    }),
    JAR_ERROR(()->{
        throw new JarException();
    });


    private CheckInterface checkInterface;

    Status(CheckInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    public CheckInterface getCheckInterface() {
        return checkInterface;
    }
}
