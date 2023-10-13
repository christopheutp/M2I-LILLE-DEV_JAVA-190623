## Demo volumes

### Créer un volume et l'utiliser avec 2 machines : **


- docker volume create share- docker volume ls
- docker run -itd --name=ubuntu1 -v share:/tmp ubuntu
- docker exec -it ubuntu1 bash
-> cd tmp/
-> ls
-> echo "coucou" >> fichier.txt
- docker run -itd --name=ubuntu2 -v share:/tmp ubuntu
- docker exec -it ubuntu2 bash
-> cd tmp
-> cat fichier.txt
- docker stop $(docker ps -aq) && docker rm $(docker ps -aq)
- docker run -itd --name=ubuntu3 -v share:/tmp ubuntu
- docker exec -it ubuntu3 bash
- cd tmp
- ls

 ### Volume en local (volume lié): 


- git clone https://gitlab.com/mohamed_formation_test/projet_web.git
- docker run -d --name demo-web -p 80:80 -v /Users/mohamed/Documents/formation/Docker/Docker/projet_web:/usr/local/apache2/htdocs/ httpd
- changement de la page en local