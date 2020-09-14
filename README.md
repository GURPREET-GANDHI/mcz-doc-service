# mcz-doc-service
DOC Service Operation


Exposed to User: Doc Service
port: 8081

read:
http://localhost:8081/read/{id}
example:
http://localhost:8081/read/5

store:
http://localhost:8081/store/fileType/{Type}
http://localhost:8081/store/fileType/CSV
http://localhost:8081/store/fileType/XML

Storage: h2 db in memory

Grpc Server: 9090

Configurable in DocManager


            validation                   encodes
DOCService --------------> DocManager ---------------->   H2 Database

1.Store ---------->Grpc Call-->
2.Update--------->Grpc Call -->
3.Read ---------> Rest Call -->


upscaling:

A service discovery applications service can upgrade the doc service/doc manager service as needed as both run on different port
Similarly Grpc Servers can be run on different ports if the bottle nect occurs. 

If database is a bottle neck then it can be change to clusted database like maria db,postgres, mongo, redis for more throughput.
Caching can be enhances as needed.

Security: RPC call use internal messaging of Proto Buffs.
For Db operation basic encoding in Base64 is done( which can be enhanced if needed)
