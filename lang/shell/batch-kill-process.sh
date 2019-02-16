#!/bin/bash
ps -ef | grep $1 | grep -v grep | awk '{print "kill -9 " $2}' | sh  
#ps -aux | grep $1 | cut -c 9-15 | xargs kill -9 
