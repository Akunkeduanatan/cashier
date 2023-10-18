package com.smk.cashier.service;

import com.smk.cashier.dao.StokDao;
import com.smk.cashier.model.Stok;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StokServiceTest {

    @Test
    @Order(1)
    void addStok() {
        // Add your Stok objects here with unique IDs.
        Stok laptop = new Stok();
        laptop.setId(1);
        laptop.setKodeStok("LP001");
        laptop.setStokStok(3);
        StokService.getInstance().addStok(laptop);

        Stok mouse = new Stok();
        mouse.setId(2);
        mouse.setKodeStok("M0001");
        mouse.setStokStok(4);
        StokService.getInstance().addStok(mouse);

        Stok laptopGaming = new Stok();
        laptopGaming.setId(3);
        laptopGaming.setKodeStok("LP002");
        laptopGaming.setStokStok(6);
        StokService.getInstance().addStok(laptopGaming);
    }

    @Test
    @Order(2)
    void getStokList() {
        List<Stok> barangList = StokService.getInstance().getStokList();
        assertEquals(barangList.size(), 3);
    }

    @Test
    @Order(3)
    void findByKode() {
        List<Stok> resultList = StokService.getInstance().findByKode("LP002");
        assertEquals(resultList.size(), 1);
    }

    @Test
    @Order(4)
    void saveStokDatabase() {
        int id = 4; // Start with a new ID
        StokDao stokDao = new StokDao();

        // Create and save Stok objects with unique IDs.
        Stok laptop = new Stok();
        laptop.setId(id++);
        laptop.setKodeStok("LP001");
        laptop.setStokStok(10);
        laptop.setDacreated(new Date());
        laptop.setLastModified(new Date());
        stokDao.save(laptop);

        Stok mouse = new Stok();
        mouse.setId(id++);
        mouse.setKodeStok("MO001");
        mouse.setStokStok(67);
        mouse.setDacreated(new Date());
        mouse.setLastModified(new Date());
        stokDao.save(mouse);

        Stok laptopgaming = new Stok();
        laptopgaming.setId(id);
        laptopgaming.setKodeStok("LP002");
        laptopgaming.setStokStok(5);
        laptopgaming.setDacreated(new Date());
        laptopgaming.setLastModified(new Date());
        stokDao.save(laptopgaming);
    }
}
