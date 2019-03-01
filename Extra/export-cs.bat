@echo off
@title Dump
set CLASSPATH=.;dist\*
java -server -Dwzpath=..\ -Dpath=..\ tools.export.CashShop
pause