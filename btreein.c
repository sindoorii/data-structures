#include <stdio.h>
#include <stdlib.h>

#define MAX 3
#define MIN 2

struct btree
{
  int item[MAX + 1], count;
  struct btree *linker[MAX + 1];
};

struct btree *root;
 {
  struct BTreeNode *newnode;
  newnode = (struct btree *)malloc(sizeof(struct btree));
  newnode->item[1] = item;
  newnode->count = 1;
  newnode->linker[0] = root;
  newnode->linker[1] = child;
  return newode;
}
void addValToNode(int item, int pos, struct btree *node, struct btree *child)
 {
  int j = node->count;
  while (j > pos) {
    node->item[j + 1] = node->item[j];
    node->linker[j + 1] = node->linker[j];
    j--;
  }
  node->item[j + 1] = item;
  node->linker[j + 1] = child;
  node->count++;
}
void splitNode(int item, int *pval, int pos, struct btree *node,struct btree *child, struct btree **newnode) 
  {
  int median, j;

  if (pos > MIN)
    median = MIN + 1;
  else
  median = MIN;

  *newnode = (struct btree *)malloc(sizeof(struct btree));
  j = median + 1;
  while (j <= MAX) 
  {
    (*newnode)->item[j - median] = node->item[j];
    (*newnode)->linker[j - median] = node->linker[j];
    j++;
  }
  node->count = median;
  (*newnode)->count = MAX - median;

  if (pos <= MIN)
   {
    addValToNode(item, pos, node, child);
  }
   else
    {
    addValToNode(item, pos - median, *newnode, child);
  }
  *pval = node->item[node->count];
  (*newnode)->linker[0] = node->linker[node->count];
  node->count--;
}
int setValueInNode(int item, int *pval, struct btree *node, struct btree **child) 
{
  int pos;
  if (!node) 
  {
    *pval = item;
    *child = NULL;
    return 1;
  }

  if (item < node->item[1])
   {
    pos = 0;
  }
   else 
   {
    for (pos = node->count;
       (item < node->item[pos] && pos > 1); pos--);
    if (item == node->item[pos])
     {
      printf("Duplicates not allowed\n");
      return 0;
    }
  }
  if (setValueInNode(item, pval, node->linker[pos], child)) 
  {
    if (node->count < MAX)
     {
      addValToNode(*pval, pos, node, *child);
    } 
    else
     {
      splitNode(*pval, pval, pos, node, *child, child);
      return 1;
    }
  }
  return 0;
}
void insertion(int item)
 {
  int flag, i;
  struct btree *child;
  flag = setValueInNode(item, &i, root, &child);
  if (flag)
  {
    root = createNode(i, child);
}
}
void copySuccessor(struct btree *myNode, int pos) 
{
  struct btree *dummy;
  dummy = myNode->linker[pos];

  for (; dummy->linker[0] != NULL;)
    dummy = dummy->linker[0];
  myNode->item[pos] = dummy->item[1];
}
void removeval(struct btree *myNode, int pos) 
{
  int i = pos + 1;
  while (i <= myNode->count) 
  {
    myNode->item[i - 1] = myNode->item[i];
    myNode->linker[i - 1] = myNode->linker[i];
    i++;
  }
  myNode->count--;
}

