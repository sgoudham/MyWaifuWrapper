[license]: https://img.shields.io/github/license/sgoudham/MyWaifuWrapper
[maven-central]: https://img.shields.io/maven-central/v/me.goudham/MyWaifuWrapper
[build-status]: https://goudham.me/jenkins/job/MyWaifuWrapper/job/main/badge/icon
[codecov]: https://codecov.io/gh/sgoudham/MyWaifuWrapper/branch/main/graph/badge.svg?token=RxUDnCWnF0
[issues]: https://img.shields.io/github/issues/sgoudham/MyWaifuWrapper?label=issues
[pull-requests]: https://img.shields.io/github/issues-pr/sgoudham/MyWaifuWrapper
[fossa]: https://app.fossa.com/api/projects/git%2Bgithub.com%2Fsgoudham%2FMyWaifuWrapper.svg?type=shield

![fossa]
![license]
![maven-central]
![build-status]
![codecov]
![issues]
![pull-requests]

<h1 align="center">MyWaifuWrapper</h1>
<h2 align="center">An Asynchronous Java API Wrapper for MyWaifuList</h2>

# Summary

This is an Asynchronous API Wrapper for [MyWaifuList](https://mywaifulist.moe/dash) 

# Disclaimer

Given that MyWaifuList is a primarily user-driven website and this API is currently in an Alpha state,
the data returned **may not be** fully complete and at its best quality

# Configuration

## Creating The MyWaifuClient

There are 2 ways to create the [MyWaifuClient](https://github.com/sgoudham/MyWaifuWrapper/blob/main/src/main/java/me/goudham/MyWaifuClient.java)
+ `createDefault(apiKey)`
+ `build()`

### createDefault()

`createDefault(apiKey)` will provide a default implementation and return a MyWaifuClient ready to be used. Only 
the `apiKey` is required to instantiate MyWaifuClient.

```java
public class Main {
    private static void main(String[] args) {
        MyWaifuClient myWaifuClient = MyWaifuClient.createDefault("apiKey");
    }
}
```

### build()

`build()` is used to build the object from the ground up, allowing for the fine-tuning of properties within the
MyWaifuClient. Not all the additional properties need to specified within the builder but the bare minimum would be 
the `apiKey` within the Builder constructor and then `.build()`

```java
import me.goudham.MyWaifuClient;

import java.net.http.HttpClient;
import java.time.Duration;

public class Main {
    private static void main(String[] args) {
        // Bare Minimum (Would recommend using createDefault())
        MyWaifuClient myWaifuClient = new MyWaifuClient.Builder("apiKey").build();
        
        // Creating MyWaifuClient through Builder
        MyWaifuClient myWaifuClient = new MyWaifuClient.Builder("apiKey")
                .withVersion(HttpClient.Version.HTTP_2)
                .withConnectTimeout(Duration.ofMinutes(10))
                .build();
    }
}
```

# Usage 

TODO

# Download

Latest Stable Version: ![maven-central]
<p>Be sure to replace the **VERSION** key below with the one of the versions shown above!</p>

**Maven**
```xml
<!-- https://mvnrepository.com/artifact/me.goudham/MyWaifuWrapper -->
<dependency>
    <groupId>me.goudham</groupId>
    <artifactId>MyWaifuWrapper</artifactId>
    <version>VERSION</version>
</dependency>

```

**Gradle**
```gradle
repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/me.goudham/MyWaifuWrapper
    implementation group: 'me.goudham', name: 'MyWaifuWrapper', version: 'VERSION'
}
```

## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fsgoudham%2FMyWaifuWrapper.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fsgoudham%2FMyWaifuWrapper?ref=badge_large)
