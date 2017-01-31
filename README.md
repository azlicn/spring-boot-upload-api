# spring-boot-upload-api
Upload file API that run asychronously using Spring Boot Application<br>
Change upload directory in <code>application.properties</code>  and run <code>mvn spring-boot:run</code> 
<h2>1. cURL Testing</h2>
<code>$ curl -F files=@"/Users/azlicn/Desktop/image1.jpg" -F files=@"f://image2.jpg"  http://localhost:8080/api/uploadFile/
Successfully uploaded : image1.jpg | image2.jpg</code>
<h2>2. POSTMAN Client Testing</h2>
![alt tag](http://www.azlicn.com/postman.png)
