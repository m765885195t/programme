/*************************************************************************
	> File Name: B.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月21日 星期五 15时11分07秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

int main(int argc,char *argv[])
{
    int p,T,len,flag;
    scanf("%d%*c",&T);
    char str[1000];

    while(p=flag=0,T--){
        scanf("%[^\n]%n%*c",str,&len);
        for(int i=0 ; i<len/2 ; i++){
            if(str[i]!=str[len-1-i]){
                flag=1;
            }
        }
        printf(flag?"no\n":"yes\n");
    }

	return 0;
}
