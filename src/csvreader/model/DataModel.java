package csvreader.model;


import javafx.beans.property.SimpleStringProperty;


public class DataModel {

    private final SimpleStringProperty orderDate, region, rep1, rep2, item, units, unitCost, total;


    public DataModel(String orderDate, String region, String rep1, String rep2, String item, String units, String unitCost, String total) {
        this.orderDate = new SimpleStringProperty(orderDate);
        this.region = new SimpleStringProperty(region);
        this.rep1 = new SimpleStringProperty(rep1);
        this.rep2 = new SimpleStringProperty(rep2);
        this.item = new SimpleStringProperty(item);
        this.units = new SimpleStringProperty(units);
        this.unitCost = new SimpleStringProperty(unitCost);
        this.total = new SimpleStringProperty(total);
    }


    public String getOrderDate() {
        return orderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }

    public String getRegion() {
        return region.get();
    }

    public SimpleStringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getRep1() {
        return rep1.get();
    }

    public SimpleStringProperty rep1Property() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1.set(rep1);
    }

    public String getRep2() {
        return rep2.get();
    }

    public SimpleStringProperty rep2Property() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2.set(rep2);
    }

    public String getItem() {
        return item.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public String getUnits() {
        return units.get();
    }

    public SimpleStringProperty unitsProperty() {
        return units;
    }

    public void setUnits(String units) {
        this.units.set(units);
    }

    public String getUnitCost() {
        return unitCost.get();
    }

    public SimpleStringProperty unitCostProperty() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost.set(unitCost);
    }

    public String getTotal() {
        return total.get();
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }


}
