# Ow! My AWS is Broken : Why your code doesn't run in the Cloud
> Money goes in, Cloud comes out; you can't explain that.

Explore the **full** stack of cloud development as we look at common architecture patterns, their implementation in AWS, and the various ways you can mess it up.

## Who am I

- [Solutions Architect - Software Engineering @ Slalom Build](https://www.linkedin.com/in/lnicho/)
- 5 years experience ignoring documentation, mishandling AWS
- Experience taking existing environments from an unknown state to a more or less known state
- Certified AWS Solutions Architect Associate

## What we'll cover

### Languages/Frameworks and Software
- Java / Spring Boot
- JavaScript / Node + Express
- C# / ASP.Net Core
- docker
- nginx
- PostgreSQL

### AWS Services
- EC2
- ECS (Fargate)
- RDS
- SQS
- SNS
- DynamoDB

## Debunking the "Full Stack" Developer

![Full Stack Developer](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190626123927/untitlsssssed.png)

> Frontend, Backend, and Persistence. These were the ingredients chosen to create the perfect Full Stack Developer

- I used to be a big fan of the [Developer Roadmap](https://github.com/kamranahmedse/developer-roadmap#introduction), but it leaves a big gap before you're truly effective
- Need to know how to write software **and** get it into an environment where someone can use it

## Goal : Autonomous Developers

- Branch out and learn the Full Stack, including the infrastructure your code runs on
- Nothing worse than hitting a wall with your code not working and handing it off to someone else to solve
    - They don't have the context on what you built
    - You don't have the context on how it's supposed to be wired up
    - You're left sitting on your hands while you wait for them to catch up and _hopefully_ find a fix

![You can do it!](https://i.pinimg.com/originals/11/f2/37/11f237c545ef6f9b046b30a83dd7f482.jpg)

> In the interest of hyporcrisy, we're going to ignore the frontend and look at backing APIs and their implementations in AWS

# [Example 1](https://github.com/lnicho/ow-my-aws-is-broken/tree/main/ex-1#example-1-simple-docker-compose-on-ec2)
