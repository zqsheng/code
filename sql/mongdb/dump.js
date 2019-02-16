//D:\mongodb-4.0.4\bin\mongo 127.0.0.1:27017/daka E:\myworkspace\snippet\sql\mongdb\dump.js > result.js

var c = db.report.find({})
while(c.hasNext()) {
    printjson(c.next());
}



