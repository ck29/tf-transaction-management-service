# tf-transaction-management-service
[![Java CI with Gradle](https://github.com/ck29/tf-transaction-management-service/actions/workflows/gradle.yml/badge.svg)](https://github.com/ck29/tf-transaction-management-service/actions/workflows/gradle.yml)



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="##installation-manual">Installation</a></li>
        <li><a href="##integration-test">Integration Test</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>

  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

The `transaction-management-service` is an application to simple transaction. The operations provided the services can be easily integrated with any UI.
The service also provides simple transaction operation.

The service is built using spring boot with H2 in memory database. It can also run as a persitent database on local machine.


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

The service is build using following frameworks/languages.

* Java
* Junit
* Spring boot
* Git
* Gradle
* H2 embedded
* Git action (CI)


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Clone the project and get the prequisites setup.

### Prerequisites

Make sure the following tools are installed on your local machine.
* Java
  ```sh
  apt-get install openjdk-17-jdk
  ```

* Git
  ```shell
  apt-get install git
  ```

* Gradle
  ```shell
  apt-get install gradle
  ```

### Installation (Manual)
1. Clone the project.
   ```
   git clone https://github.com/ck29/tf-transaction-management-service.git
   ```
2. Clean and build
   ```shell
   cd tf-transaction-management-service
   gradlew clean build
   ```
3. Start application
   ```shell
   java -jar build/transaction-management-service-0.0.1-SNAPSHOT.jar
   ```

   ```

<!-- USAGE EXAMPLES -->
## Usage

1. Once the application is running, we can query the API using various method. The details about the endpoints are available using openapi specification. The specification can be downloaded using following link.

   [Swagger(Open API Specification)](https://github.com/ck29/tf-transaction-management-service/blob/master/data/swagger.yml)


### Create new transaction
```shell
   POST /tf/service/transaction/new HTTP/1.1
   Host: localhost:8085
   Content-Type: application/json
   {
  "recipientAccount": "ace4e1-e23cb-3eaddf-45ffbcea",
  "senderAccount": "ace4e2-e23cb-3eaddf-45ffbeace",
  "amount": 550,
  "transactionMessage": "test_message"
   }
   ```



<p align="right">(<a href="#top">back to top</a>)</p>
