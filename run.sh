#!/usr/bin/env bash
$WILD_FLY_PATH=$(/home/whoami/Development/WebServer/wildfly-11.0.0.Final/bin/standalone.sh)
$H2_SERVER_PATH=$(/home/whoami/Development/JavaProjects/restejbjpa/scripts/runHSQLDBServer.sh)

eval $H2_SERVER_PATH
eval $WILD_FLY_PATH
