@echo off
@title Drop Retriever
set CLASSPATH=.;dist\*
java -server -Dwzpath=wz tools.export.DropRetriever
pause