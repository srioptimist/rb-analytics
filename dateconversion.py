import time
from time import gmtime, strftime
d = time.strptime("16 Jan 2016", "%d %b %Y")
print(strftime("%U", d))