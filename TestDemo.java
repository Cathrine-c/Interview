package java_1023.java;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Shape shape = null;
        System.out.println("请问要创建哪种图形,请按提示输入：");
        System.out.println("创建三角形:1");
        System.out.println("创建圆形:2");
        System.out.println("创建矩形:3");
        Scanner scanner = new Scanner(System.in);
        int ret = scanner.nextInt();
        switch (ret) {
            case (1):
                System.out.println("请输入三角形三边长：");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();
                    if (a+b>c&&b+c>a&&a+c>b) {
                        shape = new Triangle(a, b, c);
                        break;
                    }else{
                        System.out.println("输入的三边长不合理");
                        break;
                    }

            case (2):
                System.out.println("请输入圆形半径：");
                double r = scanner.nextDouble();
                    shape = new Circle(r);
                    break;


            case (3):
                System.out.println("请输入矩形宽高：");
                    double h = scanner.nextDouble();
                    double w = scanner.nextDouble();
                    shape = new Rectangle(h, w);
                    break;

            default:
                System.out.println("输入错误，程序结束！");
                break;
        }
        System.out.println("该图形面积为："+shape.area());
        System.out.println("该图形周长为："+shape.perimeter());
    }
}
