package com.smk.cashier.service;

import com.smk.cashier.model.Stok;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class StokService {
    FileReader stokServiceReader;
    FileWriter stokServiceWriter;

    List<Stok> stokList = new LinkedList<>();
    private static StokService instance = null;

    private StokService() {
        try {
            stokServiceWriter = new FileWriter("stok.txt", true);
            stokServiceReader = new FileReader("stok.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized StokService getInstance() {
        if (instance == null) {
            instance = new StokService();
        }
        return instance;
    }

    private void readFile() {
        BufferedReader bufferedReader = new BufferedReader(stokServiceReader);
        List<String> stringList = bufferedReader.lines().toList();
        stokList.clear();
        for (String string : stringList) {
            stokList.add(parsingLineToStok(string));
        }
    }

    private void writeFile() {
        try {
            stokServiceWriter = new FileWriter("stok.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(stokServiceWriter);
        for (int i = 0; i < stokList.size(); i++) {
            Stok stok = stokList.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(stok.getId());
            sb.append("|");
            sb.append(stok.getKodeBarang());
            sb.append("|");
            sb.append(stok.getStokBarang());
            try {
                bufferedWriter.write(sb.toString());
                if (i < stokList.size() - 1) {
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Stok parsingLineToStok(String string) {
        StringTokenizer st = new StringTokenizer(string, "|");
        int id = 0;
        Stok stok = new Stok();
        while (st.hasMoreElements()) {
            if (id == 0) {
                stok.setId(Integer.parseInt(st.nextToken()));
            } else if (id == 1) {
                stok.setKodeBarang(st.nextToken());
            } else if (id == 2) {
                stok.setStokBarang(Integer.parseInt(st.nextToken()));
            }
            id++;
        }
        return stok;
    }

    public List<Stok> getStokList() {
        readFile();
        return stokList;
    }

    public void addStok(Stok barang) {
        stokList.add(barang);
        writeFile();
    }

    public List<Stok> findByKode(String kode) {
        return stokList.stream()
                .filter(stok -> stok.getKodeBarang().equals(kode))
                .toList();
    }
}
