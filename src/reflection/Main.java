package reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Class<Person> personClass = Person.class;

        fieldExperiments(personClass, person);
        System.out.println("==========");
        constructorExperiments(personClass);
        System.out.println("==========");
        methodExperiments(personClass, person);
        System.out.println("==========");

        try {
            printClass(Class.forName("java.util.LinkedList"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /*List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add(1, "C");

        System.out.println(list.toString());

        if (list.contains("A")) {
            System.out.println("A is in the list");
        }*/


        System.out.println("==========");

        try {
            Class<?> listClass = Class.forName("java.util.LinkedList");
            Constructor<?> constructor = listClass.getConstructor();
            Object list = constructor.newInstance();

            Method addMethod = listClass.getMethod("add", Object.class);
            addMethod.invoke(list, "A");
            addMethod.invoke(list, "B");
            Method addAtIndexMethod = listClass.getMethod("add", int.class, Object.class);
            addAtIndexMethod.invoke(list, 1, "C");

            Method toStringMethod = listClass.getMethod("toString");
            System.out.println(toStringMethod.invoke(list));

            Method containsMethod = listClass.getMethod("contains", Object.class);
            if ((boolean) containsMethod.invoke(list, "A")) {
                System.out.println("A is in the list");
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }


        System.out.println("==========");

        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        int result = Arrays.binarySearch(elements, 42);

        if (result >= 0) System.out.println(elements[result]);

        System.out.println("==========");

        try {
            Method foo = Main.class.getMethod("foo");
            if (foo.isAnnotationPresent(Copyright.class)) {
                Copyright annotation = foo.getAnnotation(Copyright.class);
                System.out.println(annotation.value());
                System.out.println(annotation.owner());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Copyright(value = 13, owner = "me")
    public void foo() {

    }

    static class TraceHandler implements InvocationHandler {

        private final Object target;

        public TraceHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print(target + "." + method.getName() + "(");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    System.out.print(args[i]);
                    if (i < args.length - 1) System.out.print(", ");
                }
            }
            System.out.println(")");

            return method.invoke(target, args);
        }
    }

    public static void printClass(Class<?> clazz) {
        if (clazz.getDeclaringClass() == null) {
            System.out.println("package: " + clazz.getPackage().getName());
            int modifiers = clazz.getModifiers();
            if (!clazz.isInterface()) {
                System.out.print(Modifier.toString(modifiers) + " class " + clazz.getName() +
                        " extends " + clazz.getSuperclass().getName());
            } else {
                System.out.print(Modifier.toString(modifiers) + " interface " + clazz.getName());
            }

            StringBuilder line = new StringBuilder();
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length > 0) {
                if (!clazz.isInterface()) {
                    line.append(" implements ");
                } else {
                    line.append(" extends ");
                }

                for (int i = 0; i < interfaces.length; i++) {
                    line.append(interfaces[i].getName());
                    if (i < interfaces.length - 1) line.append(", ");
                    else line.append(" {");
                }
            }

            System.out.println(line);
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers())) continue;
            System.out.println("\t" + Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + " " + f.getName() + ";");
        }

        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            System.out.println("\t" + Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + " " + f.getName() + ";");
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.print("\t" + Modifier.toString(c.getModifiers()) + " " + c.getName() + "(");
            printParameters(c.getParameterTypes());
            System.out.println(") {}");
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.print("\t" + Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getName() + " " + m.getName() + "(");
            printParameters(m.getParameterTypes());
            System.out.println(") {}");
        }

        Class<?>[] declaredClasses = clazz.getDeclaredClasses();
        for (Class<?> c : declaredClasses) {
            printClass(c);
            System.out.println();
        }

        System.out.println("}");
    }

    private static void printParameters(Class<?>[] parameterTypes) {
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.print(parameterTypes[i].getName() + " arg" + i);
            if (i < parameterTypes.length - 1) System.out.print(", ");
        }
    }

    private static void methodExperiments(Class<Person> personClass, Person person) {
        try {
            Method setName = personClass.getMethod("setName", String.class);
            setName.invoke(person, "Sepp");
            System.out.println(person.getName());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void constructorExperiments(Class<Person> personClass) {
        try {
            Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
            Person hans = constructor.newInstance("Hans", 26);
            System.out.println(hans.getName());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fieldExperiments(Class<Person> personClass, Person person) {
        try {
            Field xField = personClass.getDeclaredField("x");
            xField.setAccessible(true);
            inspectField(xField, person);

            Field[] declaredFields = personClass.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f.getName());
            }
            declaredFields[1].setAccessible(true); // age field
            inspectField(declaredFields[1], person);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void inspectField(Field field, Person person) throws IllegalAccessException {
        System.out.println("==========");
        System.out.println("Name: " + field.getName());
        System.out.println("Type: " + field.getType());
        System.out.println("is Static: " + Modifier.isStatic(field.getModifiers()));
        System.out.println("is Public: " + Modifier.isPublic(field.getModifiers()));
        System.out.println("is Final: " + Modifier.isFinal(field.getModifiers()));
        System.out.println("is Private: " + Modifier.isPrivate(field.getModifiers()));
        System.out.println("is Protected: " + Modifier.isProtected(field.getModifiers()));

        System.out.println("Value: " + field.get(person));
        field.set(person, 1);
        System.out.println("Value: " + field.get(person));

        System.out.println("==========\n");
    }
}
