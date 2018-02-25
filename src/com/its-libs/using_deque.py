'''
Created on 2017年2月6日

@author: wangyanyan_b
'''
from collections import deque
# deque是为了高效实现插入和删除操作的双向列表，适合用于队列和栈
q = deque(['x', 'y', 'z'])
q.append('a')
q.appendleft('b')

print(q)

q.pop()
print(q)
q.popleft()
print(q)
