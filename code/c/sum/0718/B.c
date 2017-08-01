/*************************************************************************
	> File Name: B.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月18日 星期二 14时04分05秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int n;
    float min,max,sum,fraction;
    while(scanf("%d",&n)!=EOF){
        max=-1,min=100000,sum=0;
        for(int i=0 ; i<n ; i++){
            scanf("%f",&fraction);
            sum+=fraction;
            if(fraction<min){
                min = fraction;
            }
            if(fraction > max){
                max = fraction;
            }
        }
        printf("%.2f\n",(sum-max-min)/(n-2));
    }


	return 0;
}
