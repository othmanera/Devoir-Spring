package com.mcommandes.configurations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("mes-config-ms")
@RefreshScope
public class ApplicationPropertiesConfiguration {
    // correspond à la propriété « mes-config-ms.commandes-last » dans le fichier de configuration du MS
    private int LastCommandes;
    public int getLastCommandes() {
        return LastCommandes;
    }
    public void setLastCommandes(int LastCommandes) {
        this.LastCommandes = LastCommandes;
    }
}