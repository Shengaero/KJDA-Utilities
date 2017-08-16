# Kotlin-JDA-Utilities
[![](https://jitpack.io/v/TheMonitorLizard/KJDA-Utilities.svg)](https://jitpack.io/#TheMonitorLizard/KJDA-Utilities)

Kotlin-JDA-Utilities is a side-repo for small adaptations/extensions of 
[JDA-Utilities](https://github.com/JDA-Applications/JDA-Utilities).

## What's in Kotlin-JDA-Utilities?

This library is mostly geared towards convenience and extension methods as well
as some closure builders for many of the EventWaiter menus in JDA-Utilities.

However the best part of the library is the extension methods, allowing many of
JDA and JDA-Utilities features to become more fluid and synthetic as JDA-Utilities
was intended to be.

Here are some examples:

#### Building CommandClient
```kotlin
// You can now seamlessly create, build, and chain
// a CommandClientBuilder into JDABuilder for a
// streamlined and flawless JDA Instantiation!
val jda = JDABuilder(AccountType.BOT)
        .setToken("<Example_Token>")
        .commandClient {
            prefix  { "!?" }
            ownerId { 123456789123L }
            command { PingCommand() }
            emojis  {
                success { ":)" }
                warning { ":|" }
                error   { ":(" }
            }
        }
        // ...
        .buildBlocking()
```

#### FinderUtil
```kotlin
override fun execute(event : CommandEvent)
{
    val args = event.args
    // FinderUtil methods can be used as
    // extension functions of JDA of a Guild
    val users = event.jda.findUsers(args)
    val members = event.guild.findMembers(args)
}
```

## Adding KJDA-Utilities

In order to use Kotlin-JDA-Utilities, you'll need to provide your own versions of the
following and that they be the latest versions available:

- [JDA (3.2.0_242)](https://github.com/Dv8FromTheWorld/JDA)
- [JDA-Utilities (1.5)](https://github.com/JDA-Applications/JDA-Utilities)
- [Kotlin-JDA (25c1fee)](https://github.com/JDA-Applications/Kotlin-JDA)

New releases here always update to the newest version of the aforementioned three,
and as such are the least likely to have bugs or errors when using them.

It is strongly recommended you use a dependency manager such as gradle or maven (snippets
for both are posted below) and that you avoid using the jar files, as this will make
updating much more difficult.

**NOTE: Kotlin setup is up to you!**

It's highly recommended you use the newest build stable stdlib build.

If you are unsure on how to install kotlin, or add kotlin using either maven or gradle
the following pages can help you:

> [Kotlin Gradle Setup](https://kotlinlang.org/docs/reference/using-gradle.html)

> [Kotlin Maven Setup](https://kotlinlang.org/docs/reference/using-maven.html)

#### Using Gradle
```groovy
repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'net.dv8tion:JDA:JDA_VERSION'
    compile 'com.jagrosh:JDA-Utilities:JDA_UTILITIES_VERSION'
    compile 'com.github.JDA-Applications:Kotlin-JDA:master-SNAPSHOT'
    compile 'com.github.TheMonitorLizard:KJDA-Utilties:master-SNAPSHOT'
}
```

#### Using Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
    <repository>
        <id>jcenter</id>
        <name>jcenter-bintray</name>
        <url>http://jcenter.bintray.com</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>com.github.JDA-Applications</groupId>
        <artifactId>Kotlin-JDA</artifactId>
        <version>master-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>com.github.TheMonitorLizard</groupId>
        <artifactId>KJDA-Utilities</artifactId>
        <version>master-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>com.jagrosh</groupId>
        <artifactId>JDA-Utilities</artifactId>
        <version>JDA_UTILITIES_VERSION</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>net.dv8tion</groupId>
        <artifactId>JDA</artifactId>
        <version>JDA_VERSION</version>
    </dependency>
</dependencies>
```