#!/bin/sh

CLI="../dfc/ba-dua-cli-0.6.0-all.jar"
SER="./coverage.ser"
CLASSES="./bookkeeper-server/target/classes"
XML="./target/badua.xml"

java -jar ${CLI} report -input ${SER} -classes ${CLASSES} -show-classes -show-methods -xml ${XML}
