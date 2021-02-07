#!/usr/bin/env python
from datetime import datetime
import string
import riak

#1 add a document to the database 
client = riak.RiakClient(pb_port=8087, protocol='pbc')
paint = {'id': '1234', 'type': 'oil', 'color': 'pink'}
bucket = client.bucket('s22011')


dbPaint = bucket.new(paint['id'], data=paint).store()


print("Paint added, key=" + dbPaint.key + ", data=" + str(dbPaint.data))

dbPaintFetched = bucket.get(dbPaint.key)
print("fetched (" + dbPaintFetched.key + ") data=" + str(dbPaintFetched.data))
fetched_data = dbPaintFetched.data
fetched_data['color'] = 'light pink'
dbPaintFetched.data = fetched_data

dbPaintFetched.store()

dbPaintFetched = bucket.get(db_stud.key)
print("fetched paint( " + dbPaintFetched.key + ") data=" + str(dbPaintFetched.data))

#5 delete it from the database
bucket.delete(dbPaintFetched.key)


print("deleted data( " + dbPaintFetched.key + ") data=" + str(bucket.get(dbPaintFetched.key).data))
