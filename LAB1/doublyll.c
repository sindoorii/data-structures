#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *llink,*rlink;
};
struct node *header;1
struct node *newnode,*ptr,*ptr1;
void newnode_fun()
{
	newnode=(struct node*)malloc(sizeof(struct node));
	printf("\nenter the data");
	scanf("%d",&newnode->data);
	newnode->rlink=NULL;
	newnode->llink=NULL;
}
void length()
{
	ptr=header;
	int i=0;
	while(ptr->rlink!=NULL)
	{
		i++;
		ptr=ptr->rlink;
	}
	printf("\nlength is %d",i);
}
void insert_begin()
{
	ptr=header->rlink;
	newnode_fun();
	ptr->llink=newnode;
	newnode->rlink=ptr;
	header->rlink=newnode;
	newnode->llink=header;
}
void insert_end()
{
	ptr=header;
	newnode_fun();
	while(ptr->rlink!=NULL)
	{
		ptr=ptr->rlink;
	}
	ptr->rlink=newnode;
	newnode->llink=ptr;
}
void insert_any()
{
	ptr=header;
	int key;
	printf("\nenter the key");
	scanf("%d",&key);
	newnode_fun();
	while(ptr->rlink!=NULL && ptr->data!=key)
	{
		ptr=ptr->rlink;
	}
	if(ptr->data==key)
	{
		ptr1=ptr->rlink;
		ptr->rlink=newnode;
		newnode->llink=ptr;
		ptr1->llink=newnode;
		newnode->rlink=ptr1;
	}
	else
	printf("\nkey isnt found");
}
void delete_begin()
{
	ptr=header->rlink;
	ptr1=ptr->rlink;
	header->rlink=ptr1;
	ptr1->llink=header;
}
void delete_end()
{
	ptr=header;
	if(header==NULL)
	printf("\nlist is empty");
	else
	{
		while(ptr->rlink!=NULL)
		{
			ptr1=ptr;
			ptr=ptr->rlink;
		}
		ptr1->rlink=NULL;
	}
}
void delete_any()
{
	int key;
	struct node *ptr2;
	ptr=header;
	if(ptr->rlink==NULL)
	printf("\nlist is empty");
	else
	{
		printf("\nenter the key");
		scanf("%d",&key);
		while(ptr->rlink!=NULL && ptr->data!=key)
		{
			ptr1=ptr;
			ptr=ptr->rlink;
		}
		if(ptr->data==key)
		{
			ptr2=ptr->rlink;
			ptr1->rlink=ptr2;
			ptr2->llink=ptr1;
		}
		else
		printf("\nkey ist found");
	}
}
void traverse()
{
	ptr=header;
	if(ptr->rlink==NULL)
	printf("\nlist is empty");
	else
	{
		while(ptr->rlink!=NULL)
		{
			ptr=ptr->rlink;
			printf("\n%d",ptr->data);
		}
	}
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
			printf("\n 8:traverse");
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
				case 8 :traverse();break;
				default :printf("\n wrong entry");
			}
		}
		return 0;
}
			
		
		
		
		
			
	
	