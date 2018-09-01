package com.example.worldskills.tsppsp.bd;

import android.provider.BaseColumns;

public final class TablaDatos {

    private TablaDatos() {}

    /* Aqui se define los campod de la base de datos */
    public static class LectorEntrada implements BaseColumns {
        public static final String TABLA_NOMBRE = "proyectos";
        public static final String COLUMNA_START = "fechainicio";
        public static final String COLUMNa_INTERRUPCIONES = "interrupciones";
        public static final String COLUMNa_NOMBREPROYECTO = "nombreproyecto";
    }
    public static class LectorEntradaM implements BaseColumns {
        public static final String TABLA_NOMBRE = "proyectos";
        public static final String COLUMNA_START = "fechainicio";
        public static final String COLUMNa_INTERRUPCIONES = "interrupciones";
        public static final String COLUMNa_NOMBREPROYECTO = "nombreproyecto";
    }
}