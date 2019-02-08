package com.thinkincode.utils.database;

/**
 * Represents a row within the output of an "EXPLAIN QUERY PLAN" command.
 */
public class QueryPlanRow {

    private final int selectId;
    private final int order;
    private final int from;
    private final String detail;

    /**
     * Constructor.
     */
    public QueryPlanRow(int selectId, int order, int from, String detail) {
        this.selectId = selectId;
        this.order = order;
        this.from = from;
        this.detail = detail;
    }

    public int getSelectId() {
        return selectId;
    }

    public int getOrder() {
        return order;
    }

    public int getFrom() {
        return from;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryPlanRow queryPlanRow = (QueryPlanRow) o;

        if (selectId != queryPlanRow.selectId) return false;
        if (order != queryPlanRow.order) return false;
        if (from != queryPlanRow.from) return false;
        return detail != null ? detail.equals(queryPlanRow.detail) : queryPlanRow.detail == null;

    }

    @Override
    public int hashCode() {
        int result = selectId;
        result = 31 * result + order;
        result = 31 * result + from;
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QueryPlanRow{" +
                "selectId=" + selectId +
                ", order=" + order +
                ", from=" + from +
                ", detail='" + detail + '\'' +
                '}';
    }
}
