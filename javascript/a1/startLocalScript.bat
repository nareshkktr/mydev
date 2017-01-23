@setlocal enableextensions enabledelayedexpansion
@echo off
rmdir public /s /q &
call brunch build &
mkdir public\\assets\\partials &
xcopy index.html public  /h /y &
for /r app %%f in (*.html) do (xcopy "%%f" public\\assets\\partials /h /y) &
xcopy public ..\\..\\src\\main\\resources\\static /s /e /h /y &
call brunch watch --server 
endlocal

