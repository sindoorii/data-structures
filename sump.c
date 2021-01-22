#include <stdio.h>
int main()
{
  int* pc,a,b;
 printf("\nenter 2 numbers");
 scanf("%d%d",&a,&b);
pc = &a;
printf("\n sum is %d",*pc+b);  
return 0;
}
