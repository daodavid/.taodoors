package test.threads;

public class TestSpace {


    public static void main(String[] args) {
        String a = "dav\n  wwo";
        System.out.println(a.replace("dav\n","kav"));
        System.out.println(a.replace("dav\n ","kav "));
        System.out.println(a.replace("dav\n ","kav"));
        System.out.println(a.replace("dav\n","kav   "));
    }
}
