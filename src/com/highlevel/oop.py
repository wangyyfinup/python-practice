'''
Created on 2017年1月17日

@author: wangyanyan_b
'''
class Student(object):
    def __init__(self,name,score):
        self.name=name
        self.score=score
        
    def print_score(self):
        print('%s:%s' % (self.name,self.score))
a=Student('Lily',80)
b=Student('Tom',90)
a.print_score()
b.print_score()
    
#####################################################
class Student2(object):
    def __init__(self,name,score):
        self.__name=name
        self.__score=score
    
    def get_name(self):
        return self.__name;
    def get_score(self):
        return self.__score;
    
    def set_name(self,modified__name):
        self.__name=modified__name;
    def set_score(self,modified__score):
        self.__score=modified__score;   
             
    def print_score(self):
        print('%s:%s' % (self.__name,self.__score))
        
a=Student2('Lily2',80)
b=Student2('Tom2',90)
a.print_score()
b.print_score()  
a.set_name('aaa')    
print(a.get_name())  


a.__name='NewName'
print('a.__name=: %s' % a.__name)
print(a.get_name())
print('a.name=:%s' % a.get_name())#不能直接访问__name是因为Python解释器对外把__name变量改成了_Student__name