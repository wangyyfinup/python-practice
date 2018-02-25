'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
import json
from com.lowlevel.using_class import child
d = child('wyy', 'red')


def child2dict(child):  # 解决is not JSON serializable
    return {
    'name': child.name,
    'color': child.color,
    }
        
print(json.dumps(d, default=child2dict))
# dumps()方法返回一个str，内容就是标准的JSON。类似的，dump()方法可以直接把JSON写入一个file-like Object。


json_str = '{"name":"zhan", "color":"88"}'  # value值也得加双引号

def dict2child(d):
    return child(d['name'], d['color'])

print(json.loads(json_str, object_hook=dict2child))
