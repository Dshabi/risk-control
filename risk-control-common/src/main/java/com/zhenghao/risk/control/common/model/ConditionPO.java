package com.zhenghao.risk.control.common.model;

import java.io.Serializable;

public class ConditionPO implements Serializable {
    private Long id;

    private String leftCategory;

    private String leftValue;

    private String rightCategory;

    private String rightValue;

    private String comparator;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeftCategory() {
        return leftCategory;
    }

    public void setLeftCategory(String leftCategory) {
        this.leftCategory = leftCategory == null ? null : leftCategory.trim();
    }

    public String getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(String leftValue) {
        this.leftValue = leftValue == null ? null : leftValue.trim();
    }

    public String getRightCategory() {
        return rightCategory;
    }

    public void setRightCategory(String rightCategory) {
        this.rightCategory = rightCategory == null ? null : rightCategory.trim();
    }

    public String getRightValue() {
        return rightValue;
    }

    public void setRightValue(String rightValue) {
        this.rightValue = rightValue == null ? null : rightValue.trim();
    }

    public String getComparator() {
        return comparator;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator == null ? null : comparator.trim();
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
        ConditionPO other = (ConditionPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLeftCategory() == null ? other.getLeftCategory() == null : this.getLeftCategory().equals(other.getLeftCategory()))
            && (this.getLeftValue() == null ? other.getLeftValue() == null : this.getLeftValue().equals(other.getLeftValue()))
            && (this.getRightCategory() == null ? other.getRightCategory() == null : this.getRightCategory().equals(other.getRightCategory()))
            && (this.getRightValue() == null ? other.getRightValue() == null : this.getRightValue().equals(other.getRightValue()))
            && (this.getComparator() == null ? other.getComparator() == null : this.getComparator().equals(other.getComparator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLeftCategory() == null) ? 0 : getLeftCategory().hashCode());
        result = prime * result + ((getLeftValue() == null) ? 0 : getLeftValue().hashCode());
        result = prime * result + ((getRightCategory() == null) ? 0 : getRightCategory().hashCode());
        result = prime * result + ((getRightValue() == null) ? 0 : getRightValue().hashCode());
        result = prime * result + ((getComparator() == null) ? 0 : getComparator().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", leftCategory=").append(leftCategory);
        sb.append(", leftValue=").append(leftValue);
        sb.append(", rightCategory=").append(rightCategory);
        sb.append(", rightValue=").append(rightValue);
        sb.append(", comparator=").append(comparator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}