# coding:UTF-8
# 创建文本文件
# 导入os模块
import os
#给出当前平台使用的行终止符
ls = os.linesep

#输入文件名
while True:
    fname = raw_input()
    if os.path.exists(fname):
        print "ERROR:'%s' alredy exists" % fname
    else:
        break

#输入文件内容
all = []
print "\n(input '.' over). \n"

while True:
    entry = raw_input('>')
    if entry == '.':
        break
    else:
        all.append(entry)

#打开文件，将内存中的内容写入文件
fobj = open(fname,'w')
#列表解析，'%s%s'为每一行添加行结束符，(x,ls)表示每一行及其行结束符
fobj.writelines(['%s%s' % (x,ls) for x in all])
fobj.close()
print 'done!'
