import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.10"
}

group = "ru.cheburation"
version = "0.1-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("io.vertx:vertx-core:3.6.0")
  compile("io.vertx:vertx-hazelcast:3.6.0")
  compile("io.vertx:vertx-lang-kotlin-coroutines:3.6.0")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}
