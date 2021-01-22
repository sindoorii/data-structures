#include <stdio.h>
void swap(int *n1, int *n2);

int main()
{
    int num1,num2;
    printf("\n enter 2 numbers");
    scanf("%d%d",&num1,&num2);
    printf("\nberfore swapping\nnum1=%d\nnum2=%d",num1,num2);
    swap( &num1, &num2);
    printf("\nafter swapping\nnum1 = %d\n", num1);
    printf("num2 = %d", num2);
    return 0;
}
void swap(int* n1, int* n2)
{
    int temp;
    temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}
