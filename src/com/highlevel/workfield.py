'''
Created on 2017年1月17日

@author: wangyanyan_b
'''
#使用_定义private函数，允许被访问的函数定义为public类型
#在Python中，实例的变量名如果以__开头，就变成了一个私有变量（private），只有内部可以访问，外部不能访问，
#以双下划线开头，并且以双下划线结尾的，是特殊变量，特殊变量是可以直接访问的，不是private变量，所以，不能用__name__、__score__这样的变量名。
def _private_1(name):
    return 'Hello, %s' % name

def _private_2(name):
    return 'Hi, %s' % name

def greeting(name):
    if len(name) > 3:
        return _private_1(name)
    else:
        return _private_2(name)
print(greeting("wyy"))

# import sys
#安装第三方的库pip install XXXX
import sys
sys.path.append('/Users/michael/my_py_scripts')
print(sys.path)