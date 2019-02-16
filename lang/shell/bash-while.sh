#!/bin/bash

i=1
while true 
do
     let k=$i*2	
     echo "$k"
     let "i++"
     sleep 0.5
done
