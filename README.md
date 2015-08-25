# bitly-service
url encoding and redirection service


Generete encode link:
Request:
curl -X POST -H "Content-Type: application/json" -d "http://www.google.com" http://localhost:8080/rest/link

Response:
{"url":"http://www.google.com","encodeUrl":"b","links":[]}

Go to:  http://localhost:8080/b  -> redirect to -> http://www.google.com


Get all link:
Request:
$ curl -i -H "Accept: application/json" "http://localhost:8080/rest/link/all"


Response:
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 24 Aug 2015 19:20:21 GMT

{"linkList":[{"id":1,"url":"http://www.google.com","encodeUrl":"b"}],"links":[]}
