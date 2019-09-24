# Cracking-the-Coding-Interview

## Java
### Setup
Pull the docker image used to run this code.
```
$ docker pull openjdk
```

Start docker
```
docker run -it -v `pwd`:/root/ -w /root/ openjdk javac ch1/ChapterOne.java
docker run -it -v `pwd`:/root/ -w /root/ openjdk java ch1/ChapterOne
```

## Python
### Setup
Pull the docker image used to run this code.
```
$ docker pull python
```

Start docker
```
docker run -it -v `pwd`:/root/ -w /root/ python:3 python ch1.py
```
