/*************************************************************************
	> File Name: C.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月21日 星期五 15时53分05秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main(int argc,char *argv[])
{
    int T,n;
    scanf("%d",&T);
    while(T--){
        scanf("%d",&n);
        printf("%.0lf\n",pow(2,n)+2);
    }

	return 0;
}
