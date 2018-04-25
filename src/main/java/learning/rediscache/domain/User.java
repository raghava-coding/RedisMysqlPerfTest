package learning.rediscache.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_details_bk")
@Data
@NoArgsConstructor
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    private String password;

    private Integer status;
}
