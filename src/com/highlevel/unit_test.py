'''
Created on 2017年2月3日

@author: wangyanyan_b
'''
##TypeError: 'module' object is not callable for python object 遇到这个问题是因为包名和类名重复了。
import unittest
from com.myclass.mydict import Dict
class TestDict(unittest.TestCase):
    def test_init(self):
        d=Dict(a=1,b='test')
        print(self.assertEqual(d.a,1))
        print(self.assertEqual(d.b, 'test'))
        print(self.assertIsInstance(d, Dict))
    def test_key(self):   
        d=Dict()
        d.key='value'
        self.assertEqual(d.key,'value')
    def test_attr(self):
        d = Dict()
        d.key = 'value'
        self.assertTrue('key' in d)
        self.assertEqual(d['key'], 'value')
    def test_keyerror(self):
        d = Dict()
        with self.assertRaises(KeyError):
            value = d['empty']

    def test_attrerror(self):
        d = Dict()
        with self.assertRaises(AttributeError):
            value = d.empty
        
if __name__ == '__main__':
    unittest.main()