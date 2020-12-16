var map = function() {
    emit(this.job, { count : 1 } );
};

var reduce = function(key, values) {
    var counter = [];
  
    values.forEach(function(v) {
      for(var k in v) { 
        if(!counter[k]) 
        counter[k] = 0
        counter[k] += v[k];
      }
    });
    return counter;
}

printjson(
    db.people.mapReduce(
        map,
        reduce,
        { 
            out: "mr" 
        }
    )
)

printjson(db.mr.find({ value : { $eq : 1 }}).toArray())