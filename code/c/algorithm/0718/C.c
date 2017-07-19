/*************************************************************************
	> File Name: C.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月18日 星期二 13时20分19秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int n,m,ans;
    while(scanf("%d%d",&n,&m)!=EOF){
        ans=m+1;
        for(int i=0 ; i<n/m ; i++){
            printf("%d",ans);
            ans+=2*m;
            if(i!=n/m-1){
                printf(" ");       
            }
        }
        if(n%m){
            printf(" %d\n",2*n+1-n%m);
        }else{
            printf("\n");
        }
    }

    return 0;
}
