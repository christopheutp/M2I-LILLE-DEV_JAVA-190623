@ECHO OFF

echo STEP 1: Mvn clean instruction
call mvn clean install -U -DskipTests=true

IF %ERRORLEVEL% EQU 1 (
	echo Failure. Reason Given is %errorlevel%
	exit /b %errorlevel%
) ELSE (
	call timeout /t 10
	echo STEP 2: Springboot run
	call mvn spring-boot:run
)
