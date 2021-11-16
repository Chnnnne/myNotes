//typedef�÷���  �� int a[100]; �� a������Ҫ����������������ǰ�����typedef����

#include <iostream>
#include<stdlib.h>
#include<string.h>
const int MAXN=100; //������Ŀ�����ֵ

using namespace std;


//�����ʾ

struct Graph1{
    int vexnum,arcnum;
    int Matrix[MAXN+1][MAXN+1];
};



/////////////////////////////////////////////////////////////////////////////////////////////
//�ڽӱ��ʾ

struct ArcNode{
    int num;// ������
    int info;//������Ϣ
    struct ArcNode* next;
};
//ͷ��� ��list�е���������ڼ���
typedef struct VNode{
    int info;//������Ϣ
    struct ArcNode* first;
}List[MAXN+1];

struct Graph2{
    int vexnum,arcnum;
    List list;
};



bool visited[MAXN];//Ĭ��Ϊ0


void DFS(struct Graph2 G,int i);
void DFSTraverse(struct Graph2 G)
{
    memset(visited,0,sizeof(visited));
    for(int i=1;i<=G.vexnum;i++)
        if(!visited[i])//�����i������û�����ʹ�����ô�ʹ�i���㿪ʼ����
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

    cout<<"����붥�����ͻ�����Ŀ"<<endl;
    cin>>G.vexnum>>G.arcnum;

    for(int i=1;i<=G.vexnum;i++)
	{
        //�ÿ�Ī��
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
