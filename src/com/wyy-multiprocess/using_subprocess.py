'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
import subprocess

print('$ nslookup www.python.org')
r = subprocess.call(['nslookup', 'www.python.org'])
print('Exit code:', r)