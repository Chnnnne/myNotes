package allkinds;

import java.util.Scanner;
/*
 * 【问题描述】

小明有一些矩形的材料，他要从这些矩形材料中切割出一些正方形。

当他面对一块矩形材料时，他总是从中间切割一刀，切出一块最大的正方形，剩下一块矩形，然后再切割剩下的矩形材料，直到全部切为正方形为止。

例如，对于一块两边分别为5和3的材料（记为5×3），小明会依次切出3×3、2×2、1×1、1×1共4个正方形。

现在小明有一块矩形的材料，两边长分别是2019和324。请问小明最终会切出多少个正方形？

【答案提交】

这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

说明：以上是问题描述的部分，选手做题时可以直接手算答案，即按照题目意思一步一步切割，最后得到切出的矩形个数，手算可能花费一些时间。如果选手在手算时使用除法等方式加快速度，时间可能少一些。如果选手编写程序来计算，可以减少手算中出现的失误。

本题答案为：21
 * 
 * 
 * 
 * 初始：5 3
切割、得到 33、剩余3 2       
切割、得到 22、剩余2 1        
切割、得到 11、剩余1 1
切割、得到 11、剩余0 0  
	51
11、	41
	31
	21
	11
	00
 */
public class demo01_qiege {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int temp=a-b;
		int count=0;
		int swap;
		while(temp!=0) {
			if(a<b) {
				swap=a;
				a=b;
				b=swap;
			}
			temp=a-b;
			a=b;
			b=temp;
			count++;
		}
		System.out.println(count);
	}

}
