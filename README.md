<img src="https://user-images.githubusercontent.com/11555504/63654181-88b75100-c77f-11e9-9b68-e85c2969923e.png" width="50" height="50" />


# mektup

This project is a eventbus for Java Spring RESTFul services

# Getting Started :sunglasses:

## Usage :rocket:

```java
@SpringBootApplication
@MektupScan("com.mektup.test")
public class TesterApplication {

	public static void main(String[] args) throws MektupException {
		ApplicationContext context = SpringApplication.run(TesterApplication.class, args);
		Mektup.initialize(TesterApplication.class, context);
	}

}
```

## Super Simple :checkered_flag:

Publisher

```java
EventCreator publisher = new EventCreator();
try {
    publisher.create(001L, "{ \"id\": 1, \"name\":\"Guven\" }".getBytes());
} catch (EventException e) {
    //
}
```

Subscriber

```java
@EventSubscriberService(eventId = 001L, queue = "TEST")
@EventRequestMapping(value = "/home2")
public String home2(Deneme deneme){
    System.out.println("deneme2");
    return "deneme2";
}
```

## Contributing

1. Fork it ( https://github.com/guvencenanguvenal/katip/fork )
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create a new Pull Request

## Contributors

- [guvencenanguvenal](https://github.com/guvencenanguvenal) Güven Cenan Güvenal - creator, maintainer

