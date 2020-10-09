![Building and publishing the Docker image](https://github.com/AMTeam-Heig/Project_01/workflows/Building%20and%20publishing%20the%20Docker%20image/badge.svg) ![tests](https://github.com/AMTeam-Heig/Project_01/workflows/tests/badge.svg)

## StackOverGoat 
### Objectif
The main goal of this project is to implement a simple version of https://stackoverflow.com/ website :
### How to use 

Github offer the possibility of creating images and save them under the GitHub Container Registry .Using this future we created an image contain both the server (openLiberty) and the application .

First you need to pull the image from the GitHub Container Registry
In the example below the image pulled by its name and the latest version tag:

```bash
docker pull ghcr.io/chickenlivesmatter/stackover-goat/stackovergoat:latest
```
 Once the image was pulled you can run it using the following command :
 
 ```bash
 docker run -p 9090:9080 ghcr.io/chickenlivesmatter/stackover-goat/stackovergoat
 ```

