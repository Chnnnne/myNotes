#include<bits/stdc++.h>
using namespace std;
#define random(a,b) ((a)+rand()%((b)-(a)+1))//random(a,b)����[a,b]���������

stringstream ss;

int main( int argc, char *argv[] )
{ 
    int seed=time(NULL);
    if(argc > 1)//����в���
    {
        ss.clear();
        ss<<argv[1];
        ss>>seed;//�Ѳ���ת����������ֵ��seed
    }
    srand(seed);
    //����Ϊ�������ʼ���������޸�
    

    //����д���Լ����������ɴ��� 
	for(int i=1;i<=1000;i++)
	{
		for(int j=1;j<=random(1,90);j++)
		{
			char c=char('A'-1+random(1,27));
			if(c=='A'-1+27)
			printf("_");
			else 
			printf("%c",c);
		}
		printf("\n");
	 } 
	 printf("END\n");
	

//	int t=rand()%1000+1;
//    printf("%d\n",t);
    return 0;
}
