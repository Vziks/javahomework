package info.vziks.exam.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        RefClass refClass = new RefClass();
        RefClass refClass1 = new RefClass();
        Class clss = refClass.getClass();


        System.out.println(refClass.getI());
        refClass.init();
        System.out.println(refClass.getI());
        System.out.println(refClass.getY());

        System.out.println(refClass1.getI());
        System.out.println(refClass1.getY());

        Field[] fields = clss.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAccessible() && "i".equals(field.getName())) {
                field.setAccessible(true);
                field.setInt(refClass, 116);
                field.setInt(refClass1, 116);
                System.out.println(field.getInt(refClass));
            }

//            System.out.println(field.getInt(refClass));

//            System.out.println(field.getInt(refClass));

        }

        System.out.println(refClass.getI());
        System.out.println(refClass.getY());

        System.out.println("1 " + refClass1.getI());
        System.out.println("1 " + refClass1.getY());
    }

}

class RefClass {
    private int i;
    private int y;

    public RefClass() {
    }

    public int getI() {
        return i;
    }

    public int getY() {
        return y;
    }

    public void init() {
        this.i = 5;
        this.y = 15;
    }

}
