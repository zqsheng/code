import os
import time
exec_count = 100
cmds = [] 
cmds.append("tar -cPzf /opt/web.tar.gz /opt/web/ /opt/soft")
cmds.append("rm -f /opt/web.tar.gz")
for i in range(exec_count):
    for cmd in cmds:
        if os.system(cmd) != 0:
            break
        time.sleep(1)