

<p align="center">
  <img width="200" height="200" src=src/main/webapp/assets/img/goat-title.png>
</p> 



![Building and publishing the Docker image](https://github.com/AMTeam-Heig/Project_01/workflows/Building%20and%20publishing%20the%20Docker%20image/badge.svg) ![tests](https://github.com/AMTeam-Heig/Project_01/workflows/tests/badge.svg)

 
### Objectif
The main goal of this project is to implement a simple version of https://stackoverflow.com/ website :

### Quick start

Is realy simple to use our ,you just need to clone the project and run the script :

First clone the project 
```bash
git clone git@github.com:AMTeam-Heig/Project_01.git
```
Then execute  the script to start the application :
```bash
./start.sh
```

The application can be used over the image in the GitHub Container Registry that offer the possibility of creating images and save them under the GitHub Container Registry .Using this future we created an image contain both the server (openLiberty) and the application .
 All you need is to run this : 
 ```bash
ghcr.io/amteam-heig/project_01/stackover-goat/stackovergoat:latest
 ```
