#include <stdio.h>
int main()
{
  int a[10],n,i,sum=0;
  printf("Enter the order of array");
  scanf("%d",&n);
  printf("\n enter the elements"); 
  for(i=0;i<n;i++)
  {
  scanf("%d",a+i);
  sum += *(a+i);
  }
  printf("Sum = %d",sum);
  return 0;
}
