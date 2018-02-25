'''
Created on 2017年2月3日

@author: wangyanyan_b
'''
# Python 所有的错误都是从BaseException类派生的，常见的错误类型和继承关系看这里：
#https://docs.python.org/3/library/exceptions.html#exception-hierarchy
#logging可以打印错误，并使程序继续执行至结束
try:
    print('try...')
    r = 10 / 0
    print('result:', r)
except ZeroDivisionError as e:
    print('except:', e)
finally:
    print('finally...')
print('END')

print('##############################')

try:
    print('try...')
    r = 10 / int('2')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
else:
    print('no error!')
finally:
    print('finally...')
print('END')