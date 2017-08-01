/*************************************************************************
	> File Name: 1.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年08月01日 星期二 10时36分05秒
 ************************************************************************/

#include<iostream>
#include<cstring>
using namespace std;

char a[]={'1','2','3'};

class A{
    public:
        static int c;
    private:
        char* username;
        char* password;
    public:
        A(char *b=a){
            username=a;
        }
        ~A();
        inline char* get_Username() const;
        void set_Username(int * &&,int);
        inline void set_Password();
        
};

int A::c=2;
inline char* A::get_Username() const{
    return username;
}

void A::set_Username(int *&& username1,int len){
    username=username++;
}
A::~A(){
    username=NULL;
    password=NULL;
    cout<<"s"<<endl;
}
