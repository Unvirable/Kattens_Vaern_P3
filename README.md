# CatApp
## Start the app
To start the backend open src/main/java/com.kattensvaern/KattensVaernApplication and run that file.

## Start the docker database. 
In the terminal run \
docker compose up -d

Shut down database and delete changes made \
docker compose down -v

to see the database in adminer open localhost:8081 \
system : postgresql \
server : db \
brugernavn : cat123 \
kodeord : cat1234 \
database : kattensvaern

## Always work on a branch
Create new branch and switch to it, in the terminal run \
git checkout -b _branch_name_

