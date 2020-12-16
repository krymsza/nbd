printjson(
    db.people.aggregate(
        [{
            $group : {
                _id : "$sex", 
                weight_average : {
                    $avg : {
                        '$convert': {'input': '$weight','to': 'double' }
                    }
                },
                height_average : {
                    $avg : {
                        '$convert': {'input': '$height','to': 'double' }
                    }
                }
            }
        }],
        { cursor: { batchSize: 25000 } }
    )
)

