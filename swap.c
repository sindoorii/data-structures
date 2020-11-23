#include<stdio.h>
void main()
{
int a,b,temp;
printf("enter 2 numbers");
scanf("%d%d",&a,&b);
printf("before swapping a=%d b=%d",a,b);
temp=a;
a=b;
b=temp;
printf("\n after swapping a=%d b=%d",a,b);
return 0;
}
