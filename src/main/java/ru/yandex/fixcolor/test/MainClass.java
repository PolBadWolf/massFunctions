package ru.yandex.fixcolor.test;
import ru.yandex.fixcolor.test.interfaces.InterFunc1;
public class MainClass {
    public static void main(String[] args) {
        new MainClass().go(args);
    }
    static String changeStr(InterFunc1 intFn, String str) {
        return intFn.fn(str);
    }

    private static String funcRevers(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) res += str.charAt(i);
        return res;
    }
    private static String funcPryam(String str) {
        return str;
    }
    InterFunc1 revers = MainClass::funcRevers;
    InterFunc1 pryam = MainClass::funcPryam;

    static InterFunc1[] massInt = {
            MainClass::funcRevers,
            MainClass::funcPryam
    };

    protected void go(String[] args) {
        System.out.println(revers);
        excuteFunc(massInt[0], "12345");
        System.out.println(massInt[1]);
        excuteFunc(pryam, "12345");
    }

    protected void excuteFunc(InterFunc1 interFunc, String str) {
        System.out.println("source string: " + str);
        String tar = interFunc.fn(str);
        System.out.println("target string: " + tar);
    }
}
