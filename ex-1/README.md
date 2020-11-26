# Example 1: Simple docker-compose on EC2

To run:

```
docker-compose up
```

This creates an nginx container accessible at http://localhost:8080 with the following routes that each map to a simple HelloWorld application in java, node, and asp.net core:
- http://localhost:8080/java
- http://localhost:8080/node
- http://localhost:8080/net
