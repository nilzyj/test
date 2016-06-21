#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <fstream>
using namespace std;

int main()
{
    string s[10];
    ifstream file1("file.txt",ios::in);
    if(!file1)
    {
        cout<<"error";
        exit(0);
    }
    else
    {
        for(int i=0;i<3;++i)
            getline(file1,s[i]);
        for(int i=0;i<3;++i)
            cout<<s[i]<<endl;
    }

    ofstream file1("file.txt",ios::out);
    if(!file1)
    {
        cout<<"error";
        exit(0);
    }
    else
    {

    }

    ifstream file1("file.txt",ios::in);
    if(!file1)
    {
        cout<<"error";
        exit(0);
    }
    else
    {
        for(int i=0;i<3;++i)
            getline(file1,s[i]);
        for(int i=0;i<3;++i)
            cout<<s[i]<<endl;
    }
    file1.close();
    return 0;
}
