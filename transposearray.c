#include<stdio.h>
void main()
{
int a[10][10];
int i,j,m,n;
printf("\n enter the order martix");
scanf("%d%d",&m,&n);
printf("\n enter the elements");
for(i=0;i<m;i++)
for(j=0;j<n;j++)
scanf("%d",&a[i][j]);
printf("\n matrix is");
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t%d",a[i][j]);
}
printf("\n transpose is");
for(i=0;i<n;i++)
{
printf("\n");
for(j=0;j<m;j++)
printf("\t%d",a[j][i]);
}
return 0;
}
