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

This is an Unofficial Asynchronous API Wrapper for [MyWaifuList](https://mywaifulist.moe/dash) 

# Disclaimer

Given that MyWaifuList is a primarily user-driven website and this API is currently in an Alpha state,
the data returned **may not be** fully complete and at its best quality

# Configuration

There are 2 ways to create and configure the [MyWaifuClient](https://github.com/sgoudham/MyWaifuWrapper/blob/main/src/main/java/me/goudham/MyWaifuClient.java)
+ `createDefault(apiKey)`
+ `build()`

## createDefault()

`createDefault(apiKey)` will provide a default implementation and return a MyWaifuClient ready to be used. Only 
the `apiKey` is required to instantiate MyWaifuClient.

```java
public class Main {
    private static void main(String[] args) {
        MyWaifuClient myWaifuClient = MyWaifuClient.createDefault("apiKey");
    }
}
```

## build()

`build()` is used to build the object from the ground up, allowing for the fine-tuning of properties within the
MyWaifuClient. Not all the additional properties need to specified within the builder. However, the bare minimum would be 
the `apiKey` within the Builder constructor and then `.build()`

```java
import me.goudham.MyWaifuClient;

import java.net.http.HttpClient;
import java.time.Duration;

public class Main {
    private static void main(String[] args) {
        // Bare Minimum Config 
        // (Would recommend using createDefault())
        MyWaifuClient myWaifuClient = new MyWaifuClient.Builder("apiKey").build();
        
        // Creation Through Builder
        MyWaifuClient myWaifuClient = new MyWaifuClient.Builder("apiKey")
                .withVersion(HttpClient.Version.HTTP_2)
                .withConnectTimeout(Duration.ofMinutes(10))
                .build();
    }
}
```

# Usage 

Once **MyWaifuClient** has been configured properly, many methods are available for you to get the data that you wish.
Each method links up to an endpoint that is listed within the [MyWaifuList API Docs](https://mywaifulist.docs.stoplight.io/api-reference)

With every method executed from the **MyWaifuClient**, a [Response]() object will be returned. The object will house
the type of entity, response status code, and the response body. This allows for extreme flexibility as the raw response 
and marshalled entity are available to the user.

The documentation for each method provides clear and detailed information on what arguments to pass in, please
do also refer to that. 

Shown below are some examples of how you can retrieve data: 

```java
public class Main {
    public static void main(String[] args) throws APIMapperException, APIResponseException {
        // ... myWaifuClient has been instantiated
        
        // getWaifu(Integer id) 
        Response<Waifu> waifuResponse = myWaifuClient.getWaifu(7);
        Integer waifuResponseCode = waifuResponse.getStatusCode();
        String waifuResponseBody = waifuResponse.getBody();
        Waifu waifu = waifuResponse.getModel();
        
        // getRandomWaifu()
        Response<FilteredWaifu> randomWaifuResponse = myWaifuClient.getRandomWaifu();
        Integer randomWaifuResponseCode = randomWaifuResponse.getStatusCode();
        String randomWaifuResponseBody = randomWaifuResponse.getBody();
        FilteredWaifu randomWaifu = randomWaifuResponse.getModel();
        
        // getSeasonalAnime()
        Response<List<FilteredSeries>> seasonalAnimeResponse = myWaifuClient.getSeasonalAnime();
        Integer seasonalAnimeResponseStatusCode = seasonalAnimeResponse.getStatusCode();
        String seasonalAnimeResponseBody = seasonalAnimeResponse.getBody();
        List<FilteredSeries> seasonalAnime = seasonalAnimeResponse.getModel();
    
        // getUserWaifus(Integer id, WaifuListType waifuListType, Integer pageNum)
        Response<PaginationData<FilteredWaifu>> userWaifusLikedResponse = myWaifuClient.getUserWaifus(1, WaifuListType.LIKED, 1);
        Integer userWaifusLikedResponseStatusCode = userWaifusLikedResponse.getStatusCode();
        String userWaifusLikedResponseBody = userWaifusLikedResponse.getBody();
        PaginationData<FilteredWaifu> userWaifusLiked = userWaifusLikedResponse.getModel();
    }
}
```

# Installation

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
