#include <stdlib.h>
#include <stdio.h>
#include "rbtree.h"

#define rb_parent(r)        ((r)->parent)
#define rb_color(r)         ((r)->color)
#define rb_is_red(r)        ((r)->color == RED)
#define rb_is_black(r)      ((r)->color== BLACK)
#define rb_set_black(r)     do { (r)->color = BLACK; } while (0)
#define rb_set_red(r)       do { (r)->color = RED; } while (0)
#define rb_set_parent(r,p)  do { (r)->parent = (p); } while (0)
#define rb_set_color(r,c)   do { (r)->color = (c); } while (0)


RBRoot* create_rbtree()
{
    RBRoot *root = (RBRoot *) malloc(sizeof(RBRoot));
    root->node = NULL;
    return root;
}

static Node* create_rbtree_node(Type key,Node *parent,Node *left,Node *right)
{
    Node* p;
    if((p = (Node *)malloc(sizeof(Node))) == NULL)
       return NULL;
    p->key = key;
    p->parent = parent;
    p->left = left;
    p->right = right;
    p->color = BLACK; //default black
    return p;
}

static void rbtree_insert(RBRoot *root,Node *node)
{
    Node *y = NULL;
    Node *x = root->node;
    while (x != NULL)
    {
        y = x;
        if(node->key < x->key)
            x = x->left;
        else
            x = x->right;
    }
    rb_parent(node) = y;
    if (y != NULL)
    {
        if(node->key < y->key)
            y->left = node;
        else
            y->right = node;
    }
    else
    {
        root->node = node;
    }
    node->color = RED;
    //rbtree_insert_fixup(root,node);
}

int insert_rbtree(RBRoot *root,Type key)
{
    Node * node;
    if ((node = create_rbtree_node(key,NULL,NULL,NULL) == NULL))
        return FAILED;
    rbtree_insert(root,node);
    return SUCCESS;
}



static void preorder(RBTree tree)
{
    if(tree != NULL)
    {
        printf("%d  ",tree->key);
        preorder(tree->left);
        preorder(tree->right);
    }
}

void preorder_rbtree(RBRoot *root)
{
    if(root)
        preorder(root->node);
}
