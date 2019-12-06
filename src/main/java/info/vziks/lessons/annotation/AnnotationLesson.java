package info.vziks.lessons.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@ClassInfo
public class AnnotationLesson {

    String string;

    @ClassInfo
    public AnnotationLesson(
            @ParameterInfo @ParameterInfo2 String string
    ) {
        this.string = string;
    }

    @MethodInfo(author = "Prokhorov Anton", version = 2)
    public void SomeMethod() {

    }

    @Override
    @MethodInfo(author = "Prokhorov Anton")
    public String toString() {
        final StringBuilder sb = new StringBuilder("AnnotationLesson{");
        sb.append("string='").append(string).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {

        AnnotationLesson annotationLesson = new AnnotationLesson("Balllll");


        Method[] methods =  annotationLesson.getClass().getDeclaredMethods();


        for
        (Method method: methods) {
            Annotation[] annotations = method.getAnnotations();
        }


    }
}
