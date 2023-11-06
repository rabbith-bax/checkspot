package com.checkspot.checkspot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Opinion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long opinionId;
    @OneToOne(cascade = CascadeType.ALL)
    private User issuedBy;
    @Column(nullable = false)
    private Date issuedDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Photo> photos;
    private String content;
    private Price price;
    private int internetRating;
    private int neighbourRating;
    private int neighbourhoodRating;
    private int communicationRating;
}
