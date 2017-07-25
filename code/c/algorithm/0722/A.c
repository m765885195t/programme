/*************************************************************************
	> File Name: A.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月22日 星期六 08时23分21秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int T;
    char str[6];
    scanf("%d%*c",&T);
    while(T--){
        scanf("%*6s%s",str);
        printf("6%s\n",str);
    }

	return 0;
}
