#ifndef RBTREE_H_INCLUDED
#define RBTREE_H_INCLUDED

#define RED         0
#define BLACK       1
#define FAILED      -1
#define SUCCESS     0


typedef int Type;

typedef struct RBTreeNode{

    unsigned char color;
    Type key;
    struct RBTreeNode *left;
    struct RBTreeNode *right;
    struct RBTreeNode *parent;

} Node,*RBTree;


typedef struct rb_root{
    Node *node
} RBRoot;

RBRoot* create_rbtree();

void destroy_rbtree();

int insert_rbtree(RBRoot *root,Type type);

void delete_rbtree(RBRoot *root,Type type);

void preorder_rbtree(RBRoot *root);

void inorder_rbtree(RBRoot *root);
#endif // RBTREE_H_INCLUDED
