'''
Created on 2017年2月6日

@author: wangyanyan_b
'''
from datetime import datetime, timedelta
from test.datetimetester import HOUR
t = datetime.now()
print(t)

dt = datetime(2015, 4, 19, 12, 20)  # 用指定日期时间创建datetime
print(dt)
tt = dt.timestamp()  # 把一个datetime类型转换为timestamp只需要简单调用timestamp()方法
print(tt) 
rt = datetime.fromtimestamp(tt)  # 要把timestamp转换为datetime，使用datetime提供的fromtimestamp()方法
print(rt)

# 字符串和时间相互转换
print(datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S'))
print(datetime.now().strftime('%a, %b %d %H:%M'))

# 日期加减
now = datetime.now()
print(now - timedelta(hours=1))
print(now - timedelta(days=2))
print(now - timedelta(hours=1, days=3))



