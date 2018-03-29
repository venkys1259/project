package com.examples;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Cloneable,Serializable{
    private static Singleton singleton = null;
    private Singleton(){
    }
    public static Singleton getSingleton() {
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("You cant Clone a Singleton");
    }
    public Object readResolve() throws ObjectStreamException{
        return singleton;
    }
    public Object writeResolve() throws ObjectStreamException{
        return singleton;
    }

    public static Class getClass(String className) throws ClassNotFoundException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader == null){
            classLoader = Singleton.class.getClassLoader();
        }
        return classLoader.loadClass(className);
    }

    public static void main(String[] args) throws Exception  {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton2= Singleton.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton2);
       // Singleton singleton2 = (Singleton)  singleton.clone();
      //  System.out.println(singleton2);
    }
}
