#include<stdio.h>
#include<stdlib.h>
int maxsize=9,front=-1,rear=-1,queue[10],item;
void insert(int item)
{
	if(rear==maxsize)
	printf("\noverflow");
	else if(rear==-1)
	{
		front=rear=0;
		queue[rear]=item;
	}
	else
	{
		rear++;
		queue[rear]=item;
	}
}
int delete()
{
	if(front==-1)
	{
		printf("\nunderflow");
		return 0;
	}
	else
	{
		item=queue[front];
	}
	if(front==rear)
	front=rear-1;
	else
	front++;
	return item;
}
void traverse()
{
	int temp=front;
	while(temp<=rear)
	{
		printf("\n%d",queue[temp]);
		temp++;
	}
}
int main()
{
	int c,item;
	while(1)
	{
		printf("\nqueue program");
		printf("\n1:enqueue");
		printf("\n2:dequeue");
		printf("\n3:traverse");
		printf("\n4:exit");
		printf("\nenter your choice");
		scanf("%d",&c);
		switch(c)
		{
			case 1 :printf("\nenter the item");
					scanf("%d",&item);
					insert(item);
					break;
			case 2 :item=delete();
					printf("\ndeleted item is %d",item);
					break;
			case 3 :printf("\nthe queue is");
					traverse();
					break;
			case 4 :exit(0);
					break;
			}
		}
	}
		
