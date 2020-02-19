package jcontext;


import java.util.*;

public class StatContx {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            A$1 a$1 = new A$1();
            A$2 a$2 = new A$3();
        }


    }


}

class A$1 {

    static HashMap map;

    static {
        Class name = new Object() {
        }.getClass().getEnclosingClass();

        System.out.println("init " + name);

        map = new HashMap();
    }
}


class A$2 {

    static final Map map = initMap();


    private static Map initMap() {
        Class name = new Object() {
        }.getClass().getEnclosingClass();

        System.out.println("init " + name);
        return new HashMap();
    }
}
class A$3 extends A$2 {
    //static HashMap map;

    static {
        Class name = new Object() {
        }.getClass().getEnclosingClass();

        System.out.println("init " + name);
        System.out.println(map.hashCode());
    }
}


