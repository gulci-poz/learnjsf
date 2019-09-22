@echo off
call mvn clean package
call docker build -t com.gulci/learnjsf .
call docker rm -f learnjsf
call docker run -d -p 8080:8080 -p 4848:4848 --name learnjsf com.gulci/learnjsf