package io.gonzo.middleware.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private AreaCode superAreaCode;

    @OneToMany(mappedBy = "superAreaCode", cascade = CascadeType.ALL)
    private List<AreaCode> subAreaCodeList;

    @Column(columnDefinition = "varchar(255) default 'system'")
    private String createBy;

    @Column(columnDefinition = "datetime default now()")
    private Instant createDate;

}
