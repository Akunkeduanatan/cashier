package com.smk.cashier.model;

public class Stok extends Model{
    private int id;
    private String kodeStok;
    private int stokStok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeStok() {
        return kodeStok;
    }

    public void setKodeStok(String kodeStok) {
        this.kodeStok = kodeStok;
    }

    public int getStokStok() {
        return stokStok;
    }

    public void setStokStok(int stokStok) {
        this.stokStok = stokStok;
    }

    @Override
    public String toString() {
        return "Stok{" +
                "id=" + id +
                ", kodeStok='" + kodeStok + '\'' +
                ", stokStok=" + stokStok +
                ", dacreated=" + dacreated +
                ", lastModified=" + lastModified +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
