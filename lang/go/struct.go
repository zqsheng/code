package main
import "fmt"
type Books struct{
	title string
	author string
	subject string
	bookId int
}
func main(){
	var book1 Books
	var book2 Books
	book1.title = "go language"
	fmt.Println(book1.title)
	fmt.Println(book2.title)
}
