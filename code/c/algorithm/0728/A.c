/*************************************************************************
	> File Name: A.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月28日 星期五 09时13分21秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
int len;

void swap(char *a,char *b){
    char tem;
    tem = *a;
    *a = *b;
    *b = tem;
}

int cmp(const void *ch1,const void *ch2){
    return *(char *)ch1-*(char *)ch2;    
}

bool isswap(char * str,int start,int end){
    for(int i=start ; i<end ; i++){
        if(str[i] == str[end]){
            return false;
        }
    }
    return true;
}

void Recursive(char *str,int start,int len){
    if(start == len-1){
        printf("%s\n",str);
    }
    for(int i=start ; i<len ; i++){
        qsort(str+i,len-i,sizeof(str[0]),cmp);
        if(isswap(str,start,i)){
            swap(&str[start],&str[i]);
            Recursive(str,start+1,len);
            swap(&str[i],&str[start]);
        }
    }
}

int main(int argc,char *argv[]){
    int T;
    char str[15];
    scanf("%d",&T);
    while(T--){
        scanf("%s",str);
        Recursive(str,0,strlen(str));
    }
	return 0;
}
