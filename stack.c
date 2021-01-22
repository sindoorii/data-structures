#include<stdio.h>
#include<stdlib.h>
int maxsize=9;
int item,top=-1,stack[10];
void push(int item)
{
	if(top>=maxsize)
	printf("\noverflow");
	else
	{
		top=top+1;
		stack[top]=item;
	}
}
int pop()
{
	if(top==-1)
	{
		printf("\nunderflow");
		return 0;
	}
	else
	{
		int item=stack[top];
		top=top-1;
		return item;
	}
}
void traverse()
{
	int temp=top;
	while(temp!=-1)
	{
		printf("\n%d",stack[temp]);
		temp--;
	}
}
int main()
{
	int c,item;
	while(1)
	{
		printf("\nstack program");
		printf("\n1:push");
		printf("\n2:pop");
		printf("\n3:traverse");
		printf("\n4:exit");
		printf("\nenter your choice");
		scanf("%d",&c);
		switch(c)
		{
			case 1 :if(top<maxsize-1)
					{
						printf("\nenter the item");
						scanf("%d",&item);
						push(item);
					}
					else
					printf("\noverflow");
					break;
			case 2 :item=pop();
					if(item!=0)
					printf("\ndeleted item is %d",item);
					break;
			case 3 :printf("\nthe stack is");
					if(top==-1)
					printf("\nstack empty");
					else
					{
						traverse();
						break;
					}
			case 4 : exit(0);
					break;
			}
		}
	}
						
		
	
