'''
Created on 2017年1月13日

@author: wangyanyan_b
'''
###########高阶函数map
#map()函数接收两个参数,一个是函数,一个是序列,map将传入的函数依次作用到序列的每个元素,并把结果作为新的list返回

def f(x):
    return x*x;
r=map(f,[1,2,3,4,5,6,7,8,9])
print(list(r))
##########################
print(list(map(str,[1,2,3,4,5,6])))

#################高阶函数reduce
'''reduce把一个函数作用在一个序列[x1, x2, x3, ...]上，这个函数必须接收两个参数，reduce把结果继续和序列的下一个元素做累积计算，其效果就是：

reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)
'''
from functools import reduce;
def add(a,b):
    return a+b;
print(reduce(add,[1,2,3,4,5]))
#reduce函数的计算结果等于如下函数计算的结果
print(add(add(add(add(1,2),3),4),5))
#################################

