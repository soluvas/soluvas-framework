# Soluvas Instagram

## CLI Tool

Build:

	mvn dependency:copy-dependencies compile

Set default configuration in `application.properties` in current directory.
You can use `application.properties` in classpath if you use IDE to run it and add your project to launcher's classpath.

Run:

	./instagram instaauth

You can also specify the API Key, API Secret, and Callback URI via command line arguments:

	./instagram instaauth -i ... -s ... -c http://www.bippo.co.id/instagram/auth

## Authorize

	./instagram instaauth
	
## Search User(s)

	./instagram instasearch nomiplaza
	./instagram instasearch -a some-access-token nomiplaza

Sample output:

	Meta: Meta [code=200, errorMessage=null, errorType=null]
	Headers: {null=HTTP/1.1 200 OK, Server=nginx, X-Ratelimit-Remaining=4998, Connection=Close, Pragma=no-cache, Date=Sat, 03 Jan 2015 10:46:41 GMT, X-Ratelimit-Limit=5000, Cache-Control=private, no-cache, no-store, must-revalidate, Vary=Cookie, Accept-Language, Accept-Encoding, Set-Cookie=ccode=ID; Path=/, Expires=Sat, 01 Jan 2000 00:00:00 GMT, Content-Length=368, Content-Language=en, Content-Type=application/json; charset=utf-8}
	API limit status: 5000
	Remaining limit status: 4998
	Pagination: null
	[ {
	  "firstName" : null,
	  "id" : "868877415",
	  "lastName" : null,
	  "profilePictureUrl" : "https://instagramimages-a.akamaihd.net/profiles/profile_868877415_75sq_1389652853.jpg",
	  "userName" : "nomiplaza",
	  "fullName" : "resmiati",
	  "website" : "http://facebook.com/nomiplaza",
	  "bio" : "Cute Trendy Stylish Fashion for girls and women | Instagram: nomiplaza"
	} ]
