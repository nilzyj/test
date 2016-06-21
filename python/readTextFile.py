fname = raw_input('Enter filename:')
print
try:
    fobj = open(fname,'r')
except IOError,e:
    print "error:",e
else:
    for eachLine in fobj:
        print eachLine,
    fobj.close()
