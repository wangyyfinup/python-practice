'''
Created on 2017年1月12日

@author: wangyanyan_b
'''
def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'

f = fib(10)

for x in f:
    print(x)
