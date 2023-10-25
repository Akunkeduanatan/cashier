package com.smk.cashier.dao;

import com.smk.cashier.model.Stok;

import java.sql.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class StokDao implements Dao<Stok, Integer> {
    private final Optional<Connection> conn;

    public StokDao() {
        conn = JdbcConnection.getConnection();
    }

    @Override
    public Optional<Stok> get(int id) {
        return conn.flatMap(c -> {
            Optional<Stok> stok = Optional.empty();

            String query = "SELECT * FROM stok WHERE id = ?;";
            try {
                PreparedStatement ps = c.prepareStatement(query);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int stokId = rs.getInt("id");
                    String kode = rs.getString("kode");
                    int stokNum = rs.getInt("stok");

                    Stok result = new Stok();
                    result.setId(stokId);
                    result.setKodeStok(kode);
                    result.setStokStok(stokNum);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return stok;
        });
    }

    @Override
    public Collection<Stok> getAll() {
        return null;
    }

    @Override
    public Optional<Integer> save(Stok stok) {
        Stok nonNullB = Objects.requireNonNull(stok);
        String query = "INSERT INTO stok(kode, stok, last_modified, updated_by, created_by, date_created) "+
                "VALUES(?, ?, ?, ?, ?, ?, ?);";

        return conn.flatMap(c -> {
            Optional<Integer> generatedID = Optional.empty();
            try {
                PreparedStatement ps = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, stok.getKodeStok());
                ps.setInt(2, stok.getStokStok());
                ps.setDate(4, new Date(stok.getLastModified().getTime()));
                ps.setString(5, stok.getUpdatedBy());
                ps.setString(6, stok.getCreatedBy());
                ps.setDate(7, new Date(stok.getDacreated().getTime()));

                int numberOfInsertedRows = ps.executeUpdate();
                if (numberOfInsertedRows > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        generatedID = Optional.of(rs.getInt(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return generatedID;
        });
    }

    @Override
    public void update(Stok stok) {

    }

    @Override
    public void delete(Stok stok) {

    }
}