# serveroptimization

# Getting started
- Clone this repo
- Build / package source
`mvn clean package`

- Start the server
`java -cp target/serveroptimization-1.0-SNAPSHOT.jar edu.ucl.nima.Server 4040`

- Run the client
`java -cp target/serveroptimization-1.0-SNAPSHOT.jar edu.ucl.nima.Client localhost 4040 meep`

![Getting Started](./docs/serveroptimization.gif)

# Warning messages
**Please note:**
The **Client** requires three arguments that specifies a server host, server port, and query. The **Server** requires one argument that specifies a port.

```
$ java -cp ./target/serveroptimization-1.0-SNAPSHOT.jar edu.ucl.nima.Client localhost 4040 
Usage: java EchoClient <host name> <port number> <query>

$ java -cp ./target/serveroptimization-1.0-SNAPSHOT.jar edu.ucl.nima.Server
Usage: java Server <port number>
```