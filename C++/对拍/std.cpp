 #include<cstdio>
#include<cstring>
#include<queue>
using namespace std;
char str[120];
int cnts[27];
bool cmp(int a,int b){
    return cnts[a]<cnts[b];
}
int prs(char c){
    if(c>='A'&&c<='Z')c-='A'-1;
    else c=0;
    return c;
}
char unp(int i){
    if(i>=1)i+='A'-1;
    else i='_';
    return (char)i;
}
struct Node{
    int l,r;
    Node(){}
}nodes[600];
int tot=27;
struct mpair{
    int a,b;
    mpair(){}
    mpair(int aa,int bb){a=aa,b=bb;}
    bool operator<(mpair an)const{
        return b>an.b;
    }
};
/*int fa[600];
int root(int a){
    if(fa[a])return fa[a]=root(fa[a]);
    return a;
}*/
int lens[27];
void dfs(int u,int depth){
    if(u<=26){lens[u]=depth;return;}
    else dfs(nodes[u].l,depth+1),dfs(nodes[u].r,depth+1);
}
void init(){
    tot=27;
    memset(nodes,0,sizeof nodes);
    memset(cnts,0,sizeof cnts);
    memset(lens,0,sizeof lens);
}
int main(){
    while(~scanf("%s",str)){
        if(!strcmp(str,"END"))return 0;
        init();
        int len=strlen(str);
        for(int i=0;i<len;i++)cnts[str[i]=prs(str[i])]++;
        priority_queue<mpair> que;
        int ecnt=0;
        for(int i=0;i<=26;i++)if(cnts[i])
            que.push(mpair(i,cnts[i])),ecnt++;
        if(ecnt==1){
            printf("%d %d 8.0\n",len*8,len);
            continue;
        }
        while(ecnt>1){
            mpair a,b;
            a=que.top();
            que.pop();
            b=que.top();
            que.pop();
            //printf("union:%d(%d) %d(%d)\n",a.a,a.b,b.a,b.b);
            nodes[tot].l=a.a;
            nodes[tot].r=b.a;
            que.push(mpair(tot++,a.b+b.b));
            ecnt--;
        }
        dfs(que.top().a,0);
        int length=0;
        for(int i=0;i<len;i++)length+=lens[str[i]];
        printf("%d %d %0.1lf\n",len*8,length,(double)(len*8)/length);
    }
}
