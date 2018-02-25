'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
# 对象从内存写入磁盘或者网络称之为序列化
# 对象从磁盘读入内存称之为反序列化
# Python提供pickle模块进行序列化
import pickle
# 序列化
f = open('test', 'wb')
pickle.dump('te34545st', f)
f.close()


# 反序列化
f2 = open('test', 'rb')
d = pickle.load(f2)
f2.close()
print(d)
