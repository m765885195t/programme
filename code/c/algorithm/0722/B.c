/*************************************************************************
	> File Name: B.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月22日 星期六 08时16分14秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int T,n,m;
    scanf("%d",&T);

    while(T--){
        scanf("%d%d",&n,&m);
        printf("%d\n",(n%100+m%100)%100);

    }
	return 0;
}
