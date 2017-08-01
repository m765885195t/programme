#include<stdio.h>
#include<stdbool.h>
#include<string.h>

int prime[]= {  
 	0, 0, 1, 1, 0, 1, 0,   
 	1, 0, 0, 0, 1, 0, 1,   
 	0, 0, 0, 1, 0, 1, 0,   
 	0, 0, 1, 0, 0, 0, 0,   
 	0, 1, 0, 1, 0, 0, 0,  
 	0, 0, 1, 0, 0  
}; 

int a[20];
int n,num=1;

bool check(int step, int val){  
 	if(!prime[a[step]+val]){
     	return false ;  
	}
	for(int i=0 ; i<=step ; i++){
   		if(a[i] == val){  
   			return false ;  
    	}
	}
	return true ;  
}  

void dfs(int step){
	if(step == n){
	    if(prime[a[0]+a[n-1]]){  
	        for(int i=0 ; i<n ; i++){  
	            printf((i!=n-1)?"%d ":"%d\n",a[i]);
	        }
	    }
	    return ;   
	}  

	for(int i=2 ; i<=n ; i++){  
    	a[step]=i; 
    	if(check(step-1,i)){  
            dfs(step+1);
    	} 
	}  
}  

int main(){   
 	while(scanf("%d",&n)!=EOF){     
        printf("Case %d:\n",num++); 
        a[0]=1;
   	 	
        if(!(n&1)){
            dfs(1); 
        }
        
        printf("\n");
 	}  
 	return 0 ;  
} 
