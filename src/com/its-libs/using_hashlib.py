'''
Created on 2017年2月6日

@author: wangyanyan_b
'''
import hashlib
md5 = hashlib.md5()
md5.update('how to use md5 in python hashlib ?'.encode(encoding='utf_8', errors='strict'))
print(md5.hexdigest())



sha1 = hashlib.sha1()
sha1.update('how to use sha1 in '.encode('utf-8'))
sha1.update('python hashlib?'.encode('utf-8'))
print(sha1.hexdigest())
