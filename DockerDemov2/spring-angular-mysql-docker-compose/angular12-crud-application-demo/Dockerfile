# FROM node:12 as builder

# WORKDIR /app

# COPY angular12-crud-application-demo/package.json  .
# COPY angular12-crud-application-demo/package-lock.json .
# RUN npm install
# COPY angular12-crud-application-demo/ .
# RUN npm run build --prod

# FROM nginx:alpine
# COPY --from=builder app/dist/angular12-crud-application-demo usr/share/nginx/html
# COPY --from=builder nginx.conf /etc/nginx/nginx.conf
# EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]

# Étape 1: Construction de l'application Angular
FROM node:12 as builder

WORKDIR /app

COPY angular12-crud-application-demo/package.json  .
COPY angular12-crud-application-demo/package-lock.json .
RUN npm install
COPY angular12-crud-application-demo/ .
RUN npm run build --prod

# Étape 2: Configuration du serveur Nginx
FROM nginx:alpine
COPY --from=builder /app/dist/angular12-crud-application-demo /usr/share/nginx/html
COPY --from=builder /app/nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

