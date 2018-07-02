package com.dingpw.deploy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468
 */
public class Runner extends AbstractVerticle {

    Vertx vertx = Vertx.vertx();

    public void start() {
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(req -> {
            MultiMap params = req.params();
            String query = req.query();
            MultiMap entries = req.formAttributes();
            req.bodyHandler(totalBuffer -> {
                System.out.println("Full body received, length = " + totalBuffer.toString());
            });

            System.out.println("params : " + params.toString());
            System.out.println("query : " + query);
            System.out.println("formAttributes : " + entries.toString());
            req.response()
                .putHeader("content-type", "text/plain")
                .end("ok");
        }).listen();
    }
}
