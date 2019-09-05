/**
 * 
 */

/**
 * @作者：王永乐
 * @时间：2019年2月18日
 * 
 */
//使用循环求0-100之间所有整数相加的和。
//需求分解：
//（1）定义一个测试类Test.java。（10分）
//（2）在Test类中正确定义main方法。（10分）
//（3）在main方法中，使用for循环求0-100所有整数相加的和。（20）
//（4）正确输出结果。（10分）
public class Test2 {
//（1）定义一个测试类Test.java。
	public static void main(String[] args) {
//（2）在Test类中正确定义main方法
	int num = 0;
	for (int i = 0; i <= 100; i++) {
		num = num + i;
	}
//	使用for循环求0-100所有整数相加的和
	System.out.println(num);
//	正确输出结果
	}
}
