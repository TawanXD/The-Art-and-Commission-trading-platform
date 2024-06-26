package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    String signname;
    String image;
    String Portforiolink;
    String username;
    String password;
    String Bankaccount;
    String Banknum;
    String BankName;

    @Builder.Default
    @OneToMany
    List<Customer> adviseeList = new ArrayList<>();
}