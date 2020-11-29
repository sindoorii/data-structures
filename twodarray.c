#include<stdio.h>
 void main()
{
int ar[10][10];
int m,n,i,j;
printf("enter the no:of rows and cols");
scanf("%d%d",&m,&n);
printf("\n enter the elements");
for(i=0;i<m;i++)
for(j=0;j<n;j++)
scanf("%d",&ar[i][j]);
printf("\n array elements are");
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t%d",ar[i][j]);
}
return 0;
}
