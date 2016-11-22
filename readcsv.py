import csv
import datetime
from matplotlib import pyplot as plt
from matplotlib import style

style.use('ggplot')

seldrabo=""
srabodate=[]
sraboavg=[]
srabocnt=[]

seldabn=""
sabndate=[]
sabnavg=[]
sabncnt=[]

selding=""
singdate=[]
singavg=[]
singcnt=[]


with open('csv.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        if row[0] == 'Rabobank':
	    if seldrabo != row[1]:
		seldrabo = row[1]
		srabodate.append(row[1])
		a=len(srabodate) - 1
		srabocnt.append(1)
                sraboavg.append(row[2])
	    else:
	        sraboavg[a] = ((float(sraboavg[a]) * float(srabocnt[a])) + float(row[2])) / (float(srabocnt[a]) + 1)
		srabocnt[a] = float(srabocnt[a]) + 1

        elif row[0] == 'ABN AMRO':
	    if seldabn != row[1]:
		seldabn = row[1]
		sabndate.append(row[1])
		a=len(sabndate) - 1
		sabncnt.append(1)
                sabnavg.append(row[2])
	    else:
	        sabnavg[a] = ((float(sabnavg[a]) * float(sabncnt[a])) + float(row[2])) / (float(sabncnt[a]) + 1)
		sabncnt[a] = float(sabncnt[a]) + 1

        elif row[0] == 'ING':
	    if selding != row[1]:
		selding = row[1]
		singdate.append(row[1])
		a=len(singdate) - 1
		singcnt.append(1)
                singavg.append(row[2])
	    else:
	        singavg[a] = ((float(singavg[a]) * float(singcnt[a])) + float(row[2])) / (float(singcnt[a]) + 1)
		singcnt[a] = float(singcnt[a]) + 1

	   	
print srabocnt
print srabodate
print sraboavg

print sabncnt
print sabndate
print sabnavg

print singcnt
print singdate
print singavg


# can plot specifically, after just showing the defaults:
plt.plot(srabodate,sraboavg,'g',label='Rabobank',linewidth=5)
plt.plot(sabndate,sabnavg,'c',label='ABN AMRO',linewidth=5)
plt.plot(singdate,singavg,label='ING',linewidth=5)

plt.title('Sentiment Analysis of Major Bank in Netherlands')
plt.ylabel('Sentiment')
plt.xlabel('Week Number')

plt.legend()

plt.grid(True,color='k')
plt.show()

		