#include <stdio.h>

int main(){
    int n,nCase=0;
    while(scanf("%d",&n)==1)
    {
        if(n==0) break;
        int a[1005],i,c1=0,c2=0;
        nCase++;
        for(i=0;i<n;i++)
        {
            scanf("%d",&a[i]);
            if(a[i]==0) c2++;
            else c1++;
        }
        printf("Case %d: %d\n",nCase,c1-c2);
    }
    return 0;
}
