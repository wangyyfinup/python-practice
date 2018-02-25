'''
Created on 2016年12月21日

@author: wangyanyan_b
'''
def sayhello():
    '''this is docs'''
    print('hello world!')
    pass
    return "one"
version='1.0.0'
print (sayhello())
print (sayhello.__doc__)
print (sayhello.__name__)