vertx.createHttpServer()
  .requestHandler(function (req) {
    var method = req.method();
    console.log("request method is : " + method);
    console.log("request path is : " + req.path());

    if (method == "GET"){
      console.log(req.params());
    } else if (method == "POST"){
      req.bodyHandler(function (body){
        var params = body.toString();
        console.log(params);
      });
    }

    req.response()
      .putHeader("content-type", "text/plain")
      .end("ok");
}).listen();
