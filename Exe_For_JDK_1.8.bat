for /f "tokens=5" %%a in ('netstat -aon ^| find "8080"') do taskkill /f /pid %%a
call mvnw clean package
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b
call java -jar target/SMS_Codewarriors-0.0.1-SNAPSHOT.jar 
pause >nul