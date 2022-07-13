package company.inmobi;

public class JobStats {

    private Integer startTime;
    private Integer endTime;
    private Integer resourceNeeded;

    public JobStats(Integer startTime, Integer endTime, Integer resourceNeeded) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.resourceNeeded = resourceNeeded;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getResourceNeeded() {
        return resourceNeeded;
    }

    public void setResourceNeeded(Integer resourceNeeded) {
        this.resourceNeeded = resourceNeeded;
    }
}
