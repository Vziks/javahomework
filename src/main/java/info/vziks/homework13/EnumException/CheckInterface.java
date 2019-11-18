package info.vziks.homework13.EnumException;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public interface CheckInterface {
    // Для удобства не много реорганизовать метод, у каждого  enum теперь свой throwException без аргументов
    void throwException() throws FileNotFoundException, AccessDeniedException, JarException;
}
