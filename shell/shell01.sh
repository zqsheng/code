#!/bin/bash
#assign
a="hello world"
#print
printf '%s\n' "A is : $a"


num=2
echo "this is the $num nd"
echo "this is the $numnd"
echo "this is the ${num}nd"
echo "this is the {$num}nd"


var=1
var=$var+1
echo $var


var=0
(( var += 1 ))
((var++))
((var=var * var))
let 'var = var / 3'
echo $((var += 2))
var=$((var-1))

