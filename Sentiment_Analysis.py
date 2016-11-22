import csv
import argparse
from googleapiclient import discovery
import pprint
import sys
from apiclient.discovery import build

api_key = 'AIzaSyChR_RVUHz6eBVUf9BgjKxJVCyHeiCNDXk'



i = 0
k = [0,0.0,'initialrow','translated tweet']
g = open('C:/Temp/Vishwesh/Text analytics/output.txt', 'w')
f = open('C:/Temp/Vishwesh/Text analytics/tweets.txt', 'r')
reader = csv.reader(f, delimiter='\t')
writer = csv.writer(g, delimiter='\t')
for line in reader:
   i = i+1
   k[0] = i
   service = build('translate', 'v2', developerKey=api_key)
   request = service.translations().list(source='nl',target='en', q=line[2])
   response = request.execute()
   translated_text = response['translations'][0]['translatedText']
   service = build('language','v1beta1',developerKey=api_key)

   request = service.documents().analyzeSentiment(
          body={
              'document':{
                  'type':'PLAIN_TEXT',
                  'content': translated_text,
               }
              }
            )
   response = request.execute()
   x_list = response['sentences']
   y = 0
   for cou in x_list:
       y = y + cou['sentiment']['score']
     
   k[1] = y
   k[2] = line[0]
   k[3] = translated_text
   writer.writerow(k)
   
# reader = csv.reader(f, delimiter='\t')
#    for row in reader:
#        print row
#k[1] = line[2].encode('ascii', 'ignore')
