/*************************************************************************
	> File Name: C.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月19日 星期三 15时23分25秒
 ************************************************************************/

#include<stdio.h>
int main(int argc,char *argv[]){
    int n,len,sum;
    scanf("%d%*c",&n);
    
    while(sum=len=0,n--){
        while(len=0,1){
            scanf("%*[^0-9a-zA-Z ?!\n]%n",&len);
            sum+=len;
            if(getchar()=='\n') break;
        }
        printf("%d\n",sum/3);
    }

	return 0;
}
