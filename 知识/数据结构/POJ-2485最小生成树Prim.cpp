#include<stdio.h>

#define MAX 504
#define MAXCOST 999999


int Graph[MAX][MAX];//ע��Ǳ��1��ʼ 

int prim(int n)
{
	int lowcost[MAX];			//	lowcost[i]�ĺ����� 		��iΪ�յ�ıߵ���СȨֵ   ����������Ŀǰ������i�㣬0����i������ӽ��Ѽ���㣩 
	int mst[MAX];				//	mst[i]�ĺ����� 			lowcost[i]��Ӧ�ߵ���� 
	int i,j,min,minIndex,LongRoad=0; 
	for(i=2;i<=n;i++)
	{
		lowcost[i]=Graph[1][i];
		mst[i]=1;
	}
	mst[1]=0;
	lowcost[1]=0;
	
	for(i=2;i<=n;i++)
	{
		min=MAXCOST;
		minIndex=0;
 
		for(j=2;j<=n;j++)
		{
			if(lowcost[j]<min&&lowcost[j]!=0)
			{
				min=lowcost[j];
				minIndex=j;
			}
		}
		if(min>LongRoad)
		LongRoad=min;

		lowcost[minIndex]=0;
		
 
		for(j=2;j<=n;j++)
		{
			if(Graph[minIndex][j]<lowcost[j]&&lowcost[j]!=0)
			{
				lowcost[j]=Graph[minIndex][j];
				mst[j]=minIndex; 			 
			} 
		}	
		
	}
	
	
	
	
	
	
	return LongRoad;	
}


int main()
{
	int i,j,k,m,n;
	int x,y,LongRoad;
	
	
	
	int T;
	scanf("%d",&T);
	while(T--)
	{
		int N;
		scanf("%d",&N);
		
		for(k=1;k<=N;k++)
			for(i=1;i<=N;i++) 
			scanf("%d",&Graph[k][i]);	
		
				
	LongRoad=prim(N);
	printf("%d\n",LongRoad); 
	
	
	}

	return 0;
 } 
 
 

