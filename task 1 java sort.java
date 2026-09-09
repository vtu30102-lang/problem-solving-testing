class Checker implements java.util.Comparator<Student> {
    public int compare(Student a, Student b) {
        int cgpa = Double.compare(b.getCGPA(), a.getCGPA());
        if (cgpa != 0) return cgpa;

        int name = a.getName().compareTo(b.getName());
        if (name != 0) return name;

        return Integer.compare(a.getID(), b.getID());
    }
}
