package org.test.leverx.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "profileName", "firstName", "lastName", "created"})
@XmlRootElement
public class Profile {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String profileName;
    @Getter
    @Setter
    private Date created;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;

    public Profile(long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }
}
