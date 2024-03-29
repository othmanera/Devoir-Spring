package com.mcommandes.web.controller;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import com.mcommandes.configurations.ApplicationPropertiesConfiguration;

import com.mcommandes.dao.CommandesDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController implements HealthIndicator{

    @Autowired
    CommandesDao commandesDao;

    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    @PostMapping (value = "/commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){

        Commande nouvelleCommande = commandesDao.save(commande);

        if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }



    // Affiche la liste de toutes les commades disponibles
    @GetMapping(value = "/commandes")
    public List<Commande> listeDesCommandes() {

        System.out.println(" ********* ProductController listeDesProduits() ");

        List<Commande> commandeList = commandesDao.findAll();
        if (commandeList.isEmpty())
            throw new CommandeNotFoundException("Aucun produit n'est disponible à la vente");

        List<Commande> LastCmd = commandeList.subList(0,appProperties.getLastCommandes());
        return LastCmd;
    }




    @GetMapping(value = "/commandes/{id}")
    public Optional<Commande> recupererUneCommande(@PathVariable int id){

        Optional<Commande> commande = commandesDao.findById(id);

        if(!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");

        return commande;
    }





    /*
    * Permet de mettre à jour une commande existante.
    * save() mettra à jours uniquement les champs renseignés dans l'objet commande reçu. Ainsi dans ce cas, comme le champs date dans "commande" n'est
    * pas renseigné, la date précédemment enregistrée restera en place
    **/
    @PutMapping(value = "/commandes")
    public void updateCommande(@RequestBody Commande commande) {

        commandesDao.save(commande);
    }

    public Health health() {

        System.out.println(" *****Actuator : CommandeController health() ");

        List<Commande> products = commandesDao.findAll();
        if (products.isEmpty()) {
            return Health.down().build();
        }
        return Health.up().build();
    }

}

