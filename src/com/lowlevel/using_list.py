'''
Created on 2016年12月21日

@author: wangyanyan_b
'''
list=['a','c','e','b','d','f']
print(list)
print('list has',len(list),'items')
list.sort()
list.append('g')
for item in list:
    print(item)
del list[0]
print(list)