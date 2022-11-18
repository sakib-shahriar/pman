package com.ssdev.pman.entity;

import com.ssdev.pman.constant.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "created_by")
    @CreatedBy
    private Long createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private Date createdOn;

    @Column(name = "updated_on")
    @LastModifiedDate
    private Date updatedOn;

    @Column(name = "updated_by")
    @LastModifiedBy
    private Long updatedBy;

    private Status status = Status.ACTIVE;

    @Version
    private Long version;
}
