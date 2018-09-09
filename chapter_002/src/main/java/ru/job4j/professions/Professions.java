package ru.job4j.professions;

public class Professions {
    public String name(String name) {
        return name;
    }

    public String profession(String profession) {
        return profession;
    }
}

class Doctor extends Professions {
    public void heal(Patient patient) {
    }
}

class Engineer extends Professions {
    public void build(House house) {
    }
}

class Teacher extends Professions {
    public void teach(Student student) {
    }
}

class Student extends Teacher {
}

class House extends Engineer {
}

class Patient extends Doctor {
}
