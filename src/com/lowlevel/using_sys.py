'''
Created on 2016年12月21日

@author: wangyanyan_b
'''
import sys
print ('the following is command line param：')
for i in sys.argv:
 print ('sys.argv--',i)

print('the python path is ',sys.path,'\n')
dir(sys)