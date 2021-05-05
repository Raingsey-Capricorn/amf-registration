# Acme Movie Fanatics (AMF)
Custom Registration features

-Requirement : https://docs.google.com/document/d/1l3TQtetkPsuNZsxEzqHLBsfxgBZmUp__Wjijj_Zesm8/edit

*Phase #1 User Registration*:

After deploy to the LifeRay server please follow this steps :
  - 1 Edit home page by pressing **pencil** icon
    - Add one container to the current home page
    - Under **Widget** search for _AMFRegistration_ under Sample, then drag and drop in the previous contaner then publish
  - 2 The registration form will be displayed as welcome page
    - fill all the required data
    - Then click Register
  - 3 The new user can login from the defautl login link on the top-right corner of the home page.

Disable the built-in sign-up function follow this steps :
  - From the top-right of the screen, click the 9-dots button, then click on the _Control Panel_ then User Groups
    - click on _Instance Settings_ then
    - click on _User Authentication_ then 
      - uncheck **Allow strangers to create accounts?**
      - uncheck **Allow strangers to create accounts with a company email address?**
    - Then here we go

When the user login to the liferay, they will see their own profile card, all events, registration, and login history.


*Phase #2 User Administration*:

  *Create AMF user group*   
  Any user that has been registered in the AMF registration portal, they need to have group so that they can access to the activities panel
  
  Please follow this steps to manage the newly registered user:
  - Login as Administrator in the liferay application:
  - From the top-right of the screen, click the 9-dots button, then click on the _Control Panel_ then User Groups
  - From there, click *Add* button to add new user groups
    - Entitle it as *AMF-Community*
    - Add come description to is like *This group is the membership of AMF online community*
    - Then save it
  - On the newly created group, we want to add all the user who registered from AMF registration form:
    - click on the 3-dot button to *Assign Members*
    - Add all the newly created users to this group
  - Well done we added all the users.
  
  *Create Superuser role for AMF Community:* 
  
  In order to set a role for any user to have privilege to view all other members activities log, we need to follow the steps:
  - Login as Administrator in the liferay application:
  - From the top-right of the screen, click the 9-dots button, then click on the _Control Panel_ then _Roles_
  - From there, 
    - click *Add* button to add new role
      - entitle is as _AMF Superuser_ 
      - describe it as _This role has ability to view other members activities log_
      - last set key it as _AMF_Superuser_
    - click on the 3-dot button to *Permissions* to set permission for the role
      - Under the Role, _AMF Superuser_ then check on the _view_  
      - Then save
    -Assign the role for the user:
      - click the 9-dots button, then click on the _Control Panel_ then _Users and Organizations_
      - edit the user by clicking the **3-dot** button then *Edit* 
      - Under general, go to _Role_ then _REGULAR ROLES_ then we click Select button, then click _Choose_ at the end of _AMF_Superuser_ row
      - We are done assigning the role for the user.
  
  -From the system, when the user login to the AMF liferay portal, he can now see all the activities of other members.
  
  *Phase #3 AMF Members searching:*
  
  When access the liferay AMF system the first page is for the guest to search for any member of AMF Community who lives in the given region that the guest fill in  
  and click the scope icon to search 
    - There are 5 digit representing postalcode
    - There will be available members that match the postal code to be displayed in the list
    - IF there is no, then there will nothing to displayed.
  
  The system has completed it's 3 phase of developments.
  
  Thanks for reading this step-by-step configuration.
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
