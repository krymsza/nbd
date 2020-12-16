var mapping = function() {
    for (var idx = 0; idx < this.credit.length; idx++) {
        var key = this.credit[idx].currency;
        var value = parseInt(this.credit[idx].balance)
        emit(key, value);
    }
     
};
var reduction = function(key, value) {
    { return Array.avg(value)};
 };

 printjson(
    db.people.mapReduce(
        mapping,
        reduction,
        { out: "mr" }
    )
 )
 printjson(db.mr.find().toArray())