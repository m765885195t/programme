#include<stdio.h>
#include<string.h>

char A[8][8];
int row[8];
int n,k,count; 

void DFS(int line,int num){
    if(num == k){
        count++;
        return;
    }

    for(int i=line ; i<n ; ++i){ 
        for(int j=0 ; j<n ; j++){
            if(!row[j] && A[i][j]=='#'){
                row[j]=1; 
                DFS(i+1,num+1);
                row[j]=0; 
            }
        }
    }   
} 

int main(void){
    while(scanf("%d%d",&n,&k),n!=-1){
        for(int i=0 ; i<n ; ++i){
            scanf("%s",&A[i]); 
        }
        count = 0;
        memset(row,0,n);

        DFS(0,0); 

        printf("%d\n",count); 
    }
    return 0;
} 
