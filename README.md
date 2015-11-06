# Walmart-Test
This project is home work for walmart recruitment process
The solution and tests are build and execute entirely via the command line using Maven as the build tool.

To Run the application
-----------------------------
To install Apache Maven on Windows, you just need to download the Maven’s zip file, and Unzip it to the directory you wish to install, and configure the Windows environment variables.

Note
Maven 3.2 requires JDK 1.6 or above, while Maven 3.0/3.1 requires JDK 1.5 or above

1. JDK and JAVA_HOME

Make sure JDK is installed, and “JAVA_HOME” variable is added as Windows environment variable.
install-maven-on-windows-1

2. Download Apache Maven

Visit Maven official website, download the Maven zip file, for example : apache-maven-3.2.2-bin.zip. Unzip it to the folder you want to install Maven.

Assume you unzip to this folder – C:\Program Files\Apache\maven
install-maven-on-windows-2
Note
That’s all, just folders and files, installation is NOT required.

3. Add M2_HOME and MAVEN_HOME

Add both M2_HOME and MAVEN_HOME variables in the Windows environment, and point it to your Maven folder.
install-maven-on-windows-3
M2_HOME or MAVEN_HOME
Maven document said add M2_HOME only, but some programs still reference Maven folder with MAVEN_HOME, so, it’s safer to add both.
4. Add To PATH

Update PATH variable, append Maven bin folder – %M2_HOME%\bin, so that you can run the Maven’s command everywhere.
install-maven-on-windows-4
5. Verification
To verify it, run mvn –version in the command prompt.

6. Download the Project zip file From Github

7. Extract in your directory. Open the Command Prompt and go the project folder .

8. Change your directory where you can find the POM.xml

9 Type the command  'mvn clean install' . This command tells Maven to build all the modules, and to install it in the local repository.  It will create target subdirectory , you should find the build output and the final library or application that was being built.

10 For the testing purpose , JUNit files are in directory src/test/java . To test the project run command
 'mvn test'.
 
 11. To execute the project type command - "mvn exec:java"
 12. Please refer the images  for build and test purpose.
 
 
 If You are using  Eclipse with Maven Plugin, just import as the maven project. POm will download all required files.
 
