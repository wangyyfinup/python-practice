'''
Created on 2017年1月23日

@author: wangyanyan_b
'''
class Student(object):

    @property
    def birth(self):
        return self._birth

    @birth.setter
    def birth(self, value):
        self._birth = value

    @property
    def age(self):
        return 2017 - self._birth
    
s=Student()
s.birth=1990
print(s.birth)
print(s.age)