/*************************************************************************
	> File Name: test.c
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月21日 星期五 12时33分41秒
 ************************************************************************/

#include <stdio.h>
typedef struct{ 
	int i; 
	int num; 
	int state; 
}task;
#define crBegin(state) \
	switch (state){ case 0: 
#define crReturn(state, ret) \
	 (state) = __LINE__; return (ret); case __LINE__:
#define crEnd() \
	} 
int cb(task *t) {
	 crBegin(t->state); 
	 for (;;) {
	  	t->num = 1; 
	  	for (t->i = 0; t->i < 20; t->i++) {
	  		 crReturn(t->state, t->num); t->num += 1; 
	  	} 
	 } 
	 crEnd(); 
} 
int main() { 
	task t; 
	t.state = 0; 
	for (int i=0 ; i<10 ; i++) { 
		printf("%d ", cb(&t)); 
	} 
	return 0; 
} 


