#!/bin/bash
API_PROJECT_NAME="hobbyloop-api"

# hobbyloop-api deploy

API_JAR_PATH="/home/ubuntu/hobbyloop/$API_PROJECT_NAME/build/libs/hobbyloop-api-0.0.1-SNAPSHOT.jar"
API_DEPLOY_PATH="/home/ubuntu/hobbyloop/$API_PROJECT_NAME/"
API_DEPLOY_LOG_PATH="/home/ubuntu/hobbyloop/$API_PROJECT_NAME/deploy.log"
API_DEPLOY_ERR_LOG_PATH="/home/ubuntu/hobbyloop/$API_PROJECT_NAME/deploy_err.log"
API_APPLICATION_LOG_PATH="/home/ubuntu/hobbyloop/$API_PROJECT_NAME/application.log"
API_BUILD_JAR=$(ls $API_JAR_PATH)
API_JAR_NAME=$(basename $API_BUILD_JAR)

ADMIN_PROJECT_NAME="hobbyloop-admin"
# hobbyloop-admin deploy
ADMIN_JAR_PATH="/home/ubuntu/hobbyloop/$ADMIN_PROJECT_NAME/build/libs/hobbyloop-admin-0.0.1-SNAPSHOT.jar"
ADMIN_DEPLOY_PATH="/home/ubuntu/hobbyloop/$ADMIN_PROJECT_NAME/"
ADMIN_DEPLOY_LOG_PATH="/home/ubuntu/hobbyloop/$ADMIN_PROJECT_NAME/deploy.log"
ADMIN_DEPLOY_ERR_LOG_PATH="/home/ubuntu/hobbyloop/$ADMIN_PROJECT_NAME/deploy_err.log"
ADMIN_APPLICATION_LOG_PATH="/home/ubuntu/hobbyloop/$ADMIN_PROJECT_NAME/application.log"
ADMIN_BUILD_JAR=$(ls $ADMIN_JAR_PATH)
ADMIN_JAR_NAME=$(basename $ADMIN_BUILD_JAR)

echo "===== 배포 시작 (시간) : $(date +%c) =====" >> $API_DEPLOY_LOG_PATH
echo "===== 배포 시작 (시간) : $(date +%c) =====" >> $ADMIN_DEPLOY_LOG_PATH

# hobbyloop-api 배포 시작
echo "> build 파일명: $API_JAR_NAME" >> $API_DEPLOY_LOG_PATH
echo "> build 파일 복사" >> $API_DEPLOY_LOG_PATH
cp $API_BUILD_JAR $API_DEPLOY_PATH

echo "> 현재 동작중인 어플리케이션 pid 체크" >> $API_DEPLOY_LOG_PATH
CURRENT_PID=$(pgrep -f $API_JAR_NAME)

#실행 중인 어플리케이션이 있으면 종료
if [ -z $CURRENT_PID ]
then
  echo "> 현재 동작중인 어플리케이션 존재 X" >> $API_DEPLOY_LOG_PATH
else
  echo "> 현재 동작중인 어플리케이션 존재 O" >> $API_DEPLOY_LOG_PATH
  echo "> 현재 동작중인 어플리케이션 강제 종료 진행" >> $API_DEPLOY_LOG_PATH
  echo "> kill -15 $CURRENT_PID" >> $API_DEPLOY_LOG_PATH
  kill -15 $CURRENT_PID
  sleep 10
fi

#정상적으로 종료가 되지 않았다면 강제종료 실행
if [ -z $CURRENT_PID ]
then
  echo "> 현재 동작중인 어플리케이션 존재 X" >> $API_DEPLOY_LOG_PATH
else
  echo "> 현재 동작중인 어플리케이션 존재 O" >> $API_DEPLOY_LOG_PATH
  echo "> 현재 동작중인 어플리케이션 kill -15 옵션으로 종료 실패 -> kill -9 옵션 실행" >> $API_DEPLOY_LOG_PATH
  echo "> kill -9 $CURRENT_PID" >> $API_DEPLOY_LOG_PATH
  kill -9 $CURRENT_PID
fi

#배포
DEPLOY_API_JAR=$API_DEPLOY_PATH$API_JAR_NAME
echo "> DEPLOY_JAR 배포" >> $API_DEPLOY_LOG_PATH
nohup java -jar $DEPLOY_API_JAR>> $API_APPLICATION_LOG_PATH 2> $API_DEPLOY_ERR_LOG_PATH &

sleep 3

echo "> 배포 종료 : $(date +%c)" >> $API_DEPLOY_LOG_PATH

# hobbyloop-admin 배포 시작
echo "> build 파일명: $ADMIN_JAR_NAME" >> $ADMIN_DEPLOY_LOG_PATH
echo "> build 파일 복사" >> $ADMIN_DEPLOY_LOG_PATH
cp $ADMIN_BUILD_JAR $ADMIN_DEPLOY_PATH

echo "> 현재 동작중인 어플리케이션 pid 체크" >> $ADMIN_DEPLOY_LOG_PATH
CURRENT_PID=$(pgrep -f $ADMIN_JAR_NAME)

#실행 중인 어플리케이션이 있으면 종료
if [ -z $CURRENT_PID ]
then
  echo "> 현재 동작중인 어플리케이션 존재 X" >> $ADMIN_DEPLOY_LOG_PATH
else
  echo "> 현재 동작중인 어플리케이션 존재 O" >> $ADMIN_DEPLOY_LOG_PATH
  echo "> 현재 동작중인 어플리케이션 종료 진행" >> $ADMIN_DEPLOY_LOG_PATH
  echo "> kill -15 $CURRENT_PID" >> $ADMIN_DEPLOY_LOG_PATH
  kill -15 $CURRENT_PID
  sleep 3
fi

#정상적으로 종료가 되지 않았다면 강제종료 실행
if [ -z $CURRENT_PID ]
then
  echo "> 현재 동작중인 어플리케이션 존재 X" >> $ADMIN_DEPLOY_LOG_PATH
else
  echo "> 현재 동작중인 어플리케이션 존재 O" >> $ADMIN_DEPLOY_LOG_PATH
  echo "> 현재 동작중인 어플리케이션 kill -15 옵션으로 종료 실패 -> kill -9 옵션 실행" >> $ADMIN_DEPLOY_LOG_PATH
  echo "> kill -9 $CURRENT_PID" >> $ADMIN_DEPLOY_LOG_PATH
  kill -9 $CURRENT_PID
fi

DEPLOY_ADMIN_JAR=$ADMIN_DEPLOY_PATH$ADMIN_JAR_NAME
echo "> DEPLOY_JAR 배포" >> $ADMIN_DEPLOY_LOG_PATH
nohup java -jar $DEPLOY_ADMIN_JAR>> $ADMIN_APPLICATION_LOG_PATH 2> $ADMIN_DEPLOY_ERR_LOG_PATH &

sleep 3

echo "> 배포 종료 : $(date +%c)" >> $ADMIN_DEPLOY_LOG_PATH

