package appstart.mymodappdemo;

import java.util.ServiceLoader;
import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;
import userfuncs.binaryfuncs.*;

public class MyModAppDemo {
	public static void main(String[] args) {
		if (SupportFuncs.isFactor(2, 10))
			System.out.println("2 - ��������� 10");
		System.out.println("���������� ����� ��������� 35 � 105 - " 
							+ SimpleMathFuncs.lcf(35, 105));
		System.out.println("���������� ����� ��������� 35 � 105 - " 
							+ SimpleMathFuncs.gcf(35, 105));
		
		//������������� �����
		ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);
		BinaryFunc binOp = null;
		for (BinFuncProvider bfp : ldr) {
			if (bfp.get().getName().equals("absPlus")) {
				binOp = bfp.get();
				break;
			}
		}
		if (binOp != null)
			System.out.println("��������� ���������� ������� absPlus(): " + binOp.func(12, -4));
		else
			System.out.println("������� absPlus() �� �������");
		binOp = null;
		
		for (BinFuncProvider bfp : ldr) {
			if (bfp.get().getName().equals("absMinus")) {
				binOp = bfp.get();
				break;
			}
		}
		if (binOp != null)
			System.out.println("��������� ���������� ������� absMinus(): " + binOp.func(12, -4));
		else
			System.out.println("������� absPlus() �� �������");
	}
}