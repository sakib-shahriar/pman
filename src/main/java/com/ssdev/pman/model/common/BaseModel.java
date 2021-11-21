package com.ssdev.pman.model.common;

import com.ssdev.pman.constant.Status;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "updated_by")
    private Long updatedBy;

    private Status status = Status.ACTIVE;

    @Version
    private Long version;
}
