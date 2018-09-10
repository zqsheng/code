# this is a annotation
#definiton a function 
#only use in console
#v(x) = (print(x);x)
#v(x)
function f(x,y)
    x + y
end
print(f(3,2))
print("\n")
print(typeof(f))
#type limit
function func(x::Int,explaintion::String)
    print(x)
    print(explaintion)
    # this is return value
    x
end
func(3,"fdsf")
#throw error
#func("fsdf",3)