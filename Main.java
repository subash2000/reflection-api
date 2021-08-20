import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
class Main
{
    Class<?> classObj;

    Main(String className)
    {
        try
        {
            classObj = Class.forName(className);

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class not found");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    void printInterfaces(Class<?>[] interfaces)
    {
        System.out.print("Interfaces : ");
        for(Class<?> cls: interfaces)
        {
            System.out.print(cls.getName()+" ");
        }
        System.out.println();

    }

    void printFields(Field[] flds)
    {
        System.out.println("Fields : ");
        for(Field f:flds)
        {
            System.out.println("\n\tField Name : "+f.getName());
            System.out.println("\tData type : "+f.getType().getName());
            int mod = f.getModifiers();
            System.out.println("\tAccess Modifiers : "+Modifier.toString(mod));

        }
        System.out.println();

    }

    void printMethods(Method[] mthd)
    {
        System.out.println("Methods : ");
        for(Method m : mthd)
        {
            System.out.println("\n\tMethod Name : "+m.getName());
            System.out.println("\tMethod Return type : "+m.getReturnType().getName());
            int mod = m.getModifiers();
            System.out.println("\tMethod Access Modifiers : "+Modifier.toString(mod));
            Class<?>[] paramTypes = m.getParameterTypes();
            System.out.print("\tParameter Types : ");
            for(Class<?> c : paramTypes)
            {
               System.out.print(c.getName()+" ");       
            }
            System.out.println();
            Class<?>[] exceptions = m.getExceptionTypes();
            System.out.print("\tException Types : ");
            for(Class<?> c : exceptions)
            {
                System.out.print(c.getName()+" ");  

            }
            System.out.println();

        }

    }

    void printConstructors(Constructor<?>[] cons)
    {
        System.out.println("\nConstructors : ");
        for(Constructor<?> c:cons)
        {
            System.out.println("\n\tConstructor Name : "+c.getName());
            int i = c.getModifiers();
            System.out.println("\tAccess Modifiers : "+ Modifier.toString(i));
            Class<?>[] paramTypes = c.getParameterTypes();
            System.out.print("\tParameter Types : ");
            for(Class<?> cls : paramTypes)
            {
               System.out.print(cls.getName()+" ");       
            }
            System.out.println();
            Class<?>[] exceptions = c.getExceptionTypes();
            System.out.print("\tException Types :");
            for(Class<?> cls : exceptions)
            {
                System.out.print(cls.getName()+" ");  

            }
            System.out.println();

        }

    }

    void showDetails()
    {
        System.out.println("Name of the class : "+classObj.getName());
        System.out.println("Super class : "+classObj.getSuperclass().getName());
        Class<?>[] interfaces = classObj.getInterfaces();
        printInterfaces(interfaces);
        int i = classObj.getModifiers();
        System.out.println("Access Modifiers : "+Modifier.toString(i));
        Field[] flds = classObj.getDeclaredFields();
        printFields(flds);
        Method[] mthd = classObj.getDeclaredMethods();
        printMethods(mthd);
        Constructor<?>[] cons = classObj.getDeclaredConstructors();
        printConstructors(cons); 

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Class Name (eg : java.util.ArrayList): \t");
        String className =sc.next();// eg : java.util.ArrayList
        new Main(className).showDetails();
        sc.close();
        
    }
}