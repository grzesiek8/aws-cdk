@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  lambda startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and LAMBDA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\lambda.jar;%APP_HOME%\lib\apigateway-1.68.0.jar;%APP_HOME%\lib\elasticloadbalancingv2-1.68.0.jar;%APP_HOME%\lib\certificatemanager-1.68.0.jar;%APP_HOME%\lib\rds-1.68.0.jar;%APP_HOME%\lib\secretsmanager-1.68.0.jar;%APP_HOME%\lib\lambda-1.68.0.jar;%APP_HOME%\lib\efs-1.68.0.jar;%APP_HOME%\lib\route53-1.68.0.jar;%APP_HOME%\lib\ec2-1.68.0.jar;%APP_HOME%\lib\logs-1.68.0.jar;%APP_HOME%\lib\s3-assets-1.68.0.jar;%APP_HOME%\lib\s3-1.68.0.jar;%APP_HOME%\lib\cdk-assets-1.68.0.jar;%APP_HOME%\lib\applicationautoscaling-1.68.0.jar;%APP_HOME%\lib\sqs-1.68.0.jar;%APP_HOME%\lib\cloudwatch-1.68.0.jar;%APP_HOME%\lib\codeguruprofiler-1.68.0.jar;%APP_HOME%\lib\events-1.68.0.jar;%APP_HOME%\lib\ssm-1.68.0.jar;%APP_HOME%\lib\kms-1.68.0.jar;%APP_HOME%\lib\autoscaling-common-1.68.0.jar;%APP_HOME%\lib\iam-1.68.0.jar;%APP_HOME%\lib\sam-1.68.0.jar;%APP_HOME%\lib\core-1.68.0.jar;%APP_HOME%\lib\aws-lambda-java-events-3.3.1.jar;%APP_HOME%\lib\aws-lambda-java-core-1.2.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.3.61.jar;%APP_HOME%\lib\kotlin-reflect-1.3.61.jar;%APP_HOME%\lib\gson-2.8.6.jar;%APP_HOME%\lib\cdk-cx-api-1.68.0.jar;%APP_HOME%\lib\cdk-cloud-assembly-schema-1.68.0.jar;%APP_HOME%\lib\cdk-region-info-1.68.0.jar;%APP_HOME%\lib\constructs-3.0.27.jar;%APP_HOME%\lib\jsii-runtime-1.13.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.3.61.jar;%APP_HOME%\lib\kotlin-stdlib-1.3.61.jar;%APP_HOME%\lib\annotations-19.0.0.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\joda-time-2.6.jar;%APP_HOME%\lib\jackson-databind-2.11.0.rc1.jar;%APP_HOME%\lib\jackson-core-2.11.0.rc1.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.3.61.jar;%APP_HOME%\lib\jackson-annotations-2.11.0.rc1.jar


@rem Execute lambda
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %LAMBDA_OPTS%  -classpath "%CLASSPATH%" lambda.TestApp %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable LAMBDA_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%LAMBDA_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
