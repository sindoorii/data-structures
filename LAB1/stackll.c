#include<stdio.h>
#include<stdlib.h>
struct stack
{
	int data;
	struct stack*next,*temp;
};
struct stack *top=NULL;
void push(int item)
{
	struct stack *newnode;
	newnode=malloc(sizeof(struct stack));
	if(newnode==NULL)
	{
		printf("\nnot enough memory");
		exit(0);
	}
	newnode->data=item;
	newnode->next=top;
	top=newnode;
	printf("\nitem inserted");
}
int pop()
{
	int item=-1;
	if(top==NULL)
	printf("\nunderflow");
	else
	{
		struct stack *temp=top;
		item=top->data;
		top=top->next;
		free(temp);
		printf("\nitem deleted");
	}
	return(item);
}
void traverse()
{
	if(top==NULL)
	printf("\nstack is empty");
	else
	{
		struct stack*temp=top;
		while(temp!=NULL)
		{
			printf("%d\n",temp->data);
			temp=temp->next;
		}
	}
}
int main()
{
	int ch,item;
	while(1)
	{
		printf("\nstack operation");
		printf("\n1: push");
		printf("\n2: pop");
		printf("\n3: traverse");
		printf("\n4: exit");
		printf("\nenter ur choice");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 :printf("\nenter the element");
					scanf("%d",&item);
					push(item);
					break;
			case 2 :item=pop();
					if(item!=-1)
					printf("\ndeleted item is %d",item);
					break;
			case 3 :printf("\ngiven stack is");
					traverse();
					break;
			case 4 :exit(0);
					break;
			default :printf("\nwrong entry");
		}
	}
return 0;
}
