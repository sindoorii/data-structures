#include<stdio.h>
void main()
{
int a[10][10],b[10][10],c[10][10];
int i,j,m,n,m1,n1,k;
printf("\n enter the order of first martix");
scanf("%d%d",&m,&n);
printf("\n enter the first matrix");
for(i=0;i<m;i++)
for(j=0;j<n;j++)
scanf("%d",&a[i][j]);
printf("\n enter the order of second martix");
scanf("%d%d",&m1,&n1);
printf("\n enter the second matrix");
for(i=0;i<m1;i++)
for(j=0;j<n1;j++)
scanf("%d",&b[i][j]);
printf("\n first matrix is");
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t%d",a[i][j]);
}
printf("\n first second is");
for(i=0;i<m1;i++)
{
printf("\n");
for(j=0;j<n1;j++)
printf("\t%d",b[i][j]);
}
if(m1==n)
{
for(i=0;i<m;i++)
for(j=0;j<n1;j++)
{
c[i][j]=0;
for(k=0;k<n;k++)
c[i][j]=c[i][j]+a[i][k]*b[k][j];
}
printf("\n resultant martix is");
for(i=0;i<m;i++)
{
printf("\n");
for(j=0;j<n1;j++)
printf("\t%d",c[i][j]);
}
}
else 
printf("\n not possible");
return 0;
}
