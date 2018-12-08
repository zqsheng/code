import os
import re

path = os.getcwd()
pattern = re.compile(r'\w{1,}\.CAM')
target = "CAM"
for f in os.listdir(path):
    if os.path.isfile(f) and re.findall(r'\.sql',f):
        file_data = ""
        with open(f,"r") as file:
            for line in file.readlines():
               file_data += re.sub(pattern,line,target)
        with open(f,"w") as file:
            file.write(file_data)                