'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
import os
# 使用OS查看系统和环境变量等
print(os.uname_result)
print(os.environ)
print(os.environ.get('PATH'))

# 使用OS操作文件和目录
print(os.path.abspath('.'))
print(os.path.join('.', 'path'))  # 把两个路径合成一个时，不要直接拼字符串，而要通过os.path.join()函数，这样可以正确处理不同操作系统的路径分隔符。
# os.mkdir('test-dir')
# os.rmdir('test-dir')
print(os.path.split('/users/wyy/123.txt'))
print(os.path.splitext('/users/wyy/123.txt'))
os.renames('OOP.py', 'oop.py')
'''
os.remove('test.py')
shutil模块提供了copyfile()的函数
[x for x in os.listdir('.') if os.path.isdir(x)]# 列出所有目录
[x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1]=='.py']#列出所有.py文件
'''
