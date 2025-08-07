package concurrent.part01;

/**
 * @author wangchen
 * @version 1.0
 */
public class FinalTestParent {

    public final void test() {
        System.out.println("测试 final 方法");
    }

    // 可以进行重载操作
    public final void test(int a) {
        System.out.println("测试 final 方法，参数为：" + a);
    }

    public static void main(String[] args) {
        FinalTestParent parent = new FinalTestParent();
        parent.test(); // 调用无参方法
        parent.test(10); // 调用有参方法

        // 注意：不能重写 final 方法
        // FinalTestChild child = new FinalTestChild();
        // child.test(); // 编译错误，无法重写 final 方法
    }
}
