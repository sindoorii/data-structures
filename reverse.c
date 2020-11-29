#include<stdio.h>
 void main()
{
int ar[10];
int n,i;
printf("enter the order of array");
scanf("%d",&n);
printf("\n enter the elements");
for(i=0;i<n;i++)
scanf("%d",&ar[i]);
printf("\n array elements are");
for(i=0;i<n;i++)
printf("\t%d",ar[i]);
printf("\n reverse order is");
for(i=n-1;i>=0;i--)
printf("\t%d",ar[i]);
return 0;
}
