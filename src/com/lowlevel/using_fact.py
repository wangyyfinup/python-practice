'''
Created on 2017年1月10日
函数递归
@author: wangyanyan_b
'''
def fact(n):
    if(n==1):
        return 1;
    else:
        return n*fact(n-1);
print(fact(5));

##############################
def fact2(n):#######
    return fact_iter(n, 1)

def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)
print(fact2(5));
#################################

# 利用递归函数移动汉诺塔:
def move(n, a, b, c):
    if n == 1:
        print('move', a, '-->', c)
        return
    move(n-1, a, c, b)
    print('move', a, '-->', c)
    move(n-1, b, a, c)

move(4, 'A', 'B', 'C')