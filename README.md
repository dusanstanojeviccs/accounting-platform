# accounting-platform
EmberJS + Java Spring project for a university course


To start:
1. Load DB:
  Turn on mysqld, log into it and execute the sql file in the root of this repo.
2. Start backend:
  Start tomcat, execute mvn install in the backend folder located in the root of this repo. 
  Put your generated .war file into tomcats webapp directory.
3. Start frontend:
  In terminal go to frontend folder located in the root of this repo and execute "npm install" and "bower install".
  In the same directory start ember locally with request proxying to your tomcat server, example:
  ember serve --proxy http://localhost:8080
4. You are done!



Cheers!
