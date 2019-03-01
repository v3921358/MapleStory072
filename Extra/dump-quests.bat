@echo off
@title Dump
set CLASSPATH=.;..\dist\*;..\libs\*
java -Xmx512m -Dwzpath=..\ -Dpath=..\ tools.wztosql.DumpQuests
pause