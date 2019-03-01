@echo off
@title Opcode Convertor
Color 4E
set CLASSPATH=.;dist\*
java -Dnet.sf.odinms.wzpath=wz\ tools.ConvertOpcodes
pause  