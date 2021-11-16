#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <map>
using namespace std;



#define INF 1<<28           //无穷大
#define Max_Char 1010		        //最大字符种类数 （叶子结点数）
#define Max_Node Max_Char*2-1		//最大节点数

typedef struct
{
	int weight;
	int lchild;
	int rchild;
	int parent;
	char name;          //结点代表的字符 ，对于非叶子结点可忽略
}Node;

Node NodeList[Max_Node+1];    //结点数组 从1开始
string passage;                //接收文章
int Char_Number=0;              //文章中字符的数目

//从1到p的范围内 寻找最小的两个权值的节点的下标，且节点的parent为-1
void Select(int p,int &s1,int &s2)
{
    int min1=INF,min2=INF;
    for(int i=1;i<=p;i++)
        if(NodeList[i].weight<min1&&NodeList[i].parent==-1)
            {
                min1=NodeList[i].weight;
                s1=i;
            }

    for(int i=1;i<=p;i++)
        if(NodeList[i].weight<min2&&NodeList[i].parent==-1&&i!=s1)
            {
                min2=NodeList[i].weight;
                s2=i;
            }

}






void Huffman()
{

    while(1)
    {
      getline(cin,passage);

        if(passage=="END")
        return;

        if(passage.length()==1)
        {
            printf("%d %d 8.0\n",passage.length()*8,passage.length());
            continue;
        }




    //统计字符种数，以及出现的个数
    map<char,int> m;
    for(int i=0;i<passage.length();i++)
        m[passage[i]]++;

    //结点总数
    int NodeNum=m.size()*2-1;
    //结点初始化
    int i=1;
    for(map<char,int>::iterator it=m.begin();it!=m.end();it++)
    {
        NodeList[i].name=it->first;
        NodeList[i].weight=it->second;
        i++;
    }
    for(int i=1;i<=NodeNum;i++)
    {
        NodeList[i].parent=-1;
        NodeList[i].lchild=-1;
        NodeList[i].rchild=-1;

    }

    //求解过程：
    for(int p=m.size()+1;p<=NodeNum;p++)
    {
        int s1,s2;
        Select(p-1,s1,s2);
        NodeList[p].lchild=s1;NodeList[p].rchild=s2;NodeList[p].weight=NodeList[s1].weight+NodeList[s2].weight;
        NodeList[s1].parent=p;
        NodeList[s2].parent=p;
    }

    int sum=0;
    for(int i=1;i<=m.size();i++)
    {
        int len=0;
        for(int f=NodeList[i].parent;f!=-1;f=NodeList[f].parent)
            len++;

        sum+=len*NodeList[i].weight;
    }
    cout<<passage.length()*8<<" "<<sum<<" ";
    printf("%.1f\n",double(double(8*passage.length())/sum));
//    printf("%d %d %0.1lf\n",passage.length()*8,passage.length(),(double)(passage.length()*8)/sum);
    }

}





int main()
{

    Huffman();


    return 0;
}
