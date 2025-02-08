# Todo list with JPA and Docker

This Todo List has a Dockerfile, so you can build the image and run in your PC installing Docker and Git!

## Project Images

![Done tasks](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/main-screen.png)	
![Main screen](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/done-tasks.png)	
![Edit screen](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/edit-screen.png)	

## How to install

1: First of all, you need to have Docker in your PC: https://www.docker.com/products/docker-desktop/

2: And Git too: https://git-scm.com/downloads

3: Open Git and clone the project to your machine: git clone git@github.com:leonardovgds/Todo-list-JPA-DOCKER.git

![git clone](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/git-clone.png)	

4: Open the Docker program.

5: Go to the projects folder in your PC, right click and open with terminal

6: Now, in the terminal, type "docker build -t todolist ."  --> with a dot "." in the end and withot "".

![docker build](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/docker-build.png)	

7: Now, type in the terminal: docker run -p 8080:8080 todolist

![docker run](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/run.png)	

8: When you get this message, your project is running: Started TodoListJpaDockerApplication in 9.494 seconds (process running for 10.854)

![starter](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/running.png)	

9: Finally, open your browser, and in the URL, you type: http://localhost:8080/todos and your done.

![main screen](https://github.com/leonardovgds/Todo-list-JPA-DOCKER/blob/main/images/main-screen.png)	

## Visit My Linkedin
https://www.linkedin.com/in/leonardovgds/
