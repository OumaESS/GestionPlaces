package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@PrimaryKeyJoinColumn(name = "adminId")
@Table(name = "admin")
public class AdminEntity extends  UseradminEntity implements Serializable {



}
