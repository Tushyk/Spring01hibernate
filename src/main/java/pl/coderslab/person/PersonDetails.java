package pl.coderslab.person;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name = "person_details")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private Long streetNumber;
    private String street;
    private String city;
}
