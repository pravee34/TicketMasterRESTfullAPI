# Ticket Service Homework

The homework is to implement a simple ticket service that facilitates the discovery, temporary hold, and final reservation of seats within a high-demand performance and the requirements follow as shown below.
1. Find the number of seats available within the venue
Note: available seats are seats that are neither held nor reserved.
2. Find and hold the best available seats on behalf of a customer
Note: each ticket hold should expire within a set number of seconds.
3. Reserve and commit a specific group of held seats for a customer

## Requirements

1. The ticket service implementation should be written in Java.
2. The solution and tests should build and execute entirely via the command line using either MAVEN or GRADLE as the build tool.
3. A README file should be included in your submission that documents your assumptions and includes instructions for building the solution and executing the tests
4. Implementation mechanisms such as disk-based storage, a REST API, and a front-end GUI are not strictly required.

## Assumptions

1.Assuming one Venue, one event and one section and seating numbers goes as rows (in the example it shows 9 rows and 34 columns) so the seating number start with 11 meaning first row and first column and it goes continue to 934, which is totally 306 seats available in the venue.

2.The best match of seats for member is - possible combination of seats and based on seats at venue designed.   

3.90 seconds used to expire the hold orders, after 90sec hold seats will be expired and available for next request.

## Prerequisites

1.Install Java 8, Please follow Installation steps for Java8 in Ubuntu and the output for "java -version" is displayed as "1.8.0_111" 
	```
		$ sudo add-apt-repository ppa:webupd8team/java
		$ sudo apt-get update
		$ sudo apt-get install oracle-java8-installer
		$ java -version
	```
	
2.Install and configure MAVEN 

	```	$ sudo apt-get install maven
	```
	
3.Set all the necessary paths and below path variables may vary by each user environment or system, however these setup is key to for further steps.

	```
	   $export MAVEN_HOME=/home/{username}/MAVEN/apache-maven-3.3.3
		$export PATH=$PATH:$MAVEN_HOME/bin 
		$export JAVA_HOME=/usr/lib/jvm/java-8-oracle
		$export PATH=$PATH:$JAVA_HOME/bin
	```

## Downloading the source and Installing

1.Make directory and get ready for install and build

	```
	$mkdir /home/{user id}/TicketService
	```

2.Download and unzip the source repository for this guide, or clone from GitHub using below command

	```
	$cd /home/{user id}/TicketService
	$git clone https://github.com/pravee34/TicketMasterRESTfullAPI.git
	```
 folder structure:
	![alt tag](https://github.com/pravee34/TicketMasterRESTfullAPI/blob/master/1.projectstructure.JPG)
3.Make sure download is Successful and your GIT status should confirm. 

	```$git status```
		
4.MAVEN Clean the project, and below command should provide the BUILD SUCCESS status and if test fails, please review it might be due to JAVA or MAVEN settings. 

	```
	$mvn clean
	```
	
5.Execute the below command for MAVEN package,and it should provide the BUILD SUCCESS status and all the test should PASS status. if any test fails then review your configuration once again. 

	```
	$mvn package
	```

6.Run the application Jar using below command.

	```
	$java -jar target\TicketMasterRESTfullAPI-0.0.1-SNAPSHOT.jar
	```
7. server would be running on Port 7777 in this process, if this port does not support, please change it and re-run the steps from Step:4. Please refer application.properties under /src/main/resources to change the port. 

8. once server is started ,then please proceed with below steps

## Running the tests for each requirements

1.Find the number of seats available within the venue and available seats = neither held nor reserved and expected 

	Unix or Windows:
	```
	$curl http://localhost:7777/tickets/availableseats
	```
	
	```
	$304
	```
2.Find and hold the best available seats on behalf of a customer and each ticket hold should expire within a 90 seconds.
	 
2a.Create a input file for POST process with below contents with file name - "holdPOSTRequestJSONfile.txt" 
	
	  	```
	 	{"numSeats":"2","customerEmail":"monkey@example.com"}
	 	```	 

2b.verify the contents of the file
	 
	  ```
	  	$cat holdPOSTRequestJSONfile.txt
	  ```
	   	 
2d.Make sure the output shown as below both WINDOWS or UNIX
	 	
	 	```
	 		${"numSeats":"2","customerEmail":"monkey@example.com"}
	 	```
	 	
2e.execute the POST shown below same for WINODWs or UNIX:
	 
	 	 ```
	 	 		$curl -X POST -d @holdPOSTRequestJSONfile.txt http://localhost:7777/tickets/hold --header "Content-Type:application/json"
	 	 		```
	 	 			 
f.The final expected output and same for UNIX or WINDOWS:

	 	```
	 	${"numSeats":2,"customerEmail":"monkey@example.com","orderNumber":98793}
	 	```
	 	
	 
	
3.Reserve and commit a specific group of held seats for a customer

3a.Create a file as shown in step 2,make sure you are passing order number correctly from the previous output, in this process 98793 is my order number and my next file is updated with 98793.  			
	
			```
			{"orderNumber":"98793","customerEmail":"monkey@example.com"}
			```
	
3b.Execute below command : 
				
			```
				curl -X PUT -d @reservationsPUT.txt http://localhost:7777/tickets/reservations --header "Content-Type:application/json"
				```
				
3c.Expected output should show as 
				
				```
				{"numSeats":0,"customerEmail":"monkey@example.com","orderNumber":98793}
				```
				
3d.check back and see your reservation is confirmed: 
				
				```curl http://localhost:7777/tickets/availableseats```
	
	e. output expected as ```302```
## Wishlist
   The searching algorithm based on the previous visits and customer GEO location information (parking lot or travel directions).
   Based on the customer attributes whether customer looks for Quality or Price
## Thank you Note!!!
Thanks for code challenge and really enjoyed working on it. 
	
	