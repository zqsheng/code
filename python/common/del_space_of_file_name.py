#encoding=utf-8
#delspaceoffilename.py
#删除文件名的空格
import os 
import sys
files = os.listdir(os.getcwd())
dir_path = os.getcwd()
j = ""
count = 0
for ico in files:
    #os.path.basename(ico)
    #print(ico)
    #print(str(ico).replace(" ",""))
    j += ">"
    count += 1
    os.rename(os.path.join(dir_path,ico),os.path.join(dir_path,str(ico).replace(" ","")))
    
    sys.stdout.write(str(int(count/len(files))*100) + "% ||"+ j + "->" + "\r")
    sys.stdout.flush()
