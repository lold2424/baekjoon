#include <stdio.h>
#include <string.h>
#include <stack>
using namespace std;
stack<int> s;
int main(){
	int n,i;
	scanf("%d",&n);
	for(i=0;i<n;i++){
		char input[6]={0};
		scanf("%s",input);
		if(strcmp(input,"push")==0){
			int x;
			scanf("%d",&x);
			s.push(x);
		}
		if(strcmp(input,"pop")==0){
			if(s.empty()==false){
				printf("%d\n",s.top());
				s.pop();
			}
			else{
				printf("-1\n");
			}
		}
		if(strcmp(input,"size")==0){
			printf("%d\n",s.size());
		}
		if(strcmp(input,"empty")==0){
			if(s.size()==0){
				printf("1\n");
			}
			else{
				printf("0\n");
			}
		}
		if(strcmp(input,"top")==0){
			if(s.size()==0)
				printf("-1\n");
			else{
				printf("%d\n",s.top());
			}
		}
		
	}
	return 0;
}