# Example 1: Simple docker-compose on EC2

![Diagram of architecture](https://lucid.app/publicSegments/view/fdbf0a3a-6bf3-4e2a-bd59-2c9d8e9f139e/image.png)

A docker stack consisting of:
- nginx
- Hello World in Spring Boot (Java)
- Hello World in JavaScript (node/express)
- Hello World in .Net Core (Asp.Net)

This example is very simple on the AWS side, leaving a minimal amount of infrastrucure issues when deploying to AWS. This will be foundational for us branching out into ECS and Lambdas.

## Assumptions
- Code is correct
- Internal Firewall is open
- nginx routing is correct

## Happy Path
- http://<ip>:8080/java => "Hello from Java!"
- http://<ip>:8080/net => "Hello from .Net!"
- http://<ip>:8080/node => "Hello from Node!"

## Misconfiguration

Since everything is in a docker stack inside an EC2 instance, and the stack and the EC2 instance are configured correctly, the only room for error is on the AWS infrastructure side. There are three main networking security configurations that will block access to your EC2 instance:
- Security Groups (resource)
- Network Access Control Lists (vpc)
- Route Tables (subnet)

### Security Groups

![Diagram of misconfigured Security Groups](https://lucid.app/publicSegments/view/b90a7603-4377-4984-b378-ae65de26fa1f/image.png)

Security Groups serve as a whitelist for access into a resource at the instance level, in this case an EC2 instance. When you try to access a resource by a port that is not whitelisted, **the result will be a connection timeout**.

### Network Access Control List (NACL)

![Diagram of misconfigured NACL](https://lucid.app/publicSegments/view/dbe61594-a5d7-4e5a-ab63-eae2950560c7/image.png)

Network Access Control Lists serve as a rule set for a VPC. They're useful for restricting access across an entire VPC to specific IPs or inbound/outbound ports, or for blacklisting certain IPs or ports. While security groups are stateless (opening a port applies to both inbound and outbound traffic), NACLs are stateful, and have a separate rule set for inbound and outbound traffic. If a NACL is misconfigured, either on the inbound or outbound side, **for HTTP traffic the result will be a connection timeout**. Other protocols can have more nuance; UDP, for example, could be received just fine with just an inbound rule.

### Route Tables

Route tables, as the name implies, allow routing of inbound and outbound traffic based on rules. According to the AWS documentation, *A public subnet is a subnet that's associated with a route table that has a route to an Internet gateway*. **If there is not a route defined for inbound traffic via the internet gateway, the result will be a connection timeout**.

### User error

Sometimes it's the client itself that contains the issue. If you try to connect to the host via a port that:
- Is open in the Security Group
- Is Allowed in the NACL for the VPC

The result will most likely be **Connection Refused**. This can help narrow down at what layer the request is failing.

If you have the wrong IP, the result will most likely be **Connection Timeout**. Theoretically, however, you could hit another server whose firewall and configuration do not restrict that port, but the host does not have a service listening on that port.

The possiblities are endless here, but some common errors are:
- `NAME_NOT_RESOLVED`, `no such host`: The DNS name is incorrect or misconfigured
- `SSL_PROTOCOL_ERROR`: Typically when trying to connect to a host:port via https that's actually http
- `ACCESS_DENIED`: Trying to access an endpoint that requires some sort of Authorization that was not provided

## Tracking Down Errors



To run:

```
docker-compose up
```

This creates an nginx container accessible at http://localhost:8080 with the following routes that each map to a simple HelloWorld application in java, node, and asp.net core:
- http://localhost:8080/java
- http://localhost:8080/node
- http://localhost:8080/net
