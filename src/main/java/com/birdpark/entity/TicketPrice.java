package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter 
@Getter

@Entity
@Table(name = "ticketprice")
public class TicketPrice {
    
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "bird_park_id")
    private Integer birdParkId;

    @Column(name="ticket_type")
    private String ticketType;

    @Column(name="price")
    private BigDecimal price;

    public TicketPrice() {
    }


    public TicketPrice(Integer id, 
        Integer birdParkId, 
        String ticketType, 
        BigDecimal price) {
        this.id = id;
        this.birdParkId = birdParkId;
        this.ticketType = ticketType;
        this.price = price;
    }
}
