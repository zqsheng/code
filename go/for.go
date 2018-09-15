package main
import "fmt"
func main(){
	var b int = 15
	var a int 
	numbers := [6]int{1,2,3,4}
	for a := 0;a <10;a++{
		fmt.Println(a)
	}
	for a < b{
		a ++
		fmt.Println(a)
	}	
	for i,x := range numbers{
		fmt.Println(i,x)
	}
}
