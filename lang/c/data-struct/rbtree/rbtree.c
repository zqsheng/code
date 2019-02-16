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
    if(p = (Node *)malloc(sizeof(Node)) == NULL)
       return NULL;
    p->key = key;
    p->parent = parent;
    p->left = left;
    p->right = right;
    p->color = BLACK; //default black
    return p;
}


static void rbtree_left_rotate(RBRoot *root,Node *x)
{
    Node *y = x->right;
    x->right = y->left;
    if(y->left != NULL)
    {
        y->left->parent = x;
    }
    y->parent = x->parent;
    if(x->parent == NULL)
    {
        root->node = y;
    }
    else
    {
        if(x->parent->left == x)
        {
            x->parent->left = y;
        }
        else
        {
            x->parent->right = y;
        }
    }
    y->left = x;
    y->parent = y;
}

static void rbtree_right_rorate(RBRoot *root,Node *y)
{
    Node *x = y->left;
    y->left = x->right;
    if(x->right != NULL)
        x->right->parent = y;
    x->parent = y->parent;
    if(y->parent == NULL)
    {
        root->node = x;
    }
    else
    {
        if(y == y->parent->right)
        {
            y->parent->right = x;
        }
        else
        {
            y->parent->left = x;
        }
    }
    x->right = y;
    y->parent = x;
}

static void rbtree_insert_fixup(RBRoot *root,Node *node)
{
    Node *parent,*gparent;
    while ((parent = rb_parent(node) && rb_is_red(parent)))
    {
        gparent = rb_parent(parent);
        if(parent == gparent->left)
        {
            Node *uncle = gparent->right;
            if (uncle && rb_is_red(uncle))
            {
                rb_set_black(uncle);
                rb_set_black(parent);
                rb_set_red(gparent);
                node = gparent;
                continue;
            }
        }
        if(parent->right == node)
        {
            Node *tmp;
            rbtree_left_rotate(root,parent);
            tmp = parent;
            node = tmp;
        }
        rb_set_black(parent);
        rb_set_red(gparent);
        rbtree_right_rorate(root,gparent);
    }
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
    rbtree_insert_fixup(root,node);
}

int insert_rbtree(RBRoot *root,Type key)
{
    Node * node;
    if (((node = create_rbtree_node(key,NULL,NULL,NULL)) == NULL))
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
