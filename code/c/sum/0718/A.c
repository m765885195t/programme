/*************************************************************************
	> File Name: A.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月18日 星期二 10时46分12秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc,char *argv[])
{
    char ch[100];
    int flag,dop,at,sum;

    while(scanf("%s",ch) != EOF){
        sum = flag = 0;
        dop = at = 1000;

        for(int i=0 ; i<strlen(ch) ; i++){
            if(ch[i]=='@'){
                sum++;
                at=i;
            }else if(ch[i]=='.'){
                    dop=i;
            }
        }
        if(sum!=1 || dop==1000){
            flag=1;
        }else if(ch[0]=='.' || ch[0]=='@' || ch[strlen(ch)-1]=='.' || ch[strlen(ch)-1]=='@'){
            flag=1;
        }else if(ch[at-1]=='.' || ch[at+1] == '.' || dop<=at+1){
            flag=1;
        }
        if(flag){
                printf("NO\n");
        }else{
            printf("YES\n");
        }
    }
    return 0;
}
