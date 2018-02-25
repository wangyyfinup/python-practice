'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
from io import BytesIO
f = BytesIO()
f.write('你好啊啊啊啊'.encode('utf-8'))
print(f.getvalue())

f2 = BytesIO(b'\xe4\xbd\xa0\xe5\xa5\xbd\xe5\x95\x8a\xe5\x95\x8a\xe5\x95\x8a\xe5\x95\x8a')
print(f2.read())
