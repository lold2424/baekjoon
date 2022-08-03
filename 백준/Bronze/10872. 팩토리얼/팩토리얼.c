#include<stdio.h>
int mult(int a){
	if(a > 0){
		return a * mult(a - 1);
	}
	else{
		return 1;
	}
}
int main(){
	int a, b;
	scanf("%d",&a);
	printf("%d",mult(a));
}