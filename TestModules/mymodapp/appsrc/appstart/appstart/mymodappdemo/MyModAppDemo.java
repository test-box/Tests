package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import static appsupport.supportfuncs.SupportFuncs.*;

public class MyModAppDemo {
	public static void main(String[] args) {
		if (isFactor(2, 10))
			System.out.println("2 - ��������� 10");
		System.out.println("���������� ����� ��������� 35 � 105 - " 
							+ SimpleMathFuncs.lcf(35, 105));
		System.out.println("���������� ����� ��������� 35 � 105 - " 
							+ SimpleMathFuncs.gcf(35, 105));
	}
}