# Helpromise
사용자에게 좀 더 편리한 일정 관리 서비스를 제공합니다. 개인, 그룹 일정을 한눈에 파악하고 일정을 관리할 수 있으며 사적인 일정과 공적인 일정을 따로 관리할 수 있는 서비스를 제공합니다.


## Development Tools

- IntelliJ
- SpringBoot 2.4.1
- myBatis 2.1.3
- openjdk version 1.8.0_192

## Getting Started


## Core module
### 카프카 다운로드
```
wget https://downloads.apache.org/kafka/3.2.0/kafka_2.13-3.2.0.tgz
```

### 주키퍼 서버 실행
- 기본적으로 단일 노드 주키퍼가 있다
```
bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
```

### 카프카 브로커(서버) 실행
- 기본 포트는 9092번
- 변경하려면 config디렉토리 하위 설정 파일 수정
```
 bin/kafka-server-start.sh -daemon config/server.properties
```

### 포트 확인
```
netstat -an | grep 2181
tcp4       0      0  127.0.0.1.2181         127.0.0.1.52992        ESTABLISHED
tcp4       0      0  127.0.0.1.52992        127.0.0.1.2181         ESTABLISHED
tcp46      0      0  *.2181
```

### 토픽 생성
```
bin/kafka-topics.sh --create --topic new-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
```

### 토픽 조회
```
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
__consumer_offsets
new-topic
```






## File Manifest
```
├── README.md
├── build.gradle
├── core
│   ├── build
│   ├── docker
│   └── src
├── gradle
│   └── wrapper
├── gradlew
├── gradlew.bat
├── settings.gradle
└── web
    ├── build
    └── src

```