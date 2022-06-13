# animal-renting-backend
Backend for the Animal Renting project


## Github Commits

Github commits have been carried out in an organized, concise and logical way. When one team member pushes a commit, the other member reviews it and leaves a comment when needed.

However, one problem thah has occured is regarding the deployment on heroku. Because of the breach that happened not long ago and the backend side needs to be deployed manually, it has created some issues when commiting changes. The most occuring error was that a heroku is "1 commit ahead", which was not concurrent and the same on github and heroku. Days of experimenting and trying to figure out the commands on the terminal and this is the instruction for further development:

cd animal-renting-backend

git checkout -b new_branch
git add .
git commit
git push origin new_branch

pull and merge on main in GitHub

git pull
git checkout main

*add a change in backend (e.g add a space between lines, anything simple that does not affect the code but is considered a change)

git add .
git commit
git pull
git push origin main
git push heroku main

This should work and deploy the changes on heroku safely


## Even Emitter

Even Emmiter is a great tool to use and efficient for future utilization because of its scalability. However, sometimes, in the beginnings of a project especially if it is the first project, more complex syntaxes create even more confussion and can hinder further deveopment. For that reason, in some classes, a direct call to the service has been made and the injectiable was used. Once more practice and experience has been gathered, more complex tools will be used in this project.
