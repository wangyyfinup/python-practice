'''
Created on 2016年12月21日

@author: wangyanyan_b
'''
tuple = ('a','b','c','d')
print(tuple)
print(tuple[2])
print('the first is %s,the second is %s' % ('ss','tt'))

##########################3
##using_dict
##using_xulie
#########################
#using_slice
L=list(range(100));
print(L[:])
print(L[1:3])
print(L[:3])
print(L[-10:])
print(L[-10::2])
print(L[::5])

#########################
print([x * x for x in range(1, 11)])
print([x * x for x in range(1, 11) if x%2==0])

