'''
Created on 2017年1月17日

@author: wangyanyan_b
'''
#继承
class animal(object):
    def run(self):
        print("animal is running")
        
class dog(animal):
    pass
    
class cat(animal):
    def run(self):
        print("cat is running")
        
'''       
a=animal()
a.run()
d=dog()
d.run()
c=cat()
c.run()
print('######################')

a=c
a.run()

d=c
d.run()

c=d
c.run()


'''