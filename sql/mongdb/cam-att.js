db.getCollection("report").drop({})


var s = db.getCollection("attstatistics").find({})
typeof(s)
