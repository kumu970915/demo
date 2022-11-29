package com.example.demo.base.reference;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * java 引用的认识
 */
public class ReferenceDemoTest {

    static class Parent{
        String name;
        public Parent() {
        }
    }

    static class ChildA extends Parent{
        public ChildA(String name) {
            this.name = name;
        }

    }

    /**
     * 基本类型和引用类型的认识
     */
    @Test
    public void testChangeStringReference(){
        String s1 = "original";
        System.out.println("s1 = " + s1);
        changeStr(s1);
        System.out.println("s1 = " + s1);
    }

    @Test
    public void changeObject(){
        Parent aaa = new ChildA("aaa");
        System.out.println("aaa = " + aaa);
        System.out.println("aaa.hashCode() = " + aaa.hashCode());
        this.changeName(aaa);
        System.out.println("after");
        System.out.println("aaa = " + aaa);
        System.out.println("aaa.hashCode() = " + aaa.hashCode());
    }

    @Test
    public void testFinalObj(){
        ChildA finalA = new ChildA("finalA");
        finalA.name="new value";
        System.out.println("finalA.name = " + finalA.name);
        System.out.println("finalA.hashCode() = " + finalA.hashCode());
        // final 修饰的引用是不能被修改的,比如下面的写法，是会编译异常的
//        finalA = new ChildA("change finalA");
        // 但是我们给它放到方法里面去修改它，那么发现它是可以被修改的，并且在该方法内确实是改成功了
        // 结论： JAVA方法不是引用传递，在里面能修改引用指向的地址 ，那么这个引用就不是原来的引用了，==》 值的引用
        // 值的引用： ==》 传递的是一个指向相同地址的值的引用

        this.changeObj(finalA);

        System.out.println("finalA.name = " + finalA.name);
//        ChildA normalA = new ChildA("normalA");
//        String a = "aaa";//Warning:(66, 20) Variable 'a' initializer '"aaa"' is redundant
//        a = new String("bbb");
//        System.out.println(a);

    }


    @Test
    public void testAAA(){
        int a = 122;
        int a2 = 122;
        System.out.println("Object.class.getClassLoader().hashCode() = " + this.getClass().getClassLoader().hashCode());
        System.out.println(Integer.hashCode(a));
        System.out.println(Integer.hashCode(a2));


        String aa ="aa";
        System.out.println("aa = " + aa.hashCode());

        String aa2 =new String("aa");
        System.out.println("aaa2 = " + aa2.hashCode());

        String aaa1 ="aaa1";
        System.out.println("aaa1 = " + aaa1.hashCode());
        String aaa2 ="aaa2";
        System.out.println("aaa2 = " + aaa2.hashCode());
        // 字符串常量会存放在字符串常量池里面的，所有相同的字符串，都是相同的hashcode【引用、地址】

    }

    @Test
    public void testStringList(){
        ArrayList<String> strings = new ArrayList<>();
        String aaa1 = "aaa1";
        strings.add(aaa1);
        String aaa2 = "aaa2";
        strings.add(aaa2);
        String aaa3 = "aaa3";
        strings.add(aaa3);
        System.out.println(aaa1);
        for (String string : strings) {
            string="bbb1";
            System.out.println(string);
        }
        System.out.println(aaa1);
        System.out.println(strings);
    }




    public void changeName(Parent p){
        p.name = "ParentName";
        p=  new ChildA("p2");
        System.out.println(" p = " + p.hashCode());
    }




    @Deprecated
    public void changeName(ChildA p){
        p.name = "changeName value";
        System.out.println(p.hashCode());
        System.out.println(p.name);
    }
    public void changeObj(ChildA p){
        System.out.println("p.hashCode()1 = " + p.hashCode());
        p = new ChildA("changeObj value");
        System.out.println("p.name = " + p.name);
        System.out.println("p.hashCode()2= " + p.hashCode());
    }

    public void changeStr(String aa){
        aa ="changeStr value";
        System.out.println("changeStr.aa = " + aa);
    }
}
