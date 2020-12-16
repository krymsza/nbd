var map = function() {
    var bmi = this.weight/(this.height * this.height)
    var bmi_min =bmi;
    var bmi_max =bmi;
    emit(this.nationality, {bmi, bmi_min, bmi_max});
};

var reduce_min = function(key, values) {
    var temp_min = values[0];
    var temp_max = values[0];
    var output = {bmi_min: temp_min, bmi_max: temp_max, bmi_avg:0}
    var count = 0
    var sum_bmi = 0

    values.forEach(function(val) {
        count += 1;
        sum_bmi += val.bmi;
        if (val.bmi < temp_min.bmi_min){
            temp_min = val;
        }
        if (val.bmi > temp_max.bmi_max){
            temp_max = val;
        }
    })
    
    output.bmi_max = temp_max.bmi_max;
    output.bmi_min = temp_min.bmi_min;
    output.bmi_avg = sum_bmi/count;

    return output;
};

 printjson(
    db.people.mapReduce(
        map,
        reduce_min,
        { out: "mr_min"}
    )
 )

 printjson(db.mr_min.find().sort({"_id" :1}).toArray())
