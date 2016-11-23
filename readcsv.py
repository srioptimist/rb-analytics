import csv
import datetime
from matplotlib import pyplot as plt
from matplotlib import style

style.use('ggplot')

# plot graph for debitpas
skaartrabotmpdate=""
skaartrabodate=[]
skaartraboavg=[]
skaartrabocnt=[]

skaartabntmpdate=""
skaartabndate=[]
skaartabnavg=[]
skaartabncnt=[]

skaartingtmpdate=""
skaartingdate=[]
skaartingavg=[]
skaartingcnt=[]


with open('csv.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        if row[0] == 'Rabobank':
	    if skaartrabotmpdate != row[1]:
		skaartrabotmpdate = row[1]
		skaartrabodate.append(row[1])
		a=len(skaartrabodate) - 1
		skaartrabocnt.append(1)
                skaartraboavg.append(row[2])
	    else:
	        skaartraboavg[a] = ((float(skaartraboavg[a]) * float(skaartrabocnt[a])) + float(row[2])) / (float(skaartrabocnt[a]) + 1)
		skaartrabocnt[a] = float(skaartrabocnt[a]) + 1

        elif row[0] == 'ABN AMRO':
	    if skaartabntmpdate != row[1]:
		skaartabntmpdate = row[1]
		skaartabndate.append(row[1])
		a=len(skaartabndate) - 1
		skaartabncnt.append(1)
                skaartabnavg.append(row[2])
	    else:
	        skaartabnavg[a] = ((float(skaartabnavg[a]) * float(skaartabncnt[a])) + float(row[2])) / (float(skaartabncnt[a]) + 1)
		skaartabncnt[a] = float(skaartabncnt[a]) + 1

        elif row[0] == 'ING':
	    if skaartingtmpdate != row[1]:
		skaartingtmpdate = row[1]
		skaartingdate.append(row[1])
		a=len(skaartingdate) - 1
		skaartingcnt.append(1)
                skaartingavg.append(row[2])
	    else:
	        skaartingavg[a] = ((float(skaartingavg[a]) * float(skaartingcnt[a])) + float(row[2])) / (float(skaartingcnt[a]) + 1)
		skaartingcnt[a] = float(skaartingcnt[a]) + 1

	   	
print skaartrabocnt
print skaartrabodate
print skaartraboavg

print skaartabncnt
print skaartabndate
print skaartabnavg

print skaartingcnt
print skaartingdate
print skaartingavg


# can plot specifically, after just showing the defaults:
plt.plot(skaartrabodate,skaartraboavg,'g',label='Rabobank',linewidth=5)
plt.plot(skaartabndate,skaartabnavg,'c',label='ABN AMRO',linewidth=5)
plt.plot(skaartingdate,skaartingavg,label='ING',linewidth=5)

plt.title('Sentiment Analysis - debit pas of major banks in the Netherlands')
plt.ylabel('Sentiment')
plt.xlabel('Week Number')

plt.legend()

plt.grid(True,color='k')
plt.show()


# plot graph for debitpas
sintbankingrabotmpdate=""
sintbankingrabodate=[]
sintbankingraboavg=[]
sintbankingrabocnt=[]

sintbankingabntmpdate=""
sintbankingabndate=[]
sintbankingabnavg=[]
sintbankingabncnt=[]

sintbankingingtmpdate=""
sintbankingingdate=[]
sintbankingingavg=[]
sintbankingingcnt=[]


with open('csv.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        if row[0] == 'Rabobank':
	    if sintbankingrabotmpdate != row[1]:
		sintbankingrabotmpdate = row[1]
		sintbankingrabodate.append(row[1])
		a=len(sintbankingrabodate) - 1
		sintbankingrabocnt.append(1)
                sintbankingraboavg.append(row[2])
	    else:
	        sintbankingraboavg[a] = ((float(sintbankingraboavg[a]) * float(sintbankingrabocnt[a])) + float(row[2])) / (float(sintbankingrabocnt[a]) + 1)
		sintbankingrabocnt[a] = float(sintbankingrabocnt[a]) + 1

        elif row[0] == 'ABN AMRO':
	    if sintbankingabntmpdate != row[1]:
		sintbankingabntmpdate = row[1]
		sintbankingabndate.append(row[1])
		a=len(sintbankingabndate) - 1
		sintbankingabncnt.append(1)
                sintbankingabnavg.append(row[2])
	    else:
	        sintbankingabnavg[a] = ((float(sintbankingabnavg[a]) * float(sintbankingabncnt[a])) + float(row[2])) / (float(sintbankingabncnt[a]) + 1)
		sintbankingabncnt[a] = float(sintbankingabncnt[a]) + 1

        elif row[0] == 'ING':
	    if sintbankingingtmpdate != row[1]:
		sintbankingingtmpdate = row[1]
		sintbankingingdate.append(row[1])
		a=len(sintbankingingdate) - 1
		sintbankingingcnt.append(1)
                sintbankingingavg.append(row[2])
	    else:
	        sintbankingingavg[a] = ((float(sintbankingingavg[a]) * float(sintbankingingcnt[a])) + float(row[2])) / (float(sintbankingingcnt[a]) + 1)
		sintbankingingcnt[a] = float(sintbankingingcnt[a]) + 1

	   	
print sintbankingrabocnt
print sintbankingrabodate
print sintbankingraboavg

print sintbankingabncnt
print sintbankingabndate
print sintbankingabnavg

print sintbankingingcnt
print sintbankingingdate
print sintbankingingavg


# can plot specifically, after just showing the defaults:
plt.plot(sintbankingrabodate,sintbankingraboavg,'g',label='Rabobank',linewidth=5)
plt.plot(sintbankingabndate,sintbankingabnavg,'c',label='ABN AMRO',linewidth=5)
plt.plot(sintbankingingdate,sintbankingingavg,label='ING',linewidth=5)

plt.title('Sentiment Analysis - Internet banking of major banks in the Netherlands')
plt.ylabel('Sentiment')
plt.xlabel('Week Number')

plt.legend()

plt.grid(True,color='k')
plt.show()


# plot graph for savings products in netherlands

ssparenrabotmpdate=""
ssparenrabodate=[]
ssparenraboavg=[]
ssparenrabocnt=[]

ssparenabntmpdate=""
ssparenabndate=[]
ssparenabnavg=[]
ssparenabncnt=[]

sspareningtmpdate=""
sspareningdate=[]
sspareningavg=[]
sspareningcnt=[]


with open('csv.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        if row[0] == 'Rabobank':
	    if ssparenrabotmpdate != row[1]:
		ssparenrabotmpdate = row[1]
		ssparenrabodate.append(row[1])
		a=len(ssparenrabodate) - 1
		ssparenrabocnt.append(1)
                ssparenraboavg.append(row[2])
	    else:
	        ssparenraboavg[a] = ((float(ssparenraboavg[a]) * float(ssparenrabocnt[a])) + float(row[2])) / (float(ssparenrabocnt[a]) + 1)
		ssparenrabocnt[a] = float(ssparenrabocnt[a]) + 1

        elif row[0] == 'ABN AMRO':
	    if ssparenabntmpdate != row[1]:
		ssparenabntmpdate = row[1]
		ssparenabndate.append(row[1])
		a=len(ssparenabndate) - 1
		ssparenabncnt.append(1)
                ssparenabnavg.append(row[2])
	    else:
	        ssparenabnavg[a] = ((float(ssparenabnavg[a]) * float(ssparenabncnt[a])) + float(row[2])) / (float(ssparenabncnt[a]) + 1)
		ssparenabncnt[a] = float(ssparenabncnt[a]) + 1

        elif row[0] == 'ING':
	    if sspareningtmpdate != row[1]:
		sspareningtmpdate = row[1]
		sspareningdate.append(row[1])
		a=len(sspareningdate) - 1
		sspareningcnt.append(1)
                sspareningavg.append(row[2])
	    else:
	        sspareningavg[a] = ((float(sspareningavg[a]) * float(sspareningcnt[a])) + float(row[2])) / (float(sspareningcnt[a]) + 1)
		sspareningcnt[a] = float(sspareningcnt[a]) + 1

	   	
print ssparenrabocnt
print ssparenrabodate
print ssparenraboavg

print ssparenabncnt
print ssparenabndate
print ssparenabnavg

print sspareningcnt
print sspareningdate
print sspareningavg


# can plot specifically, after just showing the defaults:
plt.plot(ssparenrabodate,ssparenraboavg,'g',label='Rabobank',linewidth=5)
plt.plot(ssparenabndate,ssparenabnavg,'c',label='ABN AMRO',linewidth=5)
plt.plot(sspareningdate,sspareningavg,label='ING',linewidth=5)

plt.title('Sentiment Analysis - Savings products of major banks in the Netherlands')
plt.ylabel('Sentiment')
plt.xlabel('Week Number')

plt.legend()

plt.grid(True,color='k')
plt.show()




# plot graph for mobileapp
smobileapprabotmpdate=""
smobileapprabodate=[]
smobileappraboavg=[]
smobileapprabocnt=[]

smobileappabntmpdate=""
smobileappabndate=[]
smobileappabnavg=[]
smobileappabncnt=[]

smobileappingtmpdate=""
smobileappingdate=[]
smobileappingavg=[]
smobileappingcnt=[]


with open('csv.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        if row[0] == 'Rabobank':
	    if smobileapprabotmpdate != row[1]:
		smobileapprabotmpdate = row[1]
		smobileapprabodate.append(row[1])
		a=len(smobileapprabodate) - 1
		smobileapprabocnt.append(1)
                smobileappraboavg.append(row[2])
	    else:
	        smobileappraboavg[a] = ((float(smobileappraboavg[a]) * float(smobileapprabocnt[a])) + float(row[2])) / (float(smobileapprabocnt[a]) + 1)
		smobileapprabocnt[a] = float(smobileapprabocnt[a]) + 1

        elif row[0] == 'ABN AMRO':
	    if smobileappabntmpdate != row[1]:
		smobileappabntmpdate = row[1]
		smobileappabndate.append(row[1])
		a=len(smobileappabndate) - 1
		smobileappabncnt.append(1)
                smobileappabnavg.append(row[2])
	    else:
	        smobileappabnavg[a] = ((float(smobileappabnavg[a]) * float(smobileappabncnt[a])) + float(row[2])) / (float(smobileappabncnt[a]) + 1)
		smobileappabncnt[a] = float(smobileappabncnt[a]) + 1

        elif row[0] == 'ING':
	    if smobileappingtmpdate != row[1]:
		smobileappingtmpdate = row[1]
		smobileappingdate.append(row[1])
		a=len(smobileappingdate) - 1
		smobileappingcnt.append(1)
                smobileappingavg.append(row[2])
	    else:
	        smobileappingavg[a] = ((float(smobileappingavg[a]) * float(smobileappingcnt[a])) + float(row[2])) / (float(smobileappingcnt[a]) + 1)
		smobileappingcnt[a] = float(smobileappingcnt[a]) + 1

	   	
print smobileapprabocnt
print smobileapprabodate
print smobileappraboavg

print smobileappabncnt
print smobileappabndate
print smobileappabnavg

print smobileappingcnt
print smobileappingdate
print smobileappingavg


# can plot specifically, after just showing the defaults:
plt.plot(smobileapprabodate,smobileappraboavg,'g',label='Rabobank',linewidth=5)
plt.plot(smobileappabndate,smobileappabnavg,'c',label='ABN AMRO',linewidth=5)
plt.plot(smobileappingdate,smobileappingavg,label='ING',linewidth=5)

plt.title('Sentiment Analysis - Mobile app of major banks in the Netherlands')
plt.ylabel('Sentiment')
plt.xlabel('Week Number')

plt.legend()

plt.grid(True,color='k')
plt.show()


		