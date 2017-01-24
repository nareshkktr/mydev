@setlocal enableextensions enabledelayedexpansion
@echo off
:loop
  xcopy index.html public  /h /y &
  for /r app %%f in (*.html) do (xcopy "%%f" public\\assets\\partials /h /y) &
timeout 50
goto :loop
endlocal

