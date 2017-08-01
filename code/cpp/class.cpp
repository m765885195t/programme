/*************************************************************************
	> File Name: 2.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年08月01日 星期二 11时11分16秒
 ************************************************************************/

#include<iostream>
#include"class.h"
using namespace std;

int main(void){
    A a;
    int b=3;
    int *p=&b;
    cout<<a.get_Username()<<endl;
    cout<<p<<endl;
    a.set_Username(p+1,2);
    cout<<a.get_Username()<<endl;
    cout<<p<<endl;
    cout<<a.c<<endl;
    
    return 0;
}

