# P009_NC99_Micro_Service_Discovery

## 개요
API 서버들과 Frontend 배포 시에 서로 다른 네트워크 및 가상환경(Docker Container / K8S Pod) 에 있는 마이크로서비스들을 서로 찾아 엮을 수 있도록 합니다

### 기술스택
* JAVA 21
* Gradle
* Spring Boot 3.1.5
* Spring Cloud 2022.0.4
* Eureka Microservice Discovery

### 관련 문서
* 서비스 기획
  * (관련 문서를 추후에 이곳에 추가합니다)
* 서비스 설계 
* 기술적 판단

### 주요 디펜던시
```
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server'
```


## 배포
다음과 같이 배포 환경을 구성합니다.

### 배포 대상 및 환경
* [ON-PROMISE] NewCentury99 Home Server
  * Quad Core CPU
  * 8GB RAM
  * 256GB System SSD
  * 1Gbps Ethernet
  * CentOS 9 Stream
* Nginx Proxy-Pass
* Docker with Docker Compose
* MySQL Databases
* Jenkins CI/CD
* No Kubernetes

### 배포 도메인
https://discovery.newcentury99.com/

### DB 초기화 DDL
* 본 프로젝트는 DB를 사용하지 않음.

### DB 백업 덤프파일
* 본 프로젝트는 DB를 사용하지 않음

### 저장소 볼륨 설정정보
* 본 프로젝트는 Docker Volume 을 사용하지 않음

### 저장소 백업 압축파일
* 본 프로젝트는 전용 Disk Storage I/O를 수행하지 않음

### 빌드 및 배포 과정 (Jenkins 빌드파일)
```향후에 이 곳에 주석이 달린 Jenkins 빌드 파일을 추가하여 과정을 설명합니다```

### Docker Environment 구성 계획
* nc99-server docker 버츄얼 네트워크
  * nc99-msa-core (~/nc99_msa_core/docker-compose.yml) - MSA 구축을 위한 기본 기능
    * nginx - MSA 서비스를 이용하기 위한 SPA Frontend 및 일부 스태틱 파일 서빙과 Subdomain 연결을 위한 웹 서버 (API-Gateway 넘겨주는 프록시 기능 포함)
    * nc99-service-discovery [Current Repo] - MSA 인스턴스 탐지 및 기초적인 로드밸런싱을 위한 디스커버리 서비스
    * nc99-api-gateway - MSA 간 라우팅 및 포워딩을 위한 API 게이트웨이 서비스
    * nc99-central-auth-backend - OAuth2.0 사양을 준수하는 공통 로그인 서버(라이선스 관리 기능 포함)
    * nc99-central-auth-frontend - OAuth2.0 로그인과 서비스 구독/라이선스 관리 기능을 제공하는 WEB App
  * nc99-my-journal-exp (~/nc99_my_journal/docker-compose.yml)
    * nc99-my-journal-exp-backend - [P001] My Journal Express 서비스 서블릿 WAS
    * nc99-my-journal-exp-database - [P001] My Journal Express 서비스 DB (MySQL)
  * nc99-dk-zone (~/nc99_dk_zone/docker-compose.yml)
    * nc99-dk-zone-backend - [P002] DK Zone 서비스 API 백엔드
    * nc99-dk-zone-database - [P002] DK Zone 서비스 DB (MySQL)
  * 그 외 기타 개인 프로젝트들

## 버전 기록
2023.11.07 - v0.0.1 - MSA Discovery 서버 구성

## 만든이들
@NewCentury99 단독 개발

## 라이선스
추후 고지 예정
