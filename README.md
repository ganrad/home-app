home-app: A JEE JAX-RS application for managing all personal activities.
========================
Author: Ganesh Radhakrishnan  
Technologies: CDI, JPA, EJB, JAX-RS, BV  
Summary: The `home-app` is a Java EE 6 web-enabled database application that uses CDI, EJB, JPA and Bean Validation.  
Target Product: JBoss EAP  
Source: <https://github.com/ganrad/home-app/>  

What is it?
-----------

System requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 6.1 or later. 

All you need to build this project is Java 7.0 (Java SDK 1.7) or later, Maven 3.0 or later.

 
Configure Maven
---------------

[Configure Maven](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN.md#configure-maven-to-build-and-deploy-the-quickstarts) before proceeding with next steps.


Use of EAP_HOME
---------------

In the following instructions, replace `EAP_HOME` with the actual path to your JBoss EAP 6/7 installation.


Start the JBoss EAP Server
-------------------------

1. Open a command prompt and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server:

        For Linux:   EAP_HOME/bin/standalone.sh
        For Windows: EAP_HOME\bin\standalone.bat

 
Build and Deploy this Application
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy JBoss EAP Quickstarts](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/BUILD_AND_DEPLOY.md#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this application.
3. Type this command to build and deploy the archive:

        mvn clean install jboss-as:deploy

4. This will deploy `target/home-app.war` to the running instance of the server.
 

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/home-app/>.  In OpenShift, the application URL will be based on the **service**, **project** and **DNS** names created while deploying the application. 


Server Log: Expected warnings and errors
-----------------------------------

_Note:_ You will see the following warnings in the server log. You can ignore these warnings.

    JBAS010489: -ds.xml file deployments are deprecated. Support may be removed in a future version.

    HHH000431: Unable to determine H2 database version, certain features may not work


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this application
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the application in Red Hat JBoss Developer Studio or Eclipse 
-------------------------------------

Run the application in OpenShift Container Platform 
------------------------------------- 

   
