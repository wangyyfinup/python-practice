'''
Created on 2017年2月3日

@author: wangyanyan_b
'''
# pickle（除了最早的版本外）是二进制格式的，所以你应该带 'b' 标志打开文件。
# 以rb模式打开，打印出来是字节码。
# 以r模式打开，并设置编码方式为utf-8,可以将中文打印出来。
from _io import open
try:
    f = open('test', 'r', encoding='utf-8')
    print(f.read())
finally:
    if f:
        f.close()

# #######################不用try-except方式
with open('test', 'r', encoding='utf-8') as f:
    print(f.read())
############################逐行读取,遇到编码错误忽略
try:
    f2 = open('../../test2', 'r', encoding='utf-8', errors='ignore')
    for line in f2.readlines():
        print(line.strip())
finally:
    if f2:
        f2.close()
        
####################读取二进制文件,用rb方式
f3 = open('Penguins.jpg', 'rb')
##################################写文件
try:
    f4 = open('../../test3', 'w', encoding='utf-8', errors='ignore')
    f4.write('string.')
finally:
    if f4:
        f4.close()

