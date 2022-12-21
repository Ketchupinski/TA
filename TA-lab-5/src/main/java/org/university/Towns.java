package org.university;

public enum Towns {
    LUZK(1, "Луцьк"),
    SHATSK(2, "Шацьк"),
    KOVEL(3, "Ковель"),
    VOLODYMIR_VOLINSKIY(4, "Володимир-Волинський"),
    ROZISHCHE(5, "Рожище"),
    KIVERTSI(6, "Ківерці"),
    LUBETCHIV(7, "Любечів"),
    TURIYSK(8, "Турійськ"),
    MANEVYSHI(9, "Маневичі"),
    KAMIN_KASHIRSKIY(10, "Камінь-Каширський"),
    RATNE(11, "Ратне"),
    LUBOMIL(12, "Лубомиль");


    private final int id;
    private final String name;

    Towns(int i, String n) {
        this.id = i;
        this.name = n;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Towns getTownById(int id) {
        for (Towns t : Towns.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public static int getTownIdByName(String name) {
        for (Towns t : Towns.values()) {
            if (t.name().equals(name)) {
                return t.getId();
            }
        }
        return 0;
    }

    public static String getTownNameById(int id) {
        for (Towns t : Towns.values()) {
            if (t.getId() == id) {
                return t.getName();
            }
        }
        return null;
    }


}
