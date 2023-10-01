package by.home.reflection;

import by.home.reflection.model.Rabbit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
    public static void main(String[] args) {
        Rabbit rabbit1 = new Rabbit();
        Rabbit rabbit2 = new Rabbit();

        Class cls = rabbit1.getClass();

        System.out.println(cls.getName());
        System.out.println("-------------------------");

        Field[] fields = cls.getFields();//получим только публичные поля
        for (Field f: fields) {
            System.out.println(f);
        }
        System.out.println("-------------------------");

        Field[] declaredFields = cls.getDeclaredFields();//получим все поля
        for (Field f: declaredFields) {
            System.out.println(f);
        }

        System.out.println("-------------------------");

        Method[] methods = cls.getMethods();//получим публичные методы
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("-------------------------");

        Method[] declaredMethods = cls.getDeclaredMethods();//получим все методы
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

        System.out.println("--------------------------");
        try {
            Field field = cls.getDeclaredField("lastName");//получили название приватного поля
            field.setAccessible(true);//говорим что хотим изменять значение
            System.out.println(field.get(rabbit1));//распечатаем значение приватного поля объекта rabbit1
            System.out.println(field.get(rabbit2));//распечатаем значение приватного поля объекта rabbit2
            field.set(rabbit1, "Lapka");//изменяем занчение приватного поля у объекта rabbit1
            System.out.println(field.get(rabbit1));//распечатаем значение приватного поля объекта rabbit1
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
