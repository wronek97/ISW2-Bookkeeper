#!/bin/sh

CLI="../dfc/ba-dua-cli-0.6.0-all.jar"
SER="./bookkeeper-server/coverage.ser"
CLASSES="./bookkeeper-server/target/classes"
XML="./bookkeeper-server/target/badua.xml"

#java -jar ${CLI} report -input ${SER} -classes ${CLASSES} -show-classes -show-methods -xml ${XML}
java -jar ${CLI} report -input ${SER} -classes ${CLASSES} -show-classes -show-methods -xml ${XML}
