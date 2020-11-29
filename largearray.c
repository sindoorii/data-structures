#include<stdio.h>
 void main()
{
int ar[10];
int n,i,large;
printf("enter the order of array");
scanf("%d",&n);
printf("\n enter the elements");
for(i=0;i<n;i++)
scanf("%d",&ar[i]);
large=ar[0];
printf("\n array elements are");
for(i=0;i<n;i++)
{
printf("\t%d",ar[i]);
if(large<ar[i])
large=ar[i];
}
printf("\nlargest number is %d",large);
return 0;
}
