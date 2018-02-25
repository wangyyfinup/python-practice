'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
from io import StringIO
# 从stringIOS写文件
f = StringIO()
f.write('hello ')
f.write(',')
f.write('world')
f.write('!')
print(f.getvalue())
# 从stringIOS读文件

f2 = StringIO('Hello!\nhi!')
while True:
    s = f2.readline()
    if s == '':
        break
    print(s.strip())
