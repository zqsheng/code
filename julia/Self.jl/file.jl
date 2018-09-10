#julia fileio
#function
#   isdir,isfile
path = "C:\\Users\\admin\\Desktop\\Scritps\\julia\\Self.jl\\function.jl"
print(isdir(path))
print(isfile(path))
file = open(path)
typeof(file)

close(file)
