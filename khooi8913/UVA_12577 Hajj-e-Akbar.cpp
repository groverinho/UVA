#include <cstdio>
#include <cstring>

using namespace std;

int main(){
    char input[20];
    int i=1;

    while(scanf("%s",input)){
        if(strcmp(input,"*")==0)
            break;
        if(strcmp(input,"Hajj")==0){
            printf("Case %d: Hajj-e-Akbar\n",i++);
        }
        else{
            printf("Case %d: Hajj-e-Asghar\n",i++);
        }
    }
    return 0;
}

