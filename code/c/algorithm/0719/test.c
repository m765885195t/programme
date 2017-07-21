#include <stdio.h>
int main(){  
  int n;  
  while(scanf("%*[^0-9]"),scanf("%d", &n)!=EOF)  
    printf("n=%d\n", n);  
}  
