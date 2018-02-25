'''
Created on 2017年1月23日

@author: wangyanyan_b
'''
class Student(object):
    pass
s=Student()
s.name='mike'#动态给实例绑定属性
print(s.name)

def set_age(self,age):
    self.age=age

from types import MethodType   
s.set_age = MethodType(set_age, s) # 给实例绑定一个方法
s.set_age(21)
print(s.age)

s2=Student()
#s2.set_age(23)#给一个实例绑定的方法，对另一个实例是不起作用的

def set_score(self,score):
    self.score=score
Student.set_score=set_score
s.set_score(100)
s2.set_score(120)
print('s de score is: %s' % s.score)
print('s2 de score is: %s' % s2.score)
