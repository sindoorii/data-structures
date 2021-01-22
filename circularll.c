#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *link;
};
struct node *root,*newnode;
void getnode()
{
	newnode=(struct node *)malloc(sizeof(struct node));
	printf("\n enter the data");
	scanf("%d",&newnode->data);
	newnode->link=NULL;
}
void insert()
{
	struct node *temp=root->link;
	if(temp==NULL)
	{
		getnode();
		temp->link=newnode;
		newnode->link=root;
	}
	else
	{
		while(temp->link!=root)
		{
			temp=temp->link;
		}
		getnode();
		temp->link=newnode;
		newnode->link=root;
	}
}
void delete()
{
	int k,f=0;
	struct node *temp=root->link,*ptr=temp;
	printf("\n enter the key");
	scanf("%d",&k);
	while(temp->link!=root)
	{
		ptr=temp;
		temp=temp->link;
		if(temp->data==k)
		{
			f=1;
			printf("\n element deleted");
			ptr->link=temp->link;
		}
	}
	if(f==0)
	printf("\n item not foud");
}
void traverse()
{
	struct node *temp=root->link;
	do
	{
		printf("\n%d",temp->data);
		temp=temp->link;
	}while(temp!=root);
}
	int  main()
{
	int n;
	while(1)
	{
		printf("\n1:insert");
		printf("\n2:delete");
		printf("\n3:traverse");
		printf("\n4:exit");
		printf("\n enter ur choice");
		scanf("%d",&n);
		switch(n)
		{
			case 1 :insert();break;
			case 2 :delete();break;
			case 3 :traverse();break;
			case 4 :exit(0);break;
			default :printf("\nwrong entry");
		}
	}
	return 0;
}

	

