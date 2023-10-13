# Demonstration réseau Docker 

### Créer un réseau + y placer 2 containers + faire communiquer ces containers (ping) + les deconnecter du réseau + les reconnecter à un autre réseau.

- docker network create --driver <DRIVER TYPE> <NETWORK NAME>
- docker network create --driver bridge mon-bridge
- docker network ls
- docker network inspect mon-bridge
- docker run -dit --name alpine1 --network mon-bridge alpine
- docker run -dit --name alpine2 --network mon-bridge alpine
- docker network inspect mon-bridge
- docker exec alpine1 ping -c 1 172.21.0.3
- docker exec alpine2 ping -c 1 172.21.0.2
- docker network disconnect mon-bridge alpine1
- docker network disconnect mon-bridge alpine2
- docker exec alpine1 ip a
- docker network rm mon-bridge
- docker network connect bridge alpine1
- docker network connect bridge alpine2