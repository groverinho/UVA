#include <cstdio>
#include <cstring>

using namespace std;

int main(){

		int numCase, sum=0, donation=0;
		char a[100];
		scanf("%d", &numCase);

		for(int i=0;i<numCase;i++){

            scanf("%s",a);

			if(strcmp(a,"donate")==0){
				scanf("%d",&donation);
				sum+=donation;
			}

			else{
				printf("%d\n", sum);
			}
		}
		return 0;
	}
