#!/bin/sh

rm -f tpid

nohup java -Xms1024m -Xmx1024m -Dloader.path="lib/" -jar api-1.0.0.jar > /dev/null 2>&1 &

echo $! > tpid

echo Start Success!