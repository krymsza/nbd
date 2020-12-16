printjson(
    db.people.aggregate(
        [
            {$unwind : "$credit" },
            {$group : {
                _id : "$credit.currency", 
                currency_average : {
                    $avg : {
                        '$convert': {'input': '$credit.balance','to': 'double' }
                    }
                }
                
            }
        }]
    )
)