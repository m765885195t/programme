/*************************************************************************
	> File Name: B.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月28日 星期五 18时50分28秒
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>

char A[100][100];

int main(int argc,char *argv[])
{
    int n,m;
    while(scanf("%d%d",&n,&m),m){
        int flag=0;
        for(int i=0 ; i<n ; i++){
            scanf("%s",A[i]);
            for(int j=0 ; j<m ; j++){
                if(A[i][j]=='@'){
                    flag=1;
                }
            }
        }
        if(!flag){
            printf("0\n");
            continue;
        }
        int row[100],col[100];
        for(int i=0 ; i<n ; i++){
            row[i]=1;
            for(int j=0 ; j<m ; j++){
                if(A[i][j] == '@'){
                    row[i]=0;
                    break;
                }
            }
        }
        for(int j=0 ; j<m ; j++){
            col[j]=1;
            for(int i=0 ; i<n ; i++){
                if(A[i][j] == '@'){
                    col[j]=0;
                    break;
                }
            }
        }
        for(int i=0 ; i<n ; i++){
            if(row[i]==1){
                row[i]=0;
            }else{
                break;
            }
        }
        for(int i=n-1 ; i>=0 ; i--){
            if(row[i]==1){
                row[i]=0;
            }else{
                break;
            }
        }
        for(int j=0 ; j<m ; j++){
            if(col[j]==1){
                col[j]=0;
            }else{
                break;
            }
        }
        for(int j=m-1 ; j>=0 ; j--){
            if(col[j]==1){
                col[j]=0;
            }else{
                break;
            }
        }
        int num1=0,num2=0;
        for(int i=0 ; i<n ; i++){
            if((row[i]==1) && (row[i+1]==0)){
                num1++;
            }
        }
        for(int j=0 ; j<m ; j++){
            if((col[j]==1) && (col[j+1]==0)){
                num2++;
            }
        }
        printf("%d\n",(num1+1)*(num2+1));
    }
	return 0;
}
