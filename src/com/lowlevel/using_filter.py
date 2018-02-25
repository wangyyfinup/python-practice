'''
Created on 2017年1月13日

@author: wangyanyan_b
'''
###########高阶函数filter
#filter也是接收一个函数和一个序列为参数，但是和map不同的是filter会把函数依次作用于每个元素，然后根据返回值是true还是false决定留下还是丢弃元素

def is_odd(n):
    return n % 2 == 1

print(list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15])));

##############
def not_empty(s):
    return s and s.strip()#strip() 方法用于移除字符串头尾指定的字符(默认为空格)。

print(list(filter(not_empty, ['A', '', 'B', None, 'C', '  ',' A'])));