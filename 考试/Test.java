import java.util.Scanner;

/**
 * 
 */

/**
 * @作者：王永乐
 * @时间：2019年2月18日
 * 
 */
//    接收用户键盘上输入的整数，判断该整数是否是正数。
//（1）定义一个测试类Test.java。（5分）
//（2）在Test类中正确定义main方法。（5分）
//（3）在main方法中创建Scanner对象，并且实例化该Scanner对象（10分）
//（2）通过Scanner对象的功能方法，获取用户键盘输入的整数，并保存到一个整型变量中。（5分）
//（3）使用条件判断语句，判断该变量的值，如果大于零则控制台输出正数，如果小于零则控制台输出负数，否则控制台输出零。（10分）
public class Test {
//   定义一个测试类Test
	public static void main(String[] args) {
//		在Test类中正确定义main方法
		Scanner sc = new Scanner(System.in);
//	在main方法中创建Scanner对象 并且实例化该Scanner对象
		System.out.println("请输入一个整数");
		int num = sc.nextInt();
//		获取用户键盘输入的整数，并保存到一个整型变量中。
		if(num > 0){
			System.out.println("正数");
		}else if(num < 0){
			System.out.println("负数");
		}else{
			System.out.println("0");
		}
//		使用条件判断语句，判断该变量的值，如果大于零则控制台输出正数，如果小于零则控制台输出负数，否则控制台输出零。
	}
}
