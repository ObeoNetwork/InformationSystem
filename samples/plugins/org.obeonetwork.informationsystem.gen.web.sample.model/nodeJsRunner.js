var connect = require('connect');
connect.createServer(
    connect.static('../org.obeonetwork.informationsystem.gen.web.sample')
).listen(8080, '127.0.0.3');