/*************************************************************************
	> File Name: B.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月20日 星期四 12时57分19秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
    int T,len,flag;
    char str[1005],tem[1001];
    
    scanf("%d%*c",&T);
    
    while(tem[flag=1000]='\0',T--){
        scanf("%[^\n]%n%*c",str,&len);
        for(int i=0 ; i<len ; i++){
            if(str[i]==' '){
                printf("%s ",tem+flag);
                flag = 1000;
            }else{
                tem[--flag]=str[i];
            }
        }
        printf("%s\n",tem+flag);
    }

	return 0;
}