void rightShift(struct btree *myNode, int pos)
 {
  struct btree *x = myNode->linker[pos];
  int j = x->count;
  while (j > 0)
   {
    x->item[j + 1] = x->item[j];
    x->linker[j + 1] = x->linker[j];
  }
  x->item[1] = myNode->item[pos];
  x->linker[1] = x->linker[0];
  x->count++;
  x = myNode->linker[pos - 1];
  myNode->item[pos] = x->item[x->count];
  myNode->linker[pos] = x->linker[x->count];
  x->count--;
  return;
}
void leftShift(struct btree *myNode, int pos) 
{
  int j = 1;
  struct btree *x = myNode->linker[pos - 1];
  x->count++;
  x->item[x->count] = myNode->item[pos];
  x->linker[x->count] = myNode->linker[pos]->linker[0];
 x = myNode->linker[pos];
  myNode->item[pos] = x->item[1];
  x->linker[0] = x->linker[1];
  x->count--;
  while (j <= x->count)
   {
    x->item[j] = x->item[j + 1];
    x->linker[j] = x->linker[j + 1];
    j++;
  }
  return;
}
void mergeNodes(struct btree *myNode, int pos) {
  int j = 1;
  struct btree *x1 = myNode->linker[pos], *x2 = myNode->linker[pos - 1];
 x2->count++;
  x2->item[x2->count] = myNode->item[pos];
  x2->linker[x2->count] = myNode->linker[0];
 while (j <= x1->count)
  {
    x2->count++;
    x2->item[x2->count] = x1->item[j];
    x2->linker[x2->count] = x1->linker[j];
    j++;
  }
   j = pos;
  while (j < myNode->count) 
  {
    myNode->item[j] = myNode->item[j + 1];
    myNode->linker[j] = myNode->linker[j + 1];
    j++;
  }
  myNode->count--;
  free(x1);
}
void adjustNode(struct btree *myNode, int pos)
 {
  if (!pos) 
  {
    if (myNode->linker[1]->count > MIN) {
      leftShift(myNode, 1);
    } else {
      mergeNodes(myNode, 1);
    }
  } 
  else {
    if
     (myNode->count != pos) {
      if (myNode->linker[pos - 1]->count > MIN) {
        rightShift(myNode, pos);
      }
       else
        {
        if (myNode->linker[pos + 1]->count > MIN) {
          leftShift(myNode, pos + 1);
        } else {
          mergeNodes(myNode, pos);
        }
      }
    } 
    else 
    {
      if (myNode->linker[pos - 1]->count > MIN)
        rightShift(myNode, pos);
      else
        mergeNodes(myNode, pos);
    }
  }
}
int delete (int item, struct btree *myNode)
 {
  int pos, flag = 0;
  if (myNode)
   {
    if (item < myNode->item[1]) {
      pos = 0;
      flag = 0;
    } 
    else
     {
      for (pos = myNode->count; (item < myNode->item[pos] && pos > 1); pos--)
      if (item == myNode->item[pos]) 
      {
        flag = 1;
      }
       else
        {
        flag = 0;
      }
    }
    if (flag) 
    {
      if (myNode->linker[pos - 1]) 
      {
        copySuccessor(myNode, pos);
        flag = delete(myNode->item[pos], myNode->linker[pos]);
        if (flag == 0) 
        {
          printf("Given data is not present in B-Tree\n");
        }
      } 
      else 
      {
        removeval(myNode, pos);
      }
    }
     else 
     {
      flag = delete(item, myNode->linker[pos]);
    }
    if (myNode->linker[pos]) 
    {
      if (myNode->linker[pos]->count < MIN)
        adjustNode(myNode, pos);
    }
  }
  return flag;
}
void deletion(int item, struct btree *myNode)
 {
  struct btree *tmp;
  if (!delete(item, myNode)) 
  {
    printf("Not present\n");
    return;
  } 
  else 
  {
    if (myNode->count == 0) {
      tmp = myNode;
      myNode = myNode->linker[0];
      free(tmp);
    }
  }
  root = myNode;
  return;
}

void searching(int item, int *pos, struct btree *myNode) {
  if (!myNode)
   {
    return;
  }

  if (item < myNode->item[1]) {
    *pos = 0;
  } else {
    for (*pos = myNode->count;
       (item < myNode->item[*pos] && *pos > 1); (*pos)--)
      ;
    if (item == myNode->item[*pos]) {
      printf("%d present in B-tree", item);
      return;
    }
  }
  searching(item, pos, myNode->linker[*pos]);
  return;
}

void traversal(struct btree *myNode) {
  int i;
  if (myNode) 
  {
    for (i = 0; i < myNode->count; i++) {
      traversal(myNode->linker[i]);
      printf("%d ", myNode->item[i + 1]);
    }
    traversal(myNode->linker[i]);
  }
}

int main()
 {
  int m,n,i;
printf("enter the limit");
scanf("%d",&n);
printf("enter items");
for(i=0;i<n;i++)
{
	scanf("%d",&m);
  insertion(m);
}
traversal(root);
printf("enter item to be delete");
scanf("%d",&m);
 deletion (m, root);
  printf("\n");
  traversal(root);
}
