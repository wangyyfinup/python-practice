'''
Created on 2017年2月6日

@author: wangyanyan_b
'''
from collections import Counter
c = Counter()

for ch in "program":
    c[ch] = c[ch] + 1

print(c)
