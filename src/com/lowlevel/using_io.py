'''
Created on 2016年12月23日

@author: wangyanyan_b
'''
poem='''Programming is fun\\r
When the work is done\\r
if you wanna make your work also fun: \\r
use Python!'''
f=open('data.txt','w')
f.write(poem)
f.close()

f=open('data.txt','r')

while True:
    line=f.read()
    if len(line)==0:
        break
    print(line+'\n')
f.close    