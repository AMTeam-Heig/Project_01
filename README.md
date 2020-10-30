![Building and publishing the Docker image](https://github.com/AMTeam-Heig/Project_01/workflows/Building%20and%20publishing%20the%20Docker%20image/badge.svg) ![tests](https://github.com/AMTeam-Heig/Project_01/workflows/tests/badge.svg)

<p align="center">
  <img width="200" height="200" src=src/main/webapp/assets/img/goat.png>
</p> 
 
### Objectif
The main goal of this project is to implement a simple version of [stack overflow](https://stackoverflow.com/) website :

### Quick start

It is realy simple to use our application, all you need is to clone the project and run the script :

First clone the project 
```bash
git clone git@github.com:AMTeam-Heig/Project_01.git
```
Then execute  the script to start the application :
```bash
./start.sh
```

The application can be used over the image in the GitHub Container Registry. That offers the possibility of creating images and saving them under the GitHub Container Registry. Using this feature we created an image containing both the server (openLiberty) and the application.
All you need to test it is to run this script : 
 ```bash
docker run 9080:9080 ghcr.io/amteam-heig/project_01/stackover-goat/stackovergoat:latest
 ```

_Team : [Clarisse Fleurimont](https://github.com/Stellucidam), [Baptiste Hardrick](https://github.com/batach31), [Elodie Lagier](https://github.com/CosmicElodie) and [Walid Massaoudi](https://github.com/ChickenLivesMatter)_
