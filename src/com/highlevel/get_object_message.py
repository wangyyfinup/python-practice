'''
Created on 2017年1月20日

@author: wangyanyan_b
'''
import os
import com.highlevel.inherent as Animal##会把inherent先执行一遍，会把inherent包中的也打印出来
from com.highlevel.inherent import dog, animal
a=Animal.cat()
a.run()
print(type(a))
print(type(12345))
print(type('123'))
print(type("abc"))
print(type(None))
print(type(os.curdir))
print(type(abs))
print("#########################")
anmal=Animal.animal()
ccat=Animal.cat()
ddog=Animal.dog()
print("is anmal an instance of dog:%s" % isinstance(anmal, dog))
print("is ddog an instance of anmal:%s" % isinstance(ddog, animal))#第二个参数应该是一个类型，而不是某个类型的对象
print("is ccat an instance of anmal:%s" % isinstance(ccat, animal))

print(isinstance(123, int))
