'''
Created on 2017年1月13日

@author: wangyanyan_b
'''
from functools import reduce
def fn(x, y):
    return x * 10 + y
def char2num(s):
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]#取dict中key='13579'的value
print(reduce(fn, map(char2num, '13579')))#char类型的'13579'是可以迭代的

##################
#可以将上述函数整理成如下str2int函数
def str2int(s):
    def fn(x, y):
        return x * 10 + y
    def char2num(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    return reduce(fn, map(char2num, s))

######################3
#使用lambda函数进一步简化
def charTonum(s):
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]

def strToint(s):
    return reduce(lambda x, y: x * 10 + y, map(charTonum, s))