'''
Created on 2016年12月23日

@author: wangyanyan_b
'''
class person:
    population = 0
    def __init__(self, name):  # 新建对象的时候调用
        self.name = name
        person.population += 1
    def __del__(self):  # 对象消逝的时候调用
        person.population -= 1
        if person.population == 0:
            print('I`m the last one')
        else:
            print('we have %s people' % person.population)
    def say(self):
        print('hello ' + self.name)


class child(person):
    def __init__(self, name, color):
        self.color = color;
        person.__init__(self, name)
    def show(self):
        print('this child is %s' % self.color)
        print('this child\'s name is %s' % self.name)
   

'''
p = person('wang')
p.say()

k = person('liu')
k.say()
# print(p.say('wyy'))
        
c = child('baby', 'red')
c.say()
c.show()
  '''  
