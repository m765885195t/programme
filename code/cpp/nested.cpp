/*************************************************************************
	> File Name: 1.cpp
	> Author: motian
	> Mail: motian@xiyoulinux.org
	> Created Time: 2017年08月01日 星期二 21时44分44秒
 ************************************************************************/

#include<iostream>
#include<cstring>
#define MAX 128
using namespace std;

class CList
{
public:
    class CNode
    {
    friend class CList;
    private:
        int m_Tag;
    public:
        char m_Name[MAX];
    };
public:
    CNode m_Node;
    void SetNodeName(const char*pchData){
        if(NULL != pchData){
            strcpy(m_Node.m_Name,pchData);
        }
    }
    void SetNodeTag(int tag){
        m_Node.m_Tag=tag;
    }
    inline auto getNodeTag() const{
        return m_Node.m_Tag;
    }
    ~CList(){
        cout<<"析构"<<m_Node.m_Name<<m_Node.m_Tag<<endl;
    }
};

int main(int argc,char *argv[])
{
    CList list;
    list.SetNodeName("name");
    list.SetNodeTag(1);    
    cout<<list.getNodeTag()<<endl;
	return 0;
}
