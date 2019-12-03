package info.vziks.exam.lesson19;

import info.vziks.exam.lesson19.TextMessage;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    /*static {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    }*/
    public static void main(String[] args) throws
            NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {
//        Reflection API класс Class
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(TextMessage.class);

        TextMessage textMessage =
                new TextMessage("Срочно", "Провести совещание");
        System.out.println(textMessage.getClass());

        Class cls = textMessage.getClass(); // ссылка на класс TextMessage

        System.out.println(cls.getName()); // возвращает имя класса
        // возвращает интрейфейсы, которые имплементирует класс
        System.out.println(Arrays.toString(cls.getInterfaces()));
        // возвращает родительский класс
        System.out.println(cls.getSuperclass());
        System.out.println(cls.getSuperclass().getSuperclass());
        System.out.println(cls.getSuperclass().getSuperclass().getSuperclass());

        // доступ к компонентам класса
        Class<TextMessage> textMessageClass = TextMessage.class;

        // доступ к полям класса
        // возвращает все публичные поля класса (включая родительские)
        Field[] fields = textMessageClass.getFields();
        System.out.println(Arrays.toString(fields));

        // возвращает все поля класса (включая private и protected)
        Field[] declaredFields = textMessageClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        // возвращает все публичные методы класса (включая родительские)
        Method[] methods = textMessageClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // возвращает все методы класса (включая private и protected)
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor[] declaredConstructors =
                textMessageClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // доступ к конкретному полю / методу

        Field field = textMessageClass.getDeclaredField("text");
        System.out.println(field.getType());
        field.setAccessible(true);
        // возвращает значение поля для конкретного объекта,
        // если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        System.out.println(field.get(textMessage));
        // устанавливает значение поля для конкретного объекта,
        // если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        field.set(textMessage, "Новое Сообщение");
        System.out.println(field.get(textMessage));

        Method method = textMessageClass.getDeclaredMethod("getMessageInfo");

        method.setAccessible(true);
        String messageResult = (String) method.invoke(textMessage);
        System.out.println("getMessageInfo " + messageResult);


        Method method1 = cls.getMethod("printTitle", String.class);
        Method method2 = textMessageClass.getMethod("printTitle", String.class);

        method1.invoke(textMessage, "Hi1");
        method2.invoke(textMessage, "Hi2");


        Constructor textMessageConstructor = textMessageClass.getConstructor();

        TextMessage eee = (TextMessage) textMessageConstructor.newInstance();

//        boolean isPrivate = textMessageClass.getDeclaredMethod("getMessageInfo").isAccessible();

//        public void printTitle(String data){
//            System.out.println("Тема сообщения: " + data);
//        }

    }
}
