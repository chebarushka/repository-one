import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.11"
}

group = "ru.cheburation"
version = "0.1-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  val vertxVersion = "3.6.2"
  val log4jVersion = "2.9.1"

  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("io.vertx:vertx-core:$vertxVersion")
  compile("io.vertx:vertx-hazelcast:$vertxVersion")
  compile("io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion")
  compile("io.vertx:vertx-web:$vertxVersion")

  compile("org.apache.logging.log4j:log4j-core:$log4jVersion")
  compile("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
  compile("org.slf4j:jul-to-slf4j:1.7.4")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}
