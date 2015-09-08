# png-issue


It seems that Play Framework (2.4 and previous versions such as 2.3.8) using Java 8 does not ascertain correctly the content type when uploading files of type png.  It works with other formats such as jpg and gif.

Start up the application using `activator` and then `run` (defaults to port 900).  

Run the following curl requests from the test folder directory (example images are located there), you'll see the content type returned in the JSON payload being correctly identified as `image/gif` and `image/jpg` respectively.

1. `curl -v -F file=@lake.gif http://localhost:9000/`
2. `curl -v -F file=@lake.jpg http://localhost:9000/`

Now run this curl request:

1.  `curl -v -F file=@ok.png http://localhost:9000/`  

You'll see that for png files the return type is: `application/octet-stream` where as I would expect `image/png` 
