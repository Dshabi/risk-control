package com.zhenghao.risk.control.common.model;

import java.io.Serializable;

public class RulePO implements Serializable {
    private Long id;

    private String name;

    private String description;

    private String logicMode;

    private String relConditionIds;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLogicMode() {
        return logicMode;
    }

    public void setLogicMode(String logicMode) {
        this.logicMode = logicMode == null ? null : logicMode.trim();
    }

    public String getRelConditionIds() {
        return relConditionIds;
    }

    public void setRelConditionIds(String relConditionIds) {
        this.relConditionIds = relConditionIds == null ? null : relConditionIds.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RulePO other = (RulePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLogicMode() == null ? other.getLogicMode() == null : this.getLogicMode().equals(other.getLogicMode()))
            && (this.getRelConditionIds() == null ? other.getRelConditionIds() == null : this.getRelConditionIds().equals(other.getRelConditionIds()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLogicMode() == null) ? 0 : getLogicMode().hashCode());
        result = prime * result + ((getRelConditionIds() == null) ? 0 : getRelConditionIds().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", logicMode=").append(logicMode);
        sb.append(", relConditionIds=").append(relConditionIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}