//4.	Average, minimum and maximum BMI 
//(weight/height^2) grouped by nationality

printjson(
    db.people.aggregate(
        [
            {
                $group : {
                    _id : "$nationality",
                    bmi_avg : {
                        $avg : {
                        $sum : {$divide: ['$weight', {$divide: [{$multiply: ['$height', '$height']},10000]}]}
                        }
                    },
                    bmi_min : {
                        $min : {
                            $sum : {$divide: ['$weight', {$divide: [{$multiply: ['$height', '$height']},10000]}]}
                        }
                    },
                    bmi_max : {
                        $max : {
                            $sum : {$divide: ['$weight', {$divide: [{$multiply: ['$height', '$height']},10000]}]}
                        }
                    }
                }
            }
        ],
        { cursor: { batchSize: 25000 } }
    )
)
