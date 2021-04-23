# Acme Movie Fanatics (AMF)
Custom Registration features

-Requirement : https://docs.google.com/document/d/1l3TQtetkPsuNZsxEzqHLBsfxgBZmUp__Wjijj_Zesm8/edit

**Phase #1** *Registration*:

After deploy to the LifeRay server please follow this steps :
  - 1 Edit home page by pressing **pencil** icon
    - Add one container to the current home page
    - Under **Widget** search for _AMFRegistration_ under Sample, then drag and drop in the previous contaner then publish
  - 2 The registration form will be displayed as welcome page
    - fill all the required data
    - Then click Register
  - 3 The new user can login from the defautl login link on the top-right corner of the home page.

When the user login to the liferay, they will see their own profile card, all events, registration, and login history.


**Phase #2** *User Administration*:

  Any user that has been registered in the AMF registration portal, they need to have group so that they can access to the activities panel
  - Please follow this steps to manage the newly registered user:
  - Login as Administrator in the liferay application:
  - From the top-right of the screen, click the 9-dots button, then click on the Control Panel then User Groups
  - From there, click *Add* button to add new user groups
    - Entitle it as *AMF-Community*
    - Add come description to is like *This group is the membership of AMF online community*
    - Then save it
  - On the newly created group, we want to add all the user who registered from AMF registration form:
    - click on the 3-dot button to *Assign Members*
    - Add all the newly created users to this group
  - Well done we added all the users.
 
