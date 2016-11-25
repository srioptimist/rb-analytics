import csv
import argparse
from googleapiclient import discovery
import time
from time import gmtime, strftime
from datetime import datetime
import pprint
import sys
from apiclient.discovery import build

api_key = 'AIzaSyChR_RVUHz6eBVUf9BgjKxJVCyHeiCNDXk'


s1 = strftime("%H:%M:%S", gmtime())
print('Starting time: ', s1)

i = 0
k = [None] * 5
l = [' ',' ',' ',' ',' ']
g = open('C:/Temp/Vishwesh/Text analytics/sentiment_output.txt', 'w',newline='',encoding='utf-8')
h = open('C:/Temp/Vishwesh/Text analytics/entity_output.txt', 'w',newline='',encoding='utf-8')
f = open('C:/Temp/Vishwesh/Text analytics/cards.txt', 'r')
reader = csv.reader(f, delimiter='\t')
writer = csv.writer(g, delimiter='\t')
writer_ent = csv.writer(h,delimiter ='\t')
for line in reader:
   i = i+1
   service = build('translate', 'v2', developerKey=api_key)
   #request = service.translations().list(source='nl',target='en', q=line[3])
   request = service.translations().list(target='en', q=line[3])
   response = request.execute()
   translated_text = response['translations'][0]['translatedText']
   service = build('language','v1beta1',developerKey=api_key)

   request = service.documents().annotateText(
          body={
              'document':{
                  'type':'PLAIN_TEXT',
                  'content': translated_text,
               },
              'features':{
                  'extractEntities':True,
                  'extractDocumentSentiment':True
               } 
              }
            )
   response = request.execute()

   ent_list = response['entities']

   for ent in ent_list:
       entity_name = ent['name']
       entity_type = ent['type'] 
       l[1] = line[0]
       l[2] = line[1]
       l[3] = entity_type
       l[4] = entity_name
       writer_ent.writerow(l)


   x_list = response['sentences']

   y = 0
   j = 0
   ind_sc = ' ' 
   for cou in x_list:
       score = cou['sentiment']['score'] 
       y = y + score
       ind_sc = ind_sc + str(score)
       j = j + 1
     
   y = y/j  
   k[0] = line[0]
   dt = line[1].replace('CET ','').replace('CEST ','')
   dt1 = time.strptime(dt, "%c")
   k[1] = strftime("%U", dt1)
   k[2] = round(y,2)
   k[3] = translated_text
   k[4] = line[1]
   writer.writerow(k)
   
s2 = strftime("%H:%M:%S", gmtime())
print('Finishing time: ', s2)
FMT = '%H:%M:%S'
tdelta = datetime.strptime(s2, FMT) - datetime.strptime(s1, FMT)
print('Total time taken for ', i, ' tweets: ', tdelta)
   
# reader = csv.reader(f, delimiter='\t')
#    for row in reader:
#        print row
#k[1] = line[2].encode('ascii', 'ignore')
