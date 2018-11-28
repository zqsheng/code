#!/bin/bash
# calc.sh
i=0;
while [ $i -lt 1000 ]
do 
	$i = $i + $i
done
echo $i
exit
