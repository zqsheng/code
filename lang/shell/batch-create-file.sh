#!/bin/bash

path='/root/Workspace/shell_scripts/temp'
cd $path
count=10
for i in $(seq 1 $count)
do 
	touch "file_$i.txt"
done
