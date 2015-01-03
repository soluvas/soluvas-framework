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

## Recent Media

	./instagram instarecentmedia 868877415
	./instagram instarecentmedia -a some-access-token 868877415

Sample output:

	Meta: Meta [code=200, errorMessage=null, errorType=null]
	Headers: {null=HTTP/1.1 200 OK, Server=nginx, X-Ratelimit-Remaining=4995, Connection=Close, Pragma=no-cache, Date=Sat, 03 Jan 2015 11:12:08 GMT, X-Ratelimit-Limit=5000, Cache-Control=private, no-cache, no-store, must-revalidate, Vary=Cookie, Accept-Language, Accept-Encoding, Set-Cookie=ccode=ID; Path=/, Expires=Sat, 01 Jan 2000 00:00:00 GMT, Content-Length=30792, Content-Language=en, Content-Type=application/json; charset=utf-8}
	API limit status: 5000
	Remaining limit status: 4995
	Pagination: Pagination [depreciationWarning=null, minTagId=null, nextMaxId=846598396967240228_868877415, nextMaxTagId=null, nextMinId=null, nextUrl=https://api.instagram.com/v1/users/868877415/media/recent?access_token=x&max_id=846598396967240228_868877415]
	[ {
	  "caption" : {
	    "createdTime" : "1415838516",
	    "from" : {
	      "fullName" : "resmiati",
	      "id" : "868877415",
	      "profilePicture" : "https://instagramimages-a.akamaihd.net/profiles/profile_868877415_75sq_1389652853.jpg",
	      "username" : "nomiplaza"
	    },
	    "id" : "852437717121089942",
	    "text" : "Tinggal ukuran S dan XS.. buruan order kawanss.. @ Rp. 341000,-"
	  },
	  "comments" : {
	    "comments" : [ ],
	    "count" : 0
	  },
	  "createdTime" : "1415838516",
	  "id" : "852437716659716501_868877415",
	  "imageFilter" : "Normal",
	  "images" : {
	    "lowResolution" : {
	      "imageHeight" : 306,
	      "imageUrl" : "http://scontent-b.cdninstagram.com/hphotos-xpa1/t51.2885-15/927415_351701141673705_2073047185_a.jpg",
	      "imageWidth" : 306
	    },
	    "standardResolution" : {
	      "imageHeight" : 640,
	      "imageUrl" : "http://scontent-b.cdninstagram.com/hphotos-xpa1/t51.2885-15/927415_351701141673705_2073047185_n.jpg",
	      "imageWidth" : 640
	    },
	    "thumbnail" : {
	      "imageHeight" : 150,
	      "imageUrl" : "http://scontent-b.cdninstagram.com/hphotos-xpa1/t51.2885-15/927415_351701141673705_2073047185_s.jpg",
	      "imageWidth" : 150
	    }
	  },
	  "videos" : null,
	  "likes" : {
	    "count" : 1,
	    "likesUserList" : [ {
	      "bio" : null,
	      "fullName" : "Ema Maria",
	      "id" : "1570459542",
	      "profilePictureUrl" : "https://igcdn-photos-a-a.akamaihd.net/hphotos-ak-xap1/t51.2885-19/10809973_349210545260280_1859460224_a.jpg",
	      "userName" : "ema.maria.372",
	      "websiteUrl" : null
	    } ]
	  },
	  "link" : "http://instagram.com/p/vUd5Y-pcGV/",
	  "location" : null,
	  "tags" : [ ],
	  "type" : "image",
	  "user" : {
	    "bio" : "",
	    "fullName" : "resmiati",
	    "id" : "868877415",
	    "profilePictureUrl" : "https://instagramimages-a.akamaihd.net/profiles/profile_868877415_75sq_1389652853.jpg",
	    "userName" : "nomiplaza",
	    "websiteUrl" : ""
	  },
	  "userHasLiked" : false
	}, ...
