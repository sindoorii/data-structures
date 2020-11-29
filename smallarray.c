#include<stdio.h>
 void main()
{
int ar[10];
int n,i,small;
printf("enter the order of array");
scanf("%d",&n);
printf("\n enter the elements");
for(i=0;i<n;i++)
scanf("%d",&ar[i]);
small=ar[0];
printf("\n array elements are");
for(i=0;i<n;i++)
{
printf("\t%d",ar[i]);
if(small>ar[i])
small=ar[i];
}
printf("\nsmallest number is %d",small);
return 0;
}
