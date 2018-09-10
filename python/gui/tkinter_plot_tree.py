import tkinter
# test tkinter whether available
# tkinter._test()
import sys,random,math
class Point(object):
    def __init__(self,x,y):
        self.x = x
        self.y = y
    def __str__(self):
        return "<Point>:(%f,%f)" % (self.x,self.y)
class Branch(object):
    def __init__(self,bottom,top,branchs,level=0):
        self.bottom = bottom
        self.top = top
        self.branchs = branchs
        self.level = level
        self.children = []
    def __str__(self):
        pass    

