package info.vziks.lessons.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR}) /// Ввиде конструктора
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    // Строки ,примитивы и перечисления

    // это не методы , а переменные
    String author(); // Обязательное

    int version() default 1; // Не обязательное, т.к. имеет default значение

}


@Target(ElementType.PARAMETER)
@interface ParameterInfo {
//все наследуемые классы будут наследовать анотацию
}

@Target(ElementType.PARAMETER)
@interface ParameterInfo2 {
//все наследуемые классы будут наследовать анотацию
}

@Inherited
@interface ClassInfo {
//все наследуемые классы будут наследовать анотацию
}

@ClassInfo
class Parent {

    public void SomeMethod(@ParameterInfo String str){
        System.out.println("!");
    }
}

class Child extends Parent {

}