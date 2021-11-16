#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <map>
using namespace std;



#define INF 1<<28           //�����
#define Max_Char 1010		        //����ַ������� ��Ҷ�ӽ������
#define Max_Node Max_Char*2-1		//���ڵ���

typedef struct
{
	int weight;
	int lchild;
	int rchild;
	int parent;
	char name;          //��������ַ� �����ڷ�Ҷ�ӽ��ɺ���
}Node;

Node NodeList[Max_Node+1];    //������� ��1��ʼ
string passage;                //��������
int Char_Number=0;              //�������ַ�����Ŀ

//��1��p�ķ�Χ�� Ѱ����С������Ȩֵ�Ľڵ���±꣬�ҽڵ��parentΪ-1
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




    //ͳ���ַ��������Լ����ֵĸ���
    map<char,int> m;
    for(int i=0;i<passage.length();i++)
        m[passage[i]]++;

    //�������
    int NodeNum=m.size()*2-1;
    //����ʼ��
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

    //�����̣�
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
