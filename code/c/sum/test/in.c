/*************************************************************************
	> File Name: in.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月20日 星期四 09时07分40秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int n,m,c,len;
    char ch;
    int pr;
    len = scanf("%d%d%n%c",&n,&m,&c,&ch);
    printf("c=%d,len=%d\n%n",c,len,&pr);
    printf("pr=%d",pr);
    
	return 0;
}
