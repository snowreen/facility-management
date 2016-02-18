package com.facility.management.model.usage;

import java.util.Date;

public class FacilityUseSchedule {

    private int facilityUseScheduleId;
    private int facilityId;
    private Date useStartDateTime;
    private Date useEndDateTime;
    private int customerId;

    public int getFacilityUseScheduleId() {
        return facilityUseScheduleId;
    }

    public void setFacilityUseScheduleId(int facilityUseScheduleId) {
        this.facilityUseScheduleId = facilityUseScheduleId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public Date getUseStartDateTime() {
        return useStartDateTime;
    }

    public void setUseStartDateTime(Date useStartDateTime) {
        this.useStartDateTime = useStartDateTime;
    }

    public Date getUseEndDateTime() {
        return useEndDateTime;
    }

    public void setUseEndDateTime(Date useEndDateTime) {
        this.useEndDateTime = useEndDateTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
