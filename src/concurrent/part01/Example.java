package concurrent.part01;

import java.util.Random;

/**
 * @author wangchen
 * @version 1.0
 */
public class Example {
    // 编译时常量
    final int a = 1;
    final static int b = 1;
    final int[] c = {1, 2, 3, 4};
    // 非编译时常量
    Random d = new Random();
    final int e = d.nextInt();

    public static void main(String[] args) {

    }
}
