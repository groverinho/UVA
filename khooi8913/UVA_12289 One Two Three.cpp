#include <stdio.h>
#include <string.h>

using namespace std;

int main(){

    int numCases; scanf("%d",&numCases);

    for(int i=0;i<numCases;i++){
        char a[10]; scanf("%s",a);

        if(strlen(a)==5)    printf("3\n");
        else{
            int count=0;

            if(a[0]=='o')   count++;
            if(a[1]=='n')   count++;
            if(a[2]=='e')   count++;

            if(count>=2)    printf("1\n");
            else    printf("2\n");
        }
    }

    return 0;

}

