# Project "Minions" Test Cases

### Table of Contents

**[Test Cases - Sprint 1](#test-cases---sprint-1)**

**[Report 1 - Sprint 1](#report-1---sprint-1)**

**[Report 2 - Sprint 1](#report-2---sprint-1)**

**[Test Cases - Sprint 2](#test-cases---sprint-2)**

**[Report 1 - Sprint 2](#report-1---sprint-2)**

**[JUnit Report - Sprint 2](#junit-report---sprint-2)**

**[Test Cases - Sprint 3](#test-cases---sprint-3)**

**[Report 1 - Sprint 3](#report---sprint-3)**

**[Test Cases - Sprint 4](#test-cases---sprint-4)**

### Test Cases - Sprint 1

| Project Name:    | Minions             | Test Designed by:    | Srilekha S    |
| ---------------- | ------------------- | -------------------- | ------------- |
| Module Name:     | Sign Up and Sign In | Test Designed date:  | Feb 15th,2022 |
| Release Version: | V1                  | Test Executed by:    | Srilekha S    |
|                  |                     | Test Execution date: | Feb 18th,2022 |

| Pre-condition | NA |
| ------------- | -- |
| Dependencies: | NA |
| Test Priority |    |

**UI**

| Test Case# | Test Title         | Test Summary                                                                 | Test Steps                                                                                                                                                                                                                                                                 | Test Data                                | Expected Result                                                                                                 | Actual Result                                         | Status | Notes |
| ---------- | ------------------ | ---------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------- | --------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- | ------ | ----- |
| MNTC01     | App URL validation | Validation of application URL                                                | Take a valid URL and check if we are landing on homepage                                                                                                                                                                                                                   | URL:http://localhost:8080/               | We need to land on our homepage URL                                                                             | Landed Successfully                                   | Passed |       |
| MNTC02     | Invalid App URL    | Validation of invalid app URL                                                | Try using an invalid URL and verify we are still able to navigate to our application homepage                                                                                                                                                                              |                                          | The invalid URL should not enroute us to our application homepage                                               | Didnt enroute successfully                            | Passed |       |
| MNTC03     | Sign In Page       | Verify logging in with Valid Username and Password                           | Enter Valid Username and Password and click on login/Ok button                                                                                                                                                                                                             | Username:bob12345<br>Password: P@ssword1 | User should able to successfully login                                                                          | Successfullly logged In                               | Passed |       |
| MNTC04     | Sign In Page       | Verify logging in with valid Username but invalid password                   | Enter valid username and invalid password then click on Ok button                                                                                                                                                                                                          |                                          | User should not be able to login successfully.                                                                  | Successfullly  not logged In                          | Passed |       |
| MNTC05     | Sign In Page       | Verify logging in with invalid Username but valid password                   | Enter invalid username and valid password then click on Ok button                                                                                                                                                                                                          |                                          | User should not be able to login successfully.                                                                  | Successfullly  not logged In                          | Passed |       |
| MNTC06     | Sign In Page       | Verify logging in with invalid Username and invalid password                 | Enter invalid username and invalid password then click on Ok button                                                                                                                                                                                                        |                                          | User should not be able to login successfully.                                                                  | Successfullly  not logged In                          | Passed |       |
| MNTC07     | Sign Up page       | Verify new User to be provided with 'Sign Up" link to sign up to the program | Validate if new User is able to click on "Sign Up" link and navigate to registration page.                                                                                                                                                                                 |                                          | User should able to successfully navigate to registration page.                                                 | Successfully navigated to Registration page           | Passed |       |
| MNTC08     | Sign Up page       | Verify all the mandatory fields on Registration page                         | Validate all the below fields are filled up on Registration page -<br>1.Username<br>2.Password<br>3.Confirm Password.<br>4.Already User ?  text beneath Confirm password with "Sign In" link                                                                               |                                          | User should able to successfully fill all the mandatory fields and click on "Ok" button                         | Successfully filled all the details                   | Passed |       |
| MNTC09     | Sign Up page       | Verify negative check on mandatory fields on Registration page               | Validate by not filling up any of above fields and page should prompt you to fill it to finish your registration                                                                                                                                                           |                                          | User should be prompted with "Fields should not be empty" when on clicking ok button without filling up details | Successful display of "Fields should not be empty"    | Passed |       |
| MNTC10     | Sign Up page       | Verify the Username strength created                                         | Validate the Username entered meets up the criteria of -<br>1.Should be minimum of 8 chars in length.<br>2.Atleast one numeric or special character.<br>3.Username shall not include any spaces.<br>4.Username must contain at least one upper case letter.                |                                          | User should be able to successfully create a Username which meets up the criteria.                              | Successfully created User with specific criteria.     | Passed |       |
| MNTC11     | Sign Up page       | Verify the Password strength created                                         | Validate the password entered meets up the criteria of strong password-<br>1.Should be minimum of 8 chars in length.<br>2.Atleast one numeric or special character.<br>3.Password shall not include any spaces.<br>4.Password must contain at least one upper case letter. |                                          | User should be able to successfully create a password which meets up the strong password criteria.              | Successfully created password with specific criteria. | Passed |       |

**API**

| Test Case# | Test Title | Test Summary             | Test Steps 																					| Test Data                                																																																											  | Expected Result                                                                 | Actual Result                                         | Status | Notes |
| ------ | --- | ----------------------------------- | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------- | ------ | --- |
| MNTC12 | API | Valid the Host URL                  | Validate the Local server  http://localhost:8080<br><br>                                   | [http://localhost:8080/](http://localhost:8080/)                                                                                                                                                                                                                                      | User should successfully connect to Local server                               | User successfully connects to server                          | Passed |  |
| MNTC13 | API | Valid Username and Password         | Validate when provided valid Username and password,we get a valid response                 | [http://localhost:8080/users/signin?username=bob&password=password<br><br>http://localhost:8080/users/signup?username=bob&password=password<br>http://localhost:8080/users/signout?username=bob&password=password](http://localhost:8080/users/signin?username=bob&password=password) | Valid response or status code should be<br>: 200-Ok                            | Response code is successful as 200 OK                         | passed |  |
| MNTC14 | API | Valid Username and Invalid Password | Validate when provided valid Username and Invalid password,we get a corresponding response | [http://localhost:8080/users/signout?username=bob&password=passw](http://localhost:8080/users/signout?username=bob&password=passw)                                                                                                                                                    | For Incorrect User details<br>401 – Access denial due to incorrect credentials | Response code is successful for invalid credentials as 401 OK | passed |  |
| MNTC15 | API | Invalid Username and valid Password | Validate when provided Invalid Username and valid password,we get a corresponding response | [http://localhost:8080/users/signout?username=bob&password=passw](http://localhost:8080/users/signout?username=bob&password=passw)                                                                                                                                                    | For Incorrect User details<br>401 – Access denial due to incorrect credentials | Response code is successful for invalid credentials as 401 OK | passed |  |
| MNTC16 | API | Invalid URL validation              | When provided invalid URL, Corresponding Status code to be displayed as response           | [http://localhost:8080/users/signout?username=&password=](http://localhost:8080/users/signout?username=bob&password=passw)                                                                                                                                                            | 400 – The request was not properly formed                                      | Resposne code is successful for Invalid URL as 400            | passed |  |
| MNTC17 | API | Server connection validation        | Validate when server connection fails,corresponding Status code is displayed               |                                                                                                                                                                                                                                                                                       | 500 – The server threw an error                                                | Response code is successful forServer connection error as 500 | passed |  |

**DB**

| Test Case# | Test Title | Test Summary                     | Test Steps                                                                     | Test Data | Expected Result                                                                                                                                                                                                                           | Actual Result                         | Status | Notes |
| ---------- | ---------- | -------------------------------- | ------------------------------------------------------------------------------ | --------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------- | ------ | --- |
| MNTC18     | Database   | Validate the Database connection | Validate the credentials are stored successfully on registering for web portal |           | Credentials should satisfy the below criteria:<br>Table: user<br> Column: userid integer – primary key unique sequence number<br> Column: username string – user name from sign up<br> Column: password string – password from sign up | Details are successfully stored in DB | Passed |  |

### Report 1 - Sprint 1 

| Test Case# | Test Title         | Status      | Ran By | Comments |
| ---------- | ------------------ | ----------- | ------ | -------- |
| MNTC01     | App URL validation | Not Started | Jaswin |          |
| MNTC02     | Invalid App URL    | Not Started | Jaswin |          |
| MNTC03     | Sign In Page       | Not Started | Jaswin |          |
| MNTC04     | Sign In Page       | Not Started | Jaswin |          |
| MNTC05     | Sign In Page       | Not Started | Vikram |          |
| MNTC06     | Sign In Page       | Not Started | Vikram |          |
| MNTC07     | Sign Up page       | Pass        | Vikram |          |
| MNTC08     | Sign Up page       | Pass        | Vikram |          |
| MNTC09     | Sign Up page       | Pass        | Vikram |          |
| MNTC10     | Sign Up page       | Pass        | Vikram |          |
| MNTC11     | Sign Up page       | Pass        | Lekha  |          |
| MNTC12     | API                | Pass        | Lekha  |          |
| MNTC13     | API                | Pass        | Lekha  |          |
| MNTC14     | API                | Pass        | Lekha  |          |
| MNTC15     | API                | Pass        | Lekha  |          |
| MNTC16     | API                | Pass        | Lekha  |          |
| MNTC17     | API                | Pass        | Lekha  |          |
| MNTC18     | Database           | Pass        | Jaswin |          |

![Report 1 - Sprint 1](/report1sprint1.png)

| Total Test cases | Title              | Failed | Passed | Not Started |
| ---------------- | ------------------ | ------ | ------ | ----------- |
| 2                | App URL validation | 0      | 2      | 0           |
| 4                | Sign In Page       | 0      | 0      | 4           |
| 5                | Sign Up page       | 0      | 5      | 0           |
| 6                | API                | 1      | 5      | 0           |
| 1                | Database           | 0      | 1      | 0           |

### Report 2 - Sprint 1

| Test Case# | Test Title         | Status | Ran By | Comments |
| ---------- | ------------------ | ------ | ------ | -------- |
| MNTC01     | App URL validation | Pass   | Lekha  |          |
| MNTC02     | Invalid App URL    | Pass   | Lekha  |          |
| MNTC03     | Sign In Page       | Pass   | Lekha  |          |
| MNTC04     | Sign In Page       | Pass   | Lekha  |          |
| MNTC05     | Sign In Page       | Pass   | Vikram |          |
| MNTC06     | Sign In Page       | Pass   | Vikram |          |
| MNTC07     | Sign Up page       | Pass   | Vikram |          |
| MNTC08     | Sign Up page       | Pass   | Vikram |          |
| MNTC09     | Sign Up page       | Pass   | Vikram |          |
| MNTC10     | Sign Up page       | Pass   | Vikram |          |
| MNTC11     | Sign Up page       | Pass   | Lekha  |          |
| MNTC12     | API                | Pass   | Jaswin |          |
| MNTC13     | API                | Pass   | Jaswin |          |
| MNTC14     | API                | Pass   | Jaswin |          |
| MNTC15     | API                | Pass   | Jaswin |          |
| MNTC16     | API                | Pass   | Jaswin |          |
| MNTC17     | API                | Pass   | Jaswin |          |
| MNTC18     | Database           | Pass   | Jaswin |          |

![Report 2 - Sprint 1](/report2sprint1.png)

| Total Test cases | Title              | Failed | Passed | Not Started |
| ---------------- | ------------------ | ------ | ------ | ----------- |
| 2                | App URL validation | 0      | 2      | 0           |
| 4                | Sign In Page       | 0      | 4      | 0           |
| 5                | Sign Up page       | 0      | 6      | 0           |
| 6                | API                | 0      | 5      | 0           |
| 1                | Database           | 0      | 1      | 0           |

### Test Cases - Sprint 2

| Project Name:    | Minions                   | Test Designed by:    | Srilekha S    |
| ---------------- | ------------------------- | -------------------- | ------------- |
| Module Name:     | Landing and Settings page | Test Designed date:  | Mar 15th,2022 |
| Release Version: | V1                        | Test Executed by:    | Srilekha S    |
|                  |                           | Test Execution date: | Mar 18th,2022 |

| Pre-condition | Must Successfully Login |
| ------------- | ----------------------- |
| Dependencies: | Testcases from Sprint 1 |
| Test Priority |                         |

**UI**

| Test Case# | Test Title                             | Test Summary                      | Test Steps                                                                     | Test Data                                   | Expected Result                                                                                                                                                                                                                                                                      | Actual Result                                                                                                                                                                                                                                                  | Status | Notes |
| ---------- | -------------------------------------- | --------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ | ----- |
| MCTC19     | App URL validation                     | Validation of application URL     | Take a valid URL and check if we are landing on homepage                       | [https://newsapi.org](https://newsapi.org/) | We need to navigate to our landing page URL                                                                                                                                                                                                                                          | Successfully navigated to URL                                                                                                                                                                                                                                  | Pass   |       |
| MCTC20     | Application default content validation | Default content validation        | Validate the content available on URL when not logged in                       |                                             | App Url should be able to show:<br> list of news articles on the landing page with "sign in" link display on right top of the page                                                                                                                                                   | Successful display of list of articles on landing page with respective links                                                                                                                                                                                   | Pass   |       |
| MCTC21     | Application default content validation | Default content validation        | Validate the content available on URL when logged in                           |                                             | App Url should be able to show:<br> list of news articles on the landing page with "Username"  displayed on right top of the page                                                                                                                                                    | Successful display of Username and corresponding elements on Landing page.                                                                                                                                                                                     | Pass   |       |
| MCTC22     | Application default content validation | Default content validation        | Validate the elements present on landing page when logged In and not logged In |                                             | When not logged in below elements are to be displayed on landing page:<br>1\. My App<br>2.Refresh button<br>3.Sign in link<br>When Logged in :<br>1\. My App<br>2.Regresh button<br>3.Settings button.<br>4\. Username text on right top.<br>5.Sign out link above the Username text | Successfull display of :<br>1\. My App<br>2.Refresh button<br>3.Sign in link when  not logged In and<br>When Logged in :<br>1\. My App<br>2.Regresh button<br>3.Settings button.<br>4\. Username text on right top.<br>5.Sign out link above the Username text | Pass   |       |
| MCTC23     | Setting page Validation                | Settings page content validation  | Click on "Settings" link on landing page                                       |                                             | When clicked on "Settings"button, it should successfully navigate to Settinngs page                                                                                                                                                                                                  | Successful navigation to settings page.                                                                                                                                                                                                                        | Pass   |       |
| MCTC24     | Setting page Validation                | Settings page content validation  | Validate content on Settings page                                              |                                             | Validate if the User is able to view the below preferences on settings page:<br>With Text :" Choose your areas of interest"<br>1\. General.<br>2\. Business.<br>3\. Entertainment.<br>4\. Health.<br>5\. Science.<br>6\. Sports.<br>7\. Technology and<br> Ok and Cancel buttons.    | Successful display of all the categories:<br>" Choose your areas of interest"<br>1\. General.<br>2\. Business.<br>3\. Entertainment.<br>4\. Health.<br>5\. Science.<br>6\. Sports.<br>7\. Technology and<br> Ok and Cancel buttons.                            | Pass   |       |
| MCTC25     | Setting page Validation                | Settings page functionality check | Validate selection of preferences                                              |                                             | Validate if the User is able to select atleast one preferance from the mentioned list                                                                                                                                                                                                | By default selection of alteast one preferance is successfully displayed                                                                                                                                                                                       | Pass   |       |
| MCTC26     | Setting page Validation                | Settings page functionality check | Validate selection of preferences                                              |                                             | Validate if the User is able to select multiple preferences on mentioned list.                                                                                                                                                                                                       | Successful selection of multiple preferences                                                                                                                                                                                                                   | Pass   |       |
| MCTC27     | Setting page Validation                | Settings page functionality check | Validate Ok button                                                             |                                             | Upon selection of preferences, User should able to successfully click on "Ok" button and navigate to Landing page                                                                                                                                                                    | Page navigates successfully to Landing page upon selection of preferences and clicking OK                                                                                                                                                                      | Pass   |       |
| MCTC28     | Setting page Validation                | Settings page functionality check | Validate Cancel button                                                         |                                             | Upon selection of preferences, User should able to successfully click on "Cancel" button and to re-select the prefrences again on settings page                                                                                                                                      | Upon clicking Cancel, User is successfully able to re select the preferances.                                                                                                                                                                                  | Pass   |       |
| MCTC29     | Setting page Validation                | Settings page functionality check | Validate checked "Areas of Interest"                                           |                                             | After selection of "Areas of Interest", navigate back to Settigns page and see if the options are still checked                                                                                                                                                                      | upon certain selection and navigating back to settings page, we could not see selected preferances                                                                                                                                                             | Fail   |       |

**API**

| Test Case# | Test Title | Test Summary                          | Test Steps                                                                                 | Test Data | Expected Result            													| Actual Result        	  | Status | Notes |
| ---------- | ---------- | ------------------------------------- | ------------------------------------------------------------------------------------------ | --------- | ------------------------------------------------------------------------------ | ----------------------- | ------ | ----- |
| MCTC30     | API        | Valid the Host URL                    | /new/{user}/{category}                                                                     |           | Valid response or status code should be<br>: 200-Ok                            | Response code is 200-OK | Pass   |  |
| MCTC31     | API        | Valid the Host URL when not signed In |                                                                                            |           | Valid response or status code should be<br>: 200-Ok                            | Response code is 200-OK | Pass   |  |
| MCTC32     | API        | Invalid URL validation                |                                                                                            |           | 400 – The request was not properly formed                                      | Response code is 400    | Pass   |  |
| MCTC33     | API        | Invalid Username and valid Password   | Validate when provided Invalid Username and valid password,we get a corresponding response |           | For Incorrect User details<br>401 – Access denial due to incorrect credentials | Response code is 401    | Pass   |  |

**DB**

| Test Case# | Test Title | Test Summary                          | Test Steps                           | Test Data | Expected Result            							   																	| Actual Result        	  											   | Status | Notes |
| ---------- | ---------- | ------------------------------------- | ------------------------------------ | --------- | ---------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- | ---- | ---- |
| MCTC34 | DATABASE | User ID in Database               | Validate data type                   |  | Check if the User ID is allocated as Primary key with below contraints:Column: userid integer – primary key unique sequence number | User ID is allocated with Primary key with Integer data type        | Pass |  |
| MCTC35 | DATABASE | Username/Passwrod in DB           | Validate data type                   |  | Username and Password should be of String type.                                                                                    | User name and Password are allocated with String type successfully. | Pass |  |
| MCTC36 | DATABASE | Category selection                | Validate Selected Category data type |  | For any selected category, Data type should be "Boolean" with its value as "1" and not selected as "0"                             | Data type for selected category is displayed as "1" successfully.   | Pass |  |
| MCTC37 | DATABASE | Category selection Negative check | Category removal on UI               |  | On successfull removal of prefrence on UI, accordingly changes should be reflected in DB                                           | Changes made on UI are successfully reflected in DB                 | Pass |  |
| MCTC38 | DATABASE | Username deletion                 | Deletion check                       |  | On removal of Username from DB, User should not be able to login on UI                                                             | Successfully cant login when Username is removed                    | Pass |  |
| MCTC39 | DATABASE | Password change                   | Password edit on DB/UI               |  | Any change made on Password either on UI or DB to be updated accordingly.                                                          | Succesful change on password in DB is reflected on UI.              | Pass |  |

### Report 1 - Sprint 2

| Test Case# | Test Title                             | Status | Ran By | Comments |
| ---------- | -------------------------------------- | ------ | ------ | -------- |
| MCTC19     | App URL validation                     | Pass   | Lekha  |          |
| MCTC20     | Application default content validation | Pass   | Lekha  |          |
| MCTC21     | Application default content validation | Pass   | Lekha  |          |
| MCTC22     | Application default content validation | Pass   | Lekha  |          |
| MCTC23     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC24     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC25     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC26     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC27     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC28     | Setting page Validation                | Pass   | Lekha  |          |
| MCTC29     | Setting page Validation                | Fail   | Lekha  |          |
| MCTC30     | API                                    | Pass   | Jaswin |          |
| MCTC31     | API                                    | Pass   | Jaswin |          |
| MCTC32     | API                                    | Pass   | Jaswin |          |
| MCTC33     | API                                    | Pass   | Jaswin |          |
| MCTC34     | DATABASE                               | Pass   | Jaswin |          |
| MCTC35     | DATABASE                               | Pass   | Jaswin |          |
| MCTC36     | DATABASE                               | Pass   | Lekha  |          |
| MCTC37     | DATABASE                               | Pass   | Lekha  |          |
| MCTC38     | DATABASE                               | Pass   | Lekha  |          |
| MCTC39     | DATABASE                               | Pass   | Lekha  |          |

![Report 1 - Sprint 2](/report1sprint2.png)

| Total Test cases | Title                   | Failed | Passed | Not Started |
| ---------------- | ----------------------- | ------ | ------ | ----------- |
| 4                | App URL validation      | 0      | 4      | 0           |
| 7                | Setting page Validation | 1      | 6      | 0           |
| 4                | API                     | 0      | 4      | 0           |
| 6                | Database                | 0      | 6      | 0           |

### JUnit Report - Sprint 2

| TC#  | Test																																					 |      |
| ---- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ---- |
| TC1  | testGetNewsInvalidUser																						                                             | Pass |
| TC2  | testSaveSettingsSuccess                                																						         | Pass |
| TC3  | testSaveSettingsEmptyCategory        																							                         | Pass |
| TC4  | testGetNewsBlankUser                 																						     				         | Pass |
| TC5  | testSaveSettingsInvalidUsername      																						                             | Pass |
| TC6  | testSaveSettingsEmptyUser            																						                  			 | Pass |
| TC7  | testGetNewsBlankCategory             																						                             | Pass |
| TC8  | testGetNewsEmptyUser                 																						                  			 | Pass |
| TC9  | testGetNewsEmptyCategory             																						                          	 | Pass |
| TC10 | testGetNewsSuccess                   																						                     		 | Pass |

![JUnit Report - Sprint 2](/junitreportsprint2.png)

### Test Cases - Sprint 3

| Project Name:    | Minions           | Test Designed by:    | Srilekha S   |
| ---------------- | ----------------- | -------------------- | ------------ |
| Module Name:     | Integration tests | Test Designed date:  | Apr 2nd,2022 |
| Release Version: | V1                | Test Executed by:    | Srilekha S   |
|                  |                   | Test Execution date: | Apr 4th,2022 |

| Pre-condition | Must Successfully Login              |
| ------------- | ------------------------------------ |
| Dependencies: | Testcases from Sprint 1 and Sprint 2 |
| Test Priority |                                      |

**Integration-UI Navigation**

| Test Case# | Test Title                                        | Test Summary                       | Test Steps                                                                   | Test Data                                   | Expected Result                                                                                                                           | Actual Result                                                                                                       | Status | Notes |
| ---------- | ------------------------------------------------- | ---------------------------------- | ---------------------------------------------------------------------------- | ------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------ | ----- |
| MCTC40     | App URL validation                                | Validation of application URL      | Take a valid URL and check if we are landing on homepage                     | [https://newsapi.org](https://newsapi.org/) | We need to navigate to our landing page URL                                                                                               | Successfully navigated to URL                                                                                       | Pass   |       |
| MCTC41     | Modules Integrated on landing page                | Default content validation         | Validate the content integrated on URL when on landing page                  |                                             | App Url should be able to show:<br> list of news articles "tabs" on the landing page with "sign in" link display on right top of the page | Successful display of list of articles on landing page with respective links                                        | Pass   |       |
| MCTC42     | Modules Integrated on Home page                   | Default content validation         | Validate the content integrated on URL when on Home Page                     |                                             | App Url should be able to show:<br> list of news articles "tabs" on the home page with "Username"  displayed on right top of the page     | Successful display of Username and corresponding elements on Home page.                                             | Pass   |       |
| MCTC43     | Verify user account details when login is success | Default content validation         | Validate the elements present on Home page when logged In as particular User |                                             | When  logged in, Username of respective User to be displayed on page<br>                                                                  | "Username' of the User who logged in should be displayed on right top of application                                | Pass   |       |
| MCTC44     | Integration validation on Settings page           | Settings page content validation   | Validate Integration between DB and "Settings" page on Home page             |                                             | When clicked on "Settings"button of respective User , it should display "categories" selected as checked on Settings page                 | The "Categories" which are enabled on DB should be accordingly integrated with Settings page of corresponidng User. | Pass   |       |
| MCTC45     | Integration validation on Settings page           | Settings page content validation   | Validate Integration between DB and "Settings" page on Home page             |                                             | Validate when any change made on Category selection ,it should be reflected accordingly in DB                                             | Changes made by specific User in his account on categories should make necessary changes in DB for his account      | Pass   |       |
| MCTC46     | Modules Integrated on Home page                   | Home and Settings page Integration | Validate Integration between "Home" page and "Settings" page on Home page    |                                             | Validate when selected specific category, the news articles are displayed accordingly on Home page tab                                    | New articiles related to category selection are displayed under "Home" tab                                          |        |       |

**API**

| Test Case# | Test Title                                        | Test Summary                       | Test Steps                                                                   | Test Data                                   | Expected Result                                                                                                                           | Actual Result                                                                                                       | Status | Notes |
| ---------- | ------------------------------------------------- | ---------------------------------- | ---------------------------------------------------------------------------- | ------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------ | ----- |
| MCTC47 | API | Valid the Success response on UI & DB connection               | When on login with valid credentials stored in DB ,Connection should be successfully established         |  | Valid response or status code should be<br>: 200-Ok | Response code is 200-OK | Pass |  |
| MCTC48 | API | Validate success response on "Settings" page and DB connection | When selecting specific category and its reflection in DB, connection should be successfully established |  | Valid response or status code should be<br>: 200-Ok | Response code is 200-OK | Pass |  |

**DB**

| Test Case# | Test Title                                        | Test Summary                       | Test Steps                                                                   | Test Data                                   | Expected Result                                                                                                                           | Actual Result                                                                                                       | Status | Notes |
| ---------- | ------------------------------------------------- | ---------------------------------- | ---------------------------------------------------------------------------- | ------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------ | ----- |
| MCTC49 | DATABASE | Add/Update Validation  | Operation Check                    |  | For every database add/update operation logs should be added.                                    | Results are added successfully to Database                                              | Pass |  |
| MCTC50 | DATABASE | Data Validation        | Validate data type                 |  | Check if the correct data is getting saved in the database upon a successful page submit.        | Category selection is successfully stored in DB                                         | Pass |  |
| MCTC51 | DATABASE | Null Values Validation | Value storage check                |  | Check values for columns that are not accepting null values.                                     | Empty values are not stored in DB                                                       | Pass |  |
| MCTC52 | DATABASE | Data Integrity         | Data Integration between UI and DB |  | Check for data integrity. Data should be stored in single or multiple tables based on the design | Data displayed on UI is match and Integrated successfully with DB values via API calls  | Pass |  |
| MCTC53 | DATABASE | Data Integrity         | Data Integration between UI and DB |  | Check if data is committed to the database only when the operation is successfully completed     | Category selected and when click on "Submit" are enabled accordingly in DB successfully | Pass |  |

**Functional Testcases**

| Test Case# | Test Title                                        | Test Summary                       | Test Steps                                                                   | Test Data                                   | Expected Result                                                                                                                           | Actual Result                                                                                                       | Status | Notes |
| ---------- | ------------------------------------------------- | ---------------------------------- | ---------------------------------------------------------------------------- | ------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------ | ----- |
| MCTC55 | Verify Home page | Modules on landing page                                               | Display home page articles                                                                                                                 |  | All the articles should be displayed on header banner                  | User can successfully see all the articles displayed on ehader banner                           | Pass |  |
| MCTC56 | Verify Home page | Link to filter articles                                               | Articles filtered as:<br>Home  (on by default)<br> General<br> Business<br> Entertainment<br> Health<br> Science<br> Sports<br> Technology |  | All the articles should be displayed as filtered accordingly           | User can successfully see all the articles as filtered as per given filter.                     | Pass |  |
| MCTC57 | Verify Home page | “Home” link will display articles                                     | Display articles from the choosen categories<br>                                                                                           |  | Displays articles from the categories chosen<br>in the settings page   | User can successfully see the articles from the categories that are chosen in the settings page | Pass |  |
| MCTC58 | News API check   | Arrange article categories                                            | Articles arranged in<br>descending order                                                                                                   |  | Descending order displayed with the<br> most recent first              | User can successfully see all the articles displayed as the most recent first                   | Pass |  |
| MCTC59 | News API check   |  Landing page display<br>“Home” link                                  |  Landing page will display<br> articles for the<br>“Home” link                                                                             |  |  Landing page displays articles for the<br>“Home” link upon signing    | Upon signing user can see “Home” link articles                                                  | Pass |  |
| MCTC60 | News API check   | “Home” highlighted                                                    | The currently selected link<br> is highlighted.                                                                                            |  | First signed-in page is highligted                                     | Upon signing the user can the the home page highlited                                           | Pass |  |
| MCTC61 | News API check   | Returns the articles                                                  | Articles returend from  <br>the user’s settings                                                                                            |  | Articles returend are in decending order starting with the most recent | Articles returend sucessfully and in<br> decending order starting with the most recent          | Pass |  |
| MCTC62 | Tabs             | Check if the clicking one tab hides<br>the content of another.        | Current tab hides content of other tabs                                                                                                    |  | When migrating through tabs it hides the content of other tabs         | Sucessfully hide the content of other tabs in current tab                                       | Pass |  |
| MCTC63 | Pagination       | Check the paging 'previous' and 'Next'<br> link status on first page. | When signing in can see the option<br> to select pages.                                                                                    |  | Choose the page where yo wants to go                                   | User can succesfully migrate from one page to another                                           | Pass |  |
| MCTC64 | Pagination       | Check the default count of records<br> per page.                      | The number of pages will be displayed<br>on each page                                                                                      |  | Valid page number displayed on each page                               | Each page Displays a specific number with it.                                                   | Pass |  |
| MCTC65 | Pagination       | Last page does not Display next button                                | When reached to last page,<br> no option to go further.                                                                                    |  | No pages after last page                                               | User could not go beyond the last page.                                                         | Pass |  |

### Report - Sprint 3

| Test Case# | Test Title                                        | Status | Ran By | Comments |
| ---------- | ------------------------------------------------- | ------ | ------ | -------- |
| MCTC40     | App URL validation                                | Pass   | Lekha  |          |
| MCTC41     | Modules Integrated on landing page                | Pass   | Lekha  |          |
| MCTC42     | Modules Integrated on Home page                   | Pass   | Lekha  |          |
| MCTC43     | Verify user account details when login is success | Pass   | Lekha  |          |
| MCTC44     | Integration validation on Settings page           | Pass   | Lekha  |          |
| MCTC45     | Integration validation on Settings page           | Pass   | Lekha  |          |
| MCTC46     | Modules Integrated on Home page                   | Pass   | Lekha  |          |
| MCTC47     | API                                               | Pass   | Lekha  |          |
| MCTC48     | API                                               | Pass   | Lekha  |          |
| MCTC49     | DATABASE                                          | Pass   | Lekha  |          |
| MCTC50     | DATABASE                                          | Pass   | Lekha  |          |
| MCTC51     | DATABASE                                          | Pass   | Lekha  |          |
| MCTC52     | DATABASE                                          | Pass   | Lekha  |          |
| MCTC53     | DATABASE                                          | Pass   | Lekha  |          |
| MCTC54     |                                                   | Pass   | Vikram |          |
| MCTC55     | Verify Home page                                  | Pass   | Vikram |          |
| MCTC56     | Verify Home page                                  | Pass   | Vikram |          |
| MCTC57     | Verify Home page                                  | Pass   | Vikram |          |
| MCTC58     | News API check                                    | Pass   | Vikram |          |
| MCTC59     | News API check                                    | Pass   | Vikram |          |
| MCTC60     | News API check                                    | Pass   | Vikram |          |
| MCTC61     | News API check                                    | Pass   | Vikram |          |
| MCTC62     | Tabs                                              | Pass   | Vikram |          |
| MCTC63     | Pagination                                        | Pass   | Vikram |          |
| MCTC64     | Pagination                                        | Pass   | Vikram |          |
| MCTC65     | Pagination                                        | Pass   | Vikram |          |

![Report 1 - Sprint 3](/report1sprint3.png)

| Total Test cases | Title                                             | Failed | Passed | Not Started |
| ---------------- | ------------------------------------------------- | ------ | ------ | ----------- |
| 1                | App URL validation                                | 0      | 1      | 0           |
| 3                | Modules Integrated on landing page                | 0      | 3      | 0           |
| 1                | Verify user account details when login is success | 0      | 1      | 0           |
| 2                | Integration validation on Settings page           | 0      | 2      | 0           |
| 5                | DATABASE                                          | 0      | 5      | 0           |
| 2                | API                                               | 0      | 2      | 0           |
| 3                | Verify Home page                                  | 0      | 3      | 0           |
| 3                | Pagination                                        | 0      | 3      | 0           |

### Test Cases - Sprint 4

| Project Name:    | Minions           | Test Designed by:    | Srilekha S   |
| ---------------- | ----------------- | -------------------- | ------------ |
| Module Name:     | Integration tests | Test Designed date:  | Apr 2nd,2022 |
| Release Version: | V1                | Test Executed by:    | Srilekha S   |
|                  |                   | Test Execution date: | Apr 4th,2022 |

| Pre-condition | Must Successfully Login                           |
| ------------- | ------------------------------------------------- |
| Dependencies: | Testcases from Sprint 1 and Sprint 2 and Sprint 3 |
| Test Priority |                                                   |

**Functional Cases - Sprint 4**

| Test Case# | Test Title                   | Test Summary                               | Test Steps                                                                              | Test Data | Expected Result                                                                                                                                                 | Actual Result                                                                    | Status | Notes |
| ---------- | ---------------------------- | ------------------------------------------ | --------------------------------------------------------------------------------------- | --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | ------ | ----- |
| MCTC66     | search capability            | Add a textbox for searching on keywords    | Verify the textbox is adding for search option on the landing page                      |           | A serach option with "Magnifying glass" should be displayed on top center of the landing page                                                                   | Search option is displayed.                                                      | Pass   |       |
| MCTC67     | advanced search capabilities | Build support for AND, OR and NOT keywords | Verify the search functionality by including the phrases such as "And" , "OR" and "NOT" |           | When Search with Keywords Such as And/Or/Not , functionality needs to accept it and display results accordingly                                                 | search functionality works as expected and displays the results                  | Pass   |       |
| MCTC68     | advanced search capabilities | Include support for parenthesis            | Verify serach functionality with keywords provided with in parenthesis                  |           | When given search as sport and (Science and technology) , serach functionality should accept both "and" and parrenthesis logic and display results accordingly. | Results are displayed according to the loigc operator provided in the search bar | Pass   |       |
| MCTC69     | search capability            | Default content validation                 | The landing page shall have a text box for entering search                              |           | When on navigating to landing page , it should show a defaults search bar on top center of the page.                                                            | Search bar default displays on landing page even before login                    | Pass   |       |
| MCTC70     | search capability            | Settings page content validation           | The search results will display in descending order starting with                       |           | On seraching for particular keyword, results should be displayed in descending order with timestamp as check.                                                   | Results found are displayed in descending order of timestamp                     | Pass   |       |
| MCTC71     | search capability            | Settings page content validation           | A meaningful message is displayed when are no results to                                |           | When no results are found, page should redirect to text saying "No results found!"                                                                              | Results when not found text saying " no results found" is displayed              | Pass   |       |

**API Validation**

| Test Case# | Test Title        | Test Summary                            | Test Steps                                                         | Test Data | Expected Result                                                                               | Actual Result | Status | Notes |
| ---------- | ----------------- | --------------------------------------- | ------------------------------------------------------------------ | --------- | --------------------------------------------------------------------------------------------- | ------------- | ------ | ----- |
| MCTC72 | API Validation on search | Search response code check | Add a new search endpoint<br> GET<br> /search/{search terms} |  | <br>Status Code<br> 200 – Articles have been returned |  | Pass |  |


**System Test Cases**

| Test Case# | Test Title        | Test Summary                            | Test Steps                                                         | Test Data | Expected Result                                                                               | Actual Result | Status | Notes |
| ---------- | ----------------- | --------------------------------------- | ------------------------------------------------------------------ | --------- | --------------------------------------------------------------------------------------------- | ------------- | ------ | ----- |
| MCTC73 | Recoverability Testing   | Recover check                                 | Ensures that the system can recover from a variety of input mistakes and other failure scenarios.            |  | When user closes the application abruptly, it should not impact his pre-existing changes made on app.          | Data is saved on user profile when closed abruptly.                                          | Pass |  |
| MCTC74 | Interoperability Testing | compatible check                              | Determine whether or not the system is compatible with third-party goods.                                    |  | Intergrating the UI with automation tool and running the scripts                                               | scripts are successfully executed when integreted with 3rd party tool                        | Pass |  |
| MCTC75 | Performance Testing      | performance check                             | Verifying the system's performance in terms of performance characteristics under different conditions.       |  | Adding multiple users to DB and it should impact the performace of portal.                                     | found no performance issues when added multiple registrations                                | Pass |  |
| MCTC76 | Scalability Testing      | scaling check                                 | To ensure that the system can scale in terms such as user scaling, geographic scaling, and resource scaling. |  | Application tested across different platforms should not impact the functionality and look and feel of it.     | application works as expected on different browsers with different resolutions               | Pass |  |
| MCTC77 | Regression Testing       | End to end flow check with new implementation | Ensure the system's stability as it integrates various subsystems and performs maintenance chores            |  | Validating all previous functionality along with new featuers should not break anything.                       | All the previous functionalities are working as expected without impacting the new features. | Pass |  |
| MCTC78 | Exploratory Testing      | Random functionality check                    | Ensure to explore different modules randomly on application to check if ti breaks                            |  | validating the app with exploring different functioanlity and with no proper flow should not break the portal. | Random exploring gave all succesfull results without breaking the application                | Pass |  |

### Report - Sprint 4

| Test Case# | Test Title                   | Status | Ran By | Comments |
| ---------- | ---------------------------- | ------ | ------ | -------- |
| MCTC66     | App URL validation           | Pass   | Lekha  |          |
| MCTC67     | search capability            | Pass   | Lekha  |          |
| MCTC68     | advanced search capabilities | Pass   | Lekha  |          |
| MCTC69     | advanced search capabilities | Pass   | Lekha  |          |
| MCTC70     | search capability            | Pass   | Lekha  |          |
| MCTC71     | search capability            | Pass   | Lekha  |          |
| MCTC72     | search capability            | Pass   | Lekha  |          |
| MCTC73     | Recoverability Testing       | Pass   | Lekha  |          |
| MCTC74     | Interoperability Testing     | Pass   | Lekha  |          |
| MCTC75     | Performance Testing          | Pass   | Lekha  |          |
| MCTC76     | Scalability Testing          | Pass   | Lekha  |          |
| MCTC77     | Regression Testing           | Pass   | Lekha  |          |
| MCTC78     | Exploratory Testing          | Pass   | Lekha  |          |

![Report 1 - Sprint 4](/report1sprint4.png)

| Total Test cases | Title                        | Failed | Passed | Not Started |
| ---------------- | ---------------------------- | ------ | ------ | ----------- |
| 4                | search capability            | 0      | 4      | 0           |
| 2                | advanced search capabilities | 0      | 2      | 0           |
| 1                | API Validation on search     | 0      | 1      | 0           |
| 1                | Recoverability Testing       | 0      | 1      | 0           |
| 1                | Interoperability Testing     | 0      | 1      | 0           |
| 1                | Performance Testing          | 0      | 1      | 0           |
| 1                | Scalability Testing          | 0      | 1      | 0           |
| 1                | Regression Testing           | 0      | 1      | 0           |
| 1                | Exploratory Testing          | 0      | 1      | 0           |