package am.tk.bd;

import java.util.ArrayList;
import java.util.HashMap;

public class Orders {
    String order_no;
    String sku;
    String sku_desc;
    String bin_code;
    String pending_quantity;
    HashMap<String,String> lots;

    public Orders(String order_no) {

    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku_desc() {
        return sku_desc;
    }

    public void setSku_desc(String sku_desc) {
        this.sku_desc = sku_desc;
    }

    public String getBin_code() {
        return bin_code;
    }

    public void setBin_code(String bin_code) {
        this.bin_code = bin_code;
    }

    public String getPending_quantity() {
        return pending_quantity;
    }

    public void setPending_quantity(String pending_quantity) {
        this.pending_quantity = pending_quantity;
    }

    public HashMap<String, String> getLots() {
        return lots;
    }

    public void setLots(HashMap<String,String> lots) {
        this.lots = lots;
    }

    public Orders(String order_no, String sku, String sku_desc, String bin_code, String pending_quantity, HashMap<String,String> lots) {
        this.order_no = order_no;
        this.sku = sku;
        this.sku_desc = sku_desc;
        this.bin_code = bin_code;
        this.pending_quantity = pending_quantity;
        this.lots = lots;
    }
}
