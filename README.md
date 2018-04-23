# SpringBootWebApp

This is a sample web application devised to run on Docker Swarm, which is one of the leading container orchestration tools. Also the same application can be run in AWS with the provided cloudformation stack.

For a quick start, setup a Docker Swarm, then from the manager node, run the application directly via below command:

docker stack deploy -c "docker-cloud.yml" <name_of_the_stack>
