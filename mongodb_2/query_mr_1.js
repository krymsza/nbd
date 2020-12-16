var mapFunction = function() {
    var x =  parseInt(this.weight);
    emit(this.sex, x)
 };
 var reduceFunction = function(sex, valuesx) {
    { return Array.avg(valuesx)};
 };

 printjson(
    db.people.mapReduce(
        mapFunction,
        reduceFunction,
        { out: "mr" }
    )
 )
db.mr.find().toArray()
