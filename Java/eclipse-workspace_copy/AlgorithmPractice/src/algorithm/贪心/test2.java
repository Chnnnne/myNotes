package algorithm.贪心;

import java.util.Arrays;
import java.util.List;

public class test2 {
	public static void main(String[] args) {
		Integer [] arr=new Integer[] {1,2,3,4,5};
		System.out.println(Arrays.toString(arr));
		List<Integer> list = Arrays.asList(arr);
		list.add(0, 0);
		Integer [] array = (Integer [])list.toArray();
		System.out.println(Arrays.toString(array));
	}//main
}
