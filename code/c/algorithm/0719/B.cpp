/*************************************************************************
	> File Name: B.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月19日 星期三 14时33分52秒
 ************************************************************************/

#include<iostream>

int gcd(int a,int b){
    return (b==0)?a:gcd(b,a%b);
}

int main(int argc,char *argv[])
{
    int n,ans,m,tem;
    while(std::cin>>n){
        ans=1;
        while(n--){
            std::cin>>m;
            ans *= m/gcd(m,ans);
        }
        std::cout<<ans<<std::endl;
    }


	return 0;
}
