#include<stdio.h>

#define MAX 504
#define MAXCOST 999999


int Graph[MAX][MAX];//注意角标从1开始 

int prim(int n)
{
	int lowcost[MAX];			//	lowcost[i]的含义是 		以i为终点的边的最小权值   （无穷大代表目前到不了i点，0代表i点已添加进已加入点） 
	int mst[MAX];				//	mst[i]的含义是 			lowcost[i]对应边的起点 
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
 
 

