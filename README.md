# 개요
기본적인 SNS에 관련된 API 멀티 모듈 구성


## Development Tools

- IntelliJ
- SpringBoot 2.4.1
- myBatis 2.1.3
- openjdk version 1.8.0_192

## Getting Started
### 1. docker 컨테이너 생성
```
cd docker
docker-compose up -d
```

### 2. Application 실행
core/src/KafkaApplication.java
web/src/WebApplication.java



## File Manifest
```
├── README.md
├── build.gradle
├── core
│   ├── build
│   └── src
├── docker
│   ├── db
│   └── docker-compose.yml
├── gradle
│   └── wrapper
├── gradlew
├── gradlew.bat
├── settings.gradle
└── web
    ├── build
    └── src
```