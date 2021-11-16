#include<stdio.h>
#include<stdlib.h> 
#include<string.h> 
#define LIST_INIT_SIZE 100
#define LISTINCREMENT 10



typedef struct {
	char *elem;
	int length;
	int listsize;
}SqList;

SqList A;


void LnitList_Sq(SqList &L)
{
	L.elem=(char *)malloc(LIST_INIT_SIZE*sizeof(char));
	if(!L.elem) 
	{ 
		printf("申请空间失败");
		exit(0);
	}
 
	L.length=0;
	L.listsize=LIST_INIT_SIZE;
}


//打印顺序表					T(n)=O(n)
void Print(SqList L)
{
	int i;
	puts("打印顺序表");
	for(i=1;i<=L.length;i++)
	printf("%c",*(L.elem+i));

	putchar('\n');
	
 } 




void ListInsert_Sq(SqList &L,int i,char e)
{
	if(i<1||i>L.length+1)
	{
		printf("输入的数据有误");
		exit(0);
	 } 
	if(L.length>=L.listsize)
	{
		L.elem=(char *)realloc(L.elem,(LIST_INIT_SIZE+LISTINCREMENT)*sizeof(int));
		if(!L.elem)
		{
			printf("空间重新申请失败\n");
			exit(0); 
		}
		L.listsize+=LISTINCREMENT;
		
	}
	//q指向将要插入的位置，p用以遍历  
	//注意逐个将元素后移时，要从最后一个开始 
	char *p,*q=L.elem+i;     
	for(p=L.elem+L.length;p>=q;p--)
	 *(p+1)=*p;
	 
	 *q=e;
	 L.length++;	
}


int next[100];

int Index_KMP(SqList S,SqList T) 
{
	int i=1; int j=1;
	while(i<=S.length&&j<=T.length)
	{
		if(j==0||S.elem[i]==T.elem[j]) {++i;	++j;}
		else j=next[j];
	 } 
	if(j>T.length) 
	return i-T.length;
	else return 0;
 } 
 
void get_next(SqList T,int *next) 
{
	int i=1;	next[1]=0;	int j=0;
	while(i<T.length)
	{
		if(j==0||T.elem[i]==T.elem[j]){
			++j;++i;next[i]=j;
		}
		else j=next[j];
	}
}
 

void Load()
{
	LnitList_Sq(A);
	
	
	
	FILE *fp;
	if((fp=fopen("C:\\Users\\95266\\Desktop\\passage.txt","r"))==NULL)
	{
		printf("can't open file!\n");
		exit(0);
	}

	int i=1;
	while(!feof(fp))
	{
		ListInsert_Sq(A,i++,fgetc(fp));
	}

	fclose(fp);
	
}



void CreateList(SqList &L,char *s)
{
	L.length=strlen(s);
	L.elem=(char *)malloc((L.length+10)*sizeof(char));//多开辟一点空间 
	L.listsize=L.length+10;
	for(int i=1;i<=L.length;i++)
	{
		L.elem[i]=*(s++);
		
		}	
	
}

void Save()
{
	
	FILE *fp;
	if((fp=fopen("newpassage.txt","w"))==NULL)
	{
		printf("can't open file!\n");
		exit(0);
	}
	int len=;

	for(int i=1;i<=len;i++)
	{
		fputc(s[i-1],fp);
	}
	fclose(fp);
	
}




int main()
{
	Load();
	SqList T;
	LnitList_Sq(T);
	char s[]={'d','o','g','\0'};
	CreateList(T,s);

	get_next(T,next); 
	
	printf("%d",Index_KMP(A,T));

	return 0;
}



