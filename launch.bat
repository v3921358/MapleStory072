@echo off

@title MapleSDNA_V72

Color 0A

set CLASSPATH=.;dist\*;libs\*;

java -client server.Start

pause