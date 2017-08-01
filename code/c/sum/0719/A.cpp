/*************************************************************************
	> File Name: A.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月19日 星期三 14时21分54秒
 ************************************************************************/

#include<iostream>

using namespace std;

int main(int argc,char *argv[])
{
    int n,t1,t2,t3,T;
    while(cin>>n,n){
        t1=0,t2=0,t3=0,T=1;
        
        while(--n){
            T+=t3;
            t3=t2;
            t2=t1;
            t1=T;
        }
        cout<<t1+t2+t3+T<<endl;
    }



	return 0;
}
