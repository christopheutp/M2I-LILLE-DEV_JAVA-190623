FROM ubuntu
LABEL maintainer="mohamed@utopios.net"
RUN apt update 
RUN apt install nginx -y
RUN apt install git -y 
RUN rm -rf /var/www/html
RUN git clone https://gitlab.com/mohamed_formation_test/projet_web.git /var/www/html
EXPOSE 80
CMD ["nginx", "-g","daemon off;"]

