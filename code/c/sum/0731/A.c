#include <stdio.h>
#include <string.h>
#include<stdbool.h>
#define MAX_N 27

//字典序最小的行走方向横着走
const int dx[8] = {-1, 1, -2, 2, -2, 2, -1, 1}; 
const int dy[8] = {-2, -2, -1, -1, 1, 1, 2, 2};

bool vis[MAX_N][MAX_N];

struct Step{
    char x, y;
} path[MAX_N];

bool flag;
int T, p, q;

bool check(int xx,int yy){
	if (0<xx && xx<=p && 0<yy && yy<=q && !vis[xx][yy] && !flag){
		return true;
	}
	return false;
}

void DFS(int x, int y, int num){
    path[num].y = y + 'A' - 1;
    path[num].x = x + '0';
    if (num == p*q){
        flag = true;
        return;
    }
    for (int i=0 ; i<8 ; i++){
        int xx = x + dx[i];
        int yy = y + dy[i];
        if(check(xx,yy)){
            vis[xx][yy] = true;
            DFS(xx, yy, num+1);
            vis[xx][yy] = false;   
        }
    }
}

int main(){
    scanf("%d", &T);
    for (int i=1 ; i<=T ; i++){
        flag = false;
        scanf("%d%d", &p, &q);
        memset(vis, false, sizeof(vis));
        vis[1][1] = true; //从第一个走，字典序最小   
        
        DFS(1, 1, 1);              

        printf("Scenario #%d:\n", i);
        if (flag) {
            for (int i=1 ; i<=p*q ; i++){
                printf("%c%c", path[i].y, path[i].x);
            }
            printf("\n");
        }else{
            printf("impossible\n");
        }
        if (i != T)
            printf("\n");  
    }
    return 0;
}


