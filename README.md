# Devoir spring boot 
Team : RACHID Othmane & ELFARDI Chaimae
## Etude de cas 1
Le microservice commandes utilise le port 9002 , et contient les opérations CRUD avec 0 ligne SQL. 

- La version (1) de la table « COMMANDE contenant :[id,description, quantité, date, montant]
![Table commande (console h2)](https://github.com/othmanera/Devoir-Spring/assets/105364292/0a9d8686-5524-4f2a-9cc4-0545a3548e36)
- Configuration du microservice-commandes au niveau Spring Cloud et github
![configuration commande dans github](https://github.com/othmanera/Devoir-Spring/assets/105364292/4a9d4d0b-ee6e-4912-a602-2c6d365c8f03)
- Fichier bootstrap.properties du microservice commandes
![bootstrap properties commandes](https://github.com/othmanera/Devoir-Spring/assets/105364292/6b5518e6-f40e-43f6-bd28-bc6fc9dbc314)

- Le Microservice commande utilise les fonctions refresh et health de "Actuator". Si la base de donnée du microservice est vide, le status de Health est "DOWN".
  La fonction responsable : 

![image](https://github.com/othmanera/Devoir-Spring/assets/105364292/643e02a3-896c-4c10-9feb-c4f994e02aa5)

- Les ports du microservice commandes:
  1. localhost:9002/
  2. localhost:9002/h2-console
  3. localhost:9002/Actuator/health
  4. localhost:9002/Commandes

## Etude de cas 2


- La version (2) de la table « COMMANDE contenant :[id,description, quantité, date, montant,id_produit]
![image](https://github.com/othmanera/Devoir-Spring/assets/105364292/4f58728c-9281-4d73-bf74-f84048a26bd5)

- Les microservices produits,commandes et Zuul-server enregistrés auprès d’Eureka
  -> Zuul server est un API Gateway qui est utilisé comme point d’accès unique à l’application
- ![image](https://github.com/othmanera/Devoir-Spring/assets/105364292/c41ddd62-95b1-47be-a31e-0e3095c8e54b)








