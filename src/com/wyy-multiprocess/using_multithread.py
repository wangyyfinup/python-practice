'''
Created on 2017年2月4日

@author: wangyanyan_b
'''
import time, threading

# 新线程执行的代码:
def loop():
    print('2.thread %s is running...' % threading.current_thread().name)
    n = 0
    while n < 5:
        n = n + 1
        print('thread %s >>> %s' % (threading.current_thread().name, n))
        time.sleep(1)
    print('thread %s ended.' % threading.current_thread().name)

print('1.thread %s is running...' % threading.current_thread().name)
t = threading.Thread(target=loop, name='LoopThread')  # 给子线程命名，如果不命名，默认为Thread-1..........
t.start()
t.join()
print('thread %s ended.' % threading.current_thread().name)
