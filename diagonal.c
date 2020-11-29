#include<stdio.h>
void main()
{
int a[10][10];
int i,j,m;
printf("\n enter the order");
scanf("%d",&m);
printf("\n enter the elements");
for(i=0;i<m;i++)
for(j=0;j<m;j++)
scanf("%d",&a[i][j]);
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<m;j++)
printf("\t%d",a[i][j]);
}
printf("\n the diagonal elements are:");
for(i=0;i<m;i++)
printf("\n%d",a[i][i]);
return 0;
}
