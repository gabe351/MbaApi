package com.gabea.mbaapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gabea.mbaapi.model.enums.InstrumentEnum;
import com.gabea.mbaapi.model.enums.SituationEnum;
import com.gabea.mbaapi.model.enums.UserTypeEnum;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "instrument")
    private InstrumentEnum instrument;
    @Column(name = "user_type")
    private UserTypeEnum userType;
    @Column(name = "situation")
    private SituationEnum situation;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_associated")
    private boolean isAssociated;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Payment> paymentList = new ArrayList<>();

    public User(Integer id, String name, String email, String password, InstrumentEnum instrument, UserTypeEnum userType,
                SituationEnum situation, boolean isActive, boolean isAssociated, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.instrument = instrument;
        this.userType = userType;
        this.situation = situation;
        this.isActive = isActive;
        this.isAssociated = isAssociated;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public void removePayment(Payment payment) {
        paymentList.remove(payment);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", instrument=" + instrument +
                ", userType=" + userType +
                ", situation=" + situation +
                ", isActive=" + isActive +
                ", isAssociated=" + isAssociated +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
