//typedef用法：  如 int a[100]; 把 a换成想要的类型名，再在最前面加上typedef即可

#include <iostream>
#include<stdlib.h>
#include<string.h>
const int MAXN=100; //顶点数目的最大值

using namespace std;


//数组表示

struct Graph1{
    int vexnum,arcnum;
    int Matrix[MAXN+1][MAXN+1];
};



/////////////////////////////////////////////////////////////////////////////////////////////
//邻接表表示

struct ArcNode{
    int num;// 代表顶点
    int info;//顶点信息
    struct ArcNode* next;
};
//头结点 在list中的序数代表第几个
typedef struct VNode{
    int info;//顶点信息
    struct ArcNode* first;
}List[MAXN+1];

struct Graph2{
    int vexnum,arcnum;
    List list;
};



bool visited[MAXN];//默认为0


void DFS(struct Graph2 G,int i);
void DFSTraverse(struct Graph2 G)
{
    memset(visited,0,sizeof(visited));
    for(int i=1;i<=G.vexnum;i++)
        if(!visited[i])//如果第i个顶点没被访问过，那么就从i顶点开始访问
        DFS(G,i);
}
void DFS(struct Graph2 G,int i)
{
    visited[i]=true;
    cout<<i<<endl;
    for(struct ArcNode* w=G.list[i].first;w;w=w->next)
    if(!visited[w->num])
    DFS(G,w->num);
}


void CreateGra(Graph2 &G)
{

    cout<<"输出入顶点数和弧的数目"<<endl;
    cin>>G.vexnum>>G.arcnum;

    for(int i=1;i<=G.vexnum;i++)
	{
        //置空莫忘
		G.list[i].first=NULL;
	}

    for(int i=1;i<=G.arcnum;i++)
    {
        int head,bottle;
        cin>>head>>bottle;
        struct ArcNode* p=(struct ArcNode*)malloc(sizeof(struct ArcNode));
        p->num=bottle;
        p->next=G.list[head].first;
        G.list[head].first=p;
        
        
        struct ArcNode* q=(struct ArcNode*)malloc(sizeof(struct ArcNode));
        q->num=head;
        q->next=G.list[bottle].first;
        G.list[bottle].first=q;
    }
}

void PrintGra(Graph2 G)
{
    for(int i=1;i<=G.vexnum;i++)
    {
        for(struct ArcNode* w=G.list[i].first;w;w=w->next)
            cout<<i<<"  "<<w->num<<endl;
    }

}


int main()
{
    Graph2 g;

    CreateGra(g);
    DFSTraverse(g);


    return 0;
}
