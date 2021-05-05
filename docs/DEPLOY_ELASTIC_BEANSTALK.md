# Deploying Java application to AWS Elastic Beanstalk

This document explains how to deploy the demo application to AWS Elastic Beanstalk using AWS Console.

### Step 1

Start by opening the AWS Console and navigate to **Elastic Beanstalk** (use the search bar in the navigation bar). Click on the **Create Application** button to start configuring the web app.

### Step 2

Choose a name for your application, e.g., "workshop-demo". You can leave Application Tags empty. In the **Platform** dropdown menu choose **Java**, for the **Platform branch** choose **Java (Corretto) 11**, and for the **Platform version** choose the **Recommended** option.

### Step 3

For the **Application code** choose **Upload your code**. In the following section fill in the **Version label** with a unique name for the version of your application code, e.g., "1.0.0". For the **Source code origin** choose **Local file** and upload the generated `.war` file. This file should be located inside of
your project in the `/target` folder.

### Step 4

Click on **Create application** and wait until the application is created. This can take a couple of minutes.

### Step 5

When the application is ready click on **Configuration**, and **Edit** in the Database row. Here you can configure a managed RDS Database for your application.
Choose one of the engines (for the workshop we will use **postgres**), fill in the **Username** and **Password** fields and leave all other fields with their
default values. Do not set your Username to _admin_ as it is a reserved user and database creation would fail.

Make sure that the **Instance class** is set to **db.t2.micro**. When everything is configured click on **Apply**. Database creation will
take a couple of minutes again.

### Step 6

When Elastic Beanstalk finishes with resource creations, in your AWS Console navigate to RDS service (In the navigation menu use the search bar and open the RDS in a new tab). On the left navigation menu click on **Databases** (under Dashboard) and you should see one instance of the database we just created. Click on the DB Identifier and copy the endpoint (e.g., bbpovxui5t2wjv.cwfniba4nd10.us-east-1.rds.amazonaws.com) — we will need it in the following step.

### Step 7

Now we need to tell our application how to connect to the database. In the Elastic Beanstalk menu, click on **<your-application>-env** and **Configuration**. In the Configuration tab click on the **Edit** button in the **Software** row. On the bottom of the page add the following environment variables (properties). Don't forget to use your values instead of values inside of `< >`.

```
SPRING_DATASOURCE_URL=jdbc:postgresql://<database-endpoint>/postgres
SPRING_DATASOURCE_USERNAME=<username>
SPRING_DATASOURCE_PASSWORD=<password>
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
SERVER_PORT=5000
```

The final result should look something like this

```
SPRING_DATASOURCE_URL=jdbc:postgresql://bbpovxui5t2wjv.cwfniba4nd10.us-east-1.rds.amazonaws.com/postgres
SPRING_DATASOURCE_USERNAME=workshop
SPRING_DATASOURCE_PASSWORD=mypassword
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
SERVER_PORT=5000
```

Apply your changes by clicking on the **Apply** button.

### Step 8

Your application should be ready to go! Test it out by clicking on the **Go to environment** option in the left navigation menu, or by directly openning the application's endpoint.
