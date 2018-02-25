'''
Created on 2017年1月20日

@author: wangyanyan_b
'''
class Student(object):
    name='Student'
    def __init__(self,name):
        self.name=name;
    
s=Student('Bob')
print(s.name)
print(Student.name)

del s.name
print(Student.name)
