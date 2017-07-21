/*************************************************************************
	> File Name: A.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月20日 星期四 11时30分13秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int n,m,flag;
    while(flag=0,~scanf("%d%d",&n,&m)){
        switch(flag){
            case 0:printf(((n<=153&&153<=m)?++flag:0)?"153":"");
            case 1:printf(((n<=370&&370<=m)?++flag:0)?(flag!=1?" 370":"370"):"");            
            case 2:printf(((n<=371&&371<=m)?++flag:0)?(flag!=1?" 371":"371"):"");            
            case 3:printf(((n<=407&&407<=m)?++flag:0)?(flag!=1?" 407":"407"):"");
            case 4:printf(flag?"\n":"no\n");
        }
    }

	return 0;
}
