package io.gonzo.middleware.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "area_code")
public class AreaCode {

    @Id
    private Long id;

    @Column(name = "area_code")
    private String code;

    @Column(name = "area_name")
    private String name;

    @Column(name = "area_type")
    private String type;

    private String createBy;

    private Instant createDate;

}
