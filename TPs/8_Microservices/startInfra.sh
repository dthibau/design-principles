#!/bin/sh

java -jar config.jar &
sleep 5
java -jar annuaire.jar &
java -jar fakeSMTP-2.0.jar &

