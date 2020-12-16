//printjson(db.people.distinct("job"))

printjson(
db.people.aggregate([ 
    {
        $group:
        { "_id": {"job" : "$job"},
        "unoquejobs": {"$addToSet": "$job"}
        }
    },
    {
        $project:{"job":1}
    } 
    ],
    
    { cursor: { batchSize: 25000 } }
    )
)

