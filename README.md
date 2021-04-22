# Acme Movie Fanatics (AMF)
- Reference specifications : https://drive.google.com/drive/folders/11kzWJelw91YnLpHh_N8XVE4ox0vJ4hVs
- <strong> Requirement for project set up/checkout </strong> :

  - IDE : IntelliJ CE/Ultimate Editions
  - Database : PostgreSQL 12
  - LifeRay : dxp-7.3-sp1
  - Java JDK: Version 11
 
-Instruction : https://docs.google.com/document/d/1l3TQtetkPsuNZsxEzqHLBsfxgBZmUp__Wjijj_Zesm8/edit

Custom Registration features
-Requirement : https://docs.google.com/document/d/1l3TQtetkPsuNZsxEzqHLBsfxgBZmUp__Wjijj_Zesm8/edit
After deploy to the LifeRay server please follow this steps :
  - 1 Edit home page by pressing **pencil** icon
    - Add one container to the current home page
    - Under **Widget** search for _AMFRegistration_ under Sample, then drag and drop in the previous contaner then publish
  - 2 The registration form will be displayed as welcome page
    - fill all the required data
    - Then click Register
  - 3 The new user can login from the defautl login link on the top-right corner of the home page.

When the user login to the liferay, they will see their own profile card, all events, registration, and login history.
