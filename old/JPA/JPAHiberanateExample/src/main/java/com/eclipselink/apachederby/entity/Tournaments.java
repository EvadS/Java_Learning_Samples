package com.eclipselink.apachederby.entity;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "atp_tournaments2")
public class Tournaments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String tournament;

    @ManyToMany(targetEntity = com.eclipselink.apachederby.entity.Players.class, mappedBy = "tournaments")
    private Collection players;

    public Collection getPlayers() {
        return players;
    }

    public void setPlayers(Collection players) {
        this.players = players;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
