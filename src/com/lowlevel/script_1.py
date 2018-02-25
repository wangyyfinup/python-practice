'''
Created on 2016年12月22日

@author: wangyanyan_b
'''
import os
import time

target='/HelloWorld/src/com/wyy/'+time.strftime('H%M%S')+'.zip'
print(target)

source='/HelloWorld/src/com/wyy/script_1.py'

zip_command="zip -qr '%s' %s" % (target,''.join(source))

if os.system(zip_command)==0:
    print('backup success.')
else:
    print('backup fail.')