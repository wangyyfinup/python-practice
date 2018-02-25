'''
Created on 2017年1月10日

@author: wangyanyan_b
'''
def return_more(x,y):
    x=x+3;
    y=y-3;
    return x,y;
print(return_more(4, 2));
#############################
def kong():
    pass

print(kong());

##############################
def paramm(n=2):####必选参数在前，默认参数在后.默认参数必须指向不变对象！
    n=n-1
    return n;
print(paramm(5));
print(paramm(8));
print(paramm());
#############################
def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    return L
print(add_end());
#############################
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
nums = [1, 2, 3];
print(calc(*nums));#1+4+9
###################################
def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)
    return
person('Adam', 45, gender='M', job='Engineer');

##########################################

def person1(name,age,*,city,job):
    print(name ,age ,city ,job )
    return
person1('wyy', '11',city='beijing',job='tester');