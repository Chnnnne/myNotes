/**
����ѡ��    O(n)     �����ҳ����������� ��k���Ԫ��
����ѡ�������˼·���������һ�£�ѡ��һ��Ԫ����Ϊ��׼����Ԫ�ؽ��з�����
��С�ںʹ��ڻ�׼��Ԫ�ط��ڻ�׼��ߺ��ұߵ���������
��ͬ���ǣ�����ѡ�񲢲��ݹ����˫�ߣ�����ֻ�ݹ����һ�ߵ�Ԫ���м���Ѱ�ҡ�
�⽵����ƽ��ʱ�临�Ӷȣ���O(n log n)��O(n)������������Ȼ��O(n2)��
*/ 
#include<stdio.h>

void Swap(int &a,int &b)
{
	int temp;
	temp=a;
	a=b;
	b=temp;
}


int Partition(int *a,int low,int high) 
{
	int pivotkey=a[low];  //pivotkey�������ֵ���������������ֵ    ע��ֻ������д��������ѡ���� 
	
//	int pivotkey=a[high];
//	Swap(a[high],a[low]);//			����������������ѭ��������ʣ�������1��2 ѡ����Ϊ��Ŧ��
// 2,1�������ŵĻ�����1,2��num=2��������ѭ�� 
	
	while(low<high)
	{
		while(low<high&&a[high]>=pivotkey) --high;
		a[low]=a[high];
		
		while(low<high&&a[low]<=pivotkey) ++low;
		a[high]=a[low];
	}

	a[low]=pivotkey;
	return low; ;  //��ʱ�������������ֵ 
}
 


//����a�����ϵ�kС���� 
int Select(int *a,int p,int r,int k)
{  		  
	if(p==r) 
	return a[p];	
	
  	int pivotkeyIndex=Partition(a,p,r);  
  	int num=pivotkeyIndex-p+1;       //ͳ��ǰ��Ԫ�صĸ������������ᣩ 
  	
  	if(num==k)
  	return a[p+num-1];
  	
    if (k<=num)          
	return  Select(a,p,pivotkeyIndex,k);
	
    else                  
	return  Select(a,pivotkeyIndex+1,r,k-num); 
}



int main()
{
	int a[]={9,8,7,6,5,4,3,2,1};
	printf("%d",Select(a,0,8,5));
	return 0;
}
