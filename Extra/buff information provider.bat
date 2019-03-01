@echo off
@title Buff Information Provider
Color 0A
set CLASSPATH=.;..\dist\*;..\libs\*
java -Xmx512m -Dwzpath=..\wz tools.export.BuffInformation
pause