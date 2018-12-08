#include <stdio.h>
#include "rbtree.h"

#define LENGTH(a)   ((sizeof(a) / sizeof(a[0])))

void main()
{
    int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    int i, ilen=LENGTH(a);
    RBRoot *root = NULL;
    RBRoot *left = NULL;
    root = create_rbtree();
    printf("address:%p\n",root->node);
    printf("size of %d\n",sizeof(RBRoot));
    insert_rbtree(root,a[0]);
}

