#include<stdio.h>
void main()
{
int a[10][10],b[10][10],c[10][10];
int i,j,m,n;
printf("\n enter the order martix");
scanf("%d%d",&m,&n);
printf("\n enter the first matrix");
for(i=0;i<m;i++)
for(j=0;j<n;j++)
scanf("%d",&a[i][j]);
printf("\n enter the second matrix");
for(i=0;i<m;i++)
for(j=0;j<n;j++)
scanf("%d",&b[i][j]);
for(i=0;i<m;i++)
for(j=0;j<n;j++)
c[i][j]=a[i][j]+b[i][j];
printf("\n sum of matrices is");
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t%d",c[i][j]);
}
return 0;
}
