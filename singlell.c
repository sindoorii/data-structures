#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *link;
};
int x,value;
struct node *ptr,*ptr1,*header,*newnode;
void newnode_fun()
{
	newnode=(struct node*)malloc(sizeof(struct node));
	printf("\n enter the data");
	scanf("%d",&value);
	newnode->data=value;
	newnode->link=NULL;
}
void traverse()
{
	struct node *ptr=header;
	ptr=ptr->link;
	while(ptr!=NULL)
	{
		printf("\n%d",ptr->data);
		ptr=ptr->link;
	}
}
void insert_begin()
{
	struct node *ptr=header,*ptr1;
	newnode_fun();
	if(newnode==NULL)
	printf("\n memory isnt avilable");
	else
	{
		ptr1=ptr->link;
		ptr->link=newnode;
		newnode->link=ptr1;
	}
}
	void insert_end()
	{
		newnode_fun();
		if(newnode==NULL)
		printf("\n memory isnt avialble");
		else
		{
			ptr=header;
			while(ptr->link!=NULL)
			{
				ptr=ptr->link;
			}
			ptr->link=newnode;
		}
	}
	void insert_any()
	{
		int key;
		newnode_fun();
		if(newnode==NULL)
		printf("\n memory isnt avialble");
		else
		{
			ptr=header;
			printf("\n enter the key value");
			scanf("%d",&key);
			while(ptr->data!=key && ptr->link!=NULL)
			{
				ptr=ptr->link;
			}
			if(ptr->link==NULL)
			printf("\n key isnt found");
			else
			{
				newnode->link=ptr->link;
				ptr->link=newnode;
			}
		}
	}
	void delete_begin()
	{
		ptr=header->link;
		if(ptr==NULL)
		printf("\n list is empty");
		else
		{
			ptr1=ptr->link;
			header->link=ptr1;
		}
	}
	void delete_end()
	{
		struct node *ptr,*ptr1;
		ptr=header->link;
		while(ptr->link!=NULL)
		{
			ptr1=ptr;
			ptr=ptr->link;
			ptr1->link=ptr;
		}
		ptr1->link=NULL;
	}
	void delete_any()
	{
		struct node *ptr=header;
		int key;
		printf("\n enter the key");
		scanf("%d",&key);
		while(ptr->data!=key && ptr->link!=NULL)
		{
			ptr1=ptr;
			ptr=ptr->link;
		}
		if(ptr->data==key)
		{
			ptr1->link=ptr->link;
		}
		if(ptr==NULL)
		printf("\n key isnt found");
	}
	void length()
	{
		struct node *ptr=header;
		int count=0;
		while(ptr->link!=NULL)
		{
			ptr=ptr->link;
			count++;
		}
		printf("\nlength id %d",count);
	}
	int main()
	{
		int s,l=1;
		while(l)
		{
			printf("\n 1:insert at begin");
			printf("\n 2:insert at end");
			printf("\n 3:insert at any");
			printf("\n 4:delete at front");
			printf("\n 5:delete at end");
			printf("\n 6:delete at any");
			printf("\n 7:length");
			printf("\n enter the choice");
			scanf("%d",&s);
			switch(s)
			{
				case 1 :insert_begin();break;
				case 2 :insert_end();break;
				case 3 :insert_any();break;
				case 4 :delete_begin();break;
				case 5 :delete_end();break;
				case 6 :delete_any();break;
				case 7 :length();break;
				default :printf("\n wrong entry");
			}
		}
		return 0;
}
			
		
		
	
	
	

