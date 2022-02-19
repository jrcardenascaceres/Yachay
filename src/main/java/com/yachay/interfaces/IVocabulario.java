package com.yachay.interfaces;

import com.yachay.model.Vocabulario;
import java.util.List;

public interface IVocabulario {

    List<Vocabulario> obtenerVocabularios(String tipoVocabulario);

    Vocabulario obtenerVocabularioXId(int idVocabulario);
}
