# gradebook_desktop Database

## Start

If you want to create gradebook_desktop database - you must enter this commands in your postgres terminal :

1. Enter to default postgres user

2. Create new user 'gradeuser'

 ```sql
CREATE USER gradeuser PASSWORD '1111';
ALTER ROLE gradeuser createrole createdb;
 ```

3. Go over and select a new 'gradeuser'

4. Navigate to the directory with this file

 ```sql
\cd your_path_to_this_file/Gradebook-desktop/database
 ```

5. Create this database with the command

 ```sql
\ir CreateDatabase.sql
 ```

6. You can now work with the database

## Datalogic model

![datalogic model](https://github.com/BohdanShmalko/Gradebook-desktop/...)