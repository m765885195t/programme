/*************************************************************************
	> File Name: 1.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年07月18日 星期二 15时14分40秒
 ************************************************************************/

#include<iostream>
#include<iomanip>
using namespace std;

int main(int argc,char *argv[])
{
    int b=12345;
    cout<<hex<<b<<endl;//16进制输出
    cout.setf(ios::left);
    cout<<setfill('*')<<setw(10)<<b<<endl;//域宽为10填充*
    cout.unsetf(ios::hex);//清楚16进制设置
    cout<<12<<endl;


	return 0;
}
