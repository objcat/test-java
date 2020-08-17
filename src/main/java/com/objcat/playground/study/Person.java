package com.objcat.playground.study;

public class Person {

    /**
     * 经调查发现 java中static变量 也就是类变量是可以在全局中存储值的
     * 这一点在OC中并不能实现 只能使用一个单例的成员变量来变相的存储staitc变量
     */

    static int a = 1;

    public static void main(String[] args) {
        System.out.println(Person.a);
        Person.a = 2;
        System.out.println(Person.a);
        Student.say();
        System.out.println(Person.a);
    }

    static class Student {
        static void say() {
            System.out.println(Person.a);
            Person.a = 3;
        }
    }
}
