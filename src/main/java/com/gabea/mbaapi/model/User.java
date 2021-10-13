package com.gabea.mbaapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gabea.mbaapi.model.enums.InstrumentEnum;
import com.gabea.mbaapi.model.enums.SituationEnum;
import com.gabea.mbaapi.model.enums.UserTypeEnum;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

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


}
