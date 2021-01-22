#include <stdio.h>
int main()
{
  int* pc, c;
c = 5;
pc = &c;
printf("\n value using pntr %d", *pc);  
printf("\naddress is %p",pc);   
return 0;
}
