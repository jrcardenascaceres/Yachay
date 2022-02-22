package com.yachay.dao;

import com.yachay.interfaces.IVocabulario;
import com.yachay.model.Respuesta;
import com.yachay.model.Vocabulario;
import com.yachay.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoVocabulario implements IVocabulario {

    private static ConnectionDB cdb;
    private static PreparedStatement ps = null;
    private static CallableStatement cs = null;
    private static ResultSet rs = null;

    public DaoVocabulario() {
        cdb = ConnectionDB.newInstance();
    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (cdb != null) {
                cdb.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion :" + e.getMessage());
        }
    }

    @Override
    public List<Vocabulario> obtenerVocabularios(String tipoVocabulario) {
        List<Vocabulario> vocabularios = new ArrayList();
        try {
            String sql = "SELECT ID_VOCABULARIO, COD_VOCABULARIO, VOCABULARIO, DESCRIPCION, IMG_SENIA FROM DBINCLUSION.vocabulario WHERE TIPO = ? ORDER BY ID_VOCABULARIO ASC;";
            ps = cdb.getConnection().prepareStatement(sql);
            ps.setString(1, tipoVocabulario);
            rs = ps.executeQuery();
            Vocabulario v;
            while (rs.next()) {
                v = new Vocabulario();
                v.setIdVocabulario(rs.getInt(1));
                v.setCodVocabulario(rs.getString(2));
                v.setVocabulario(rs.getString(3));
                v.setDescripcion(rs.getString(4));
                v.setImgSenia(rs.getString(5));
                vocabularios.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return vocabularios;
    }

    @Override
    public Vocabulario obtenerVocabularioXId(int idVocabulario) {
        Vocabulario v = new Vocabulario();
        Respuesta r = new Respuesta();
        try {
            String sql = "SELECT COD_VOCABULARIO, VOCABULARIO, DESCRIPCION, IMG_SENIA FROM DBINCLUSION.vocabulario WHERE ESTADO = 'A' AND ID_VOCABULARIO = ?;";
            ps = cdb.getConnection().prepareStatement(sql);
            ps.setInt(1, idVocabulario);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setIdVocabulario(idVocabulario);
                v.setCodVocabulario(rs.getString(1));
                v.setVocabulario(rs.getString(2));
                v.setDescripcion(rs.getString(3));
                v.setImgSenia(rs.getString(4));
                r.setEstado(true);
                r.setMensaje("Vocabulario encontrado.");
                r.setTipo("success");
            } else {
                r.setMensaje("El vacabulario no existe.");
                r.setTipo("warn");
            }
        } catch (SQLException e) {
            r.setMensaje(e.getMessage());
            r.setTipo("error");
        } finally {
            close();
        }
        v.setRespuesta(r);
        return v;
    }

}
