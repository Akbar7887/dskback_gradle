plugins {
	java
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.5.RELEASE"
	id("io.freefair.lombok") version "6.6.1"
}

group = "uz.backweb"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://artifactory-oss.prod.netflix.net/artifactory/maven-oss-candidates") }
}

extra["springCloudVersion"] = "2021.0.5"


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	compileOnly("org.projectlombok:lombok:1.16.10")
	implementation("io.jsonwebtoken:jjwt-api:0.10.2")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
	implementation("org.springframework.security:spring-security-config")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.0")
	implementation("com.auth0:java-jwt:4.2.2")

}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
