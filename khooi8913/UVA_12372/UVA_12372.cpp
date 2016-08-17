#include <stdio.h>

using namespace std;

int main(){

    int n;
    scanf("%d", &n);

    for(int i=1;i<=n;i++){
        int L,W,H;
        scanf("%d %d %d", &L,&W,&H);

        if(L<=20 && W<=20 && H<=20)
            printf("Case %d: good\n", i);
        else
            printf("Case %d: bad\n", i);
    }

    return 0;
}
