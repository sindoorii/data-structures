#include<stdio.h>
 void main()
{
int ar[10];
int n,i,sum=0;
printf("enter the order of array");
scanf("%d",&n);
printf("\n enter the elements");
for(i=0;i<n;i++)
scanf("%d",&ar[i]);
printf("\n array elements are");
for(i=0;i<n;i++)
{
printf("\t%d",ar[i]);
sum=sum+ar[i];
}
printf("\nsum of array elements is %d",sum);
return 0;
}
