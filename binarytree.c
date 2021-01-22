#include <stdio.h>
#include <stdlib.h>

struct node {
  int item;
  struct node* left;
  struct node* right;
};
void traversal(struct node* root) 
{
  if (root == NULL) return;
  printf("%d ->", root->item);
  traversal(root->left);
  traversal(root->right);
}
struct node* new(value)
 {
  struct node* newnode = malloc(sizeof(struct node));
  newnode->item = value;
  newnode->left = NULL;
  newnode->right = NULL;

  return newnode;
}
struct node* insertleft(struct node* root, int value) 
{
  root->left = new(value);
  return root->left;
}
struct node* insertright(struct node* root, int value) 
{
  root->right = new(value);
  return root->right;
}

int main() {
  struct node* root = new(1);
  insertleft(root, 12);
  insertright(root, 9);

  insertleft(root->left, 5);
  insertright(root->left, 6);

  printf(" traversal \n");
  traversal(root);

}
	
