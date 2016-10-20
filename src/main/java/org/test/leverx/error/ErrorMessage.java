package org.test.leverx.error;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aliaksandr.vashyna on 10/20/2016.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ErrorMessage {
    @Getter
    @Setter
    private String message;
}
