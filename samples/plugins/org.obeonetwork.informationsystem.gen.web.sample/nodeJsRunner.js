var connect = require('connect');
connect.createServer(
    connect.static('genWithoutPlay/public')
).listen(8080, '127.0.0.3');