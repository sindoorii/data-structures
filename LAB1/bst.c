#include<stdio.h>
#include<stdlib.h>
struct treenode
{
	struct treenode *left;
	struct treenode *right;
	int data;
};
struct treenode *root=NULL;
struct treenode *cnode(int data)
{
	struct treenode *newnode;
	newnode=(struct treenode *)malloc(sizeof(struct treenode));
	newnode->data=data;
	newnode->left=NULL;
	newnode->right=NULL;
	return newnode;
}
void insert(struct treenode **node,int data)
{
	if(*node==NULL)
	*node=cnode(data);
	else if(data<(*node)->data)
	insert(&((*node)->left),data);
	else
	insert(&((*node)->right),data);
}
void delete(struct treenode **node,struct treenode **parent,int data)
{
	struct treenode *tmpnode,*tmpparent;
	if(*node==NULL)
	printf("\nempty");
	if((*node)->data==data)
	{
		if(!(*node)->left && !(*node)->right)
		{
			if(parent)
			{
			if((*parent)->left==*node)
			(*parent)->left=NULL;
			else
			(*parent)->right=NULL;
			free(*node);
		}
		else
		{
			free(*node);
		}
	}
	else if(!(*node)->right && (*node)->left)
	{
		tmpnode=*node;
		(*parent)->right=(*node)->left;
		free(tmpnode);
		*node=(*parent)->right;
	}
	else if((*node)->right&&!(*node)->left)
	{
		tmpnode=*node;
		(*parent)->left=(*node)->right;
		free(tmpnode);
		*node=(*parent)->left;
	}
	else
	{
		tmpnode=(*node)->right;
		while(tmpnode->left)
		{ 
			tmpparent=tmpnode;
			tmpnode=tmpnode->left;
		}
		tmpparent->left=tmpnode->right;
		tmpnode->left=(*node)->left;
		tmpnode->right=(*node)->right;
		free(*node);
		*node=tmpnode;
	}}
	else if(data<(*node)->data)
	{
		delete(&(*node)->right,node,data);
	}
	else
	{
		delete(&(*node)->left,node,data);
	}
}
void traverse(struct treenode *node)
{
	if(node!=NULL)
	{
		traverse(node->left);
		printf("%d",node->data);
		traverse(node->right);
	}
}
int main()
{
	int data,ch;
	while(1)
	{
		printf("\n1:insertion\n2:deletion\n3:traverse\n4:exit\nenter the choice");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 :while(1)
					{
						printf("\nenter the data");
						scanf("%d",&data);
						insert(&root,data);
						printf("\ncontinue insertion(0/1)");
						scanf("%d",&ch);
						if(!ch)
						break;
					}
					break;
				case 2 :printf("\nenter the data");
						scanf("%d",&data);
						delete(&root,NULL,data);
						break;
				case 3 :printf("\ntraversel");
						traverse(root);
						break;
				case 4 :exit(0);break;
			}
		}
	}


	

		