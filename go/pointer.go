package main
import "fmt"
func main(){
	var a int = 0
	var ip *int
	ip = &a
	fmt.Println(ip)
	fmt.Println(&a)
	fmt.Println(*ip)
	var sp *string
	//fmt.Println(*sp)
	fmt.Println(sp)
}
