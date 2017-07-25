/*************************************************************************
	> File Name: A.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月21日 星期五 15时06分43秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    double tem,sum=0;
    for(int i=0 ; i<12 ; i++){
        scanf("%lf",&tem);
        sum+=tem;
    }
    printf("$%.2lf\n",sum/12);


	return 0;
}
