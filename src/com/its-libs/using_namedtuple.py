'''
Created on 2017年2月6日

@author: wangyanyan_b
'''
from collections import namedtuple
point = namedtuple('Point', ['x', 'y'])
p = point(3, 2)
print(p.x)
print(p.y)

print(isinstance(p, point))
print(isinstance(p, tuple))