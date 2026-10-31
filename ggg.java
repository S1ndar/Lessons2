//public class ggg {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Divan {
//    private final int id;
//    private final int dd;
//
//    public Divan(int i, int m) {
//        this.id = i;
//        this.dd = m;
//    }
//
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (obj != null && this.getClass() == obj.getClass()) {
//            Divan d = (Divan)obj;
//            return this.id == d.id && Objects.equals(this.dd, d.dd);
//        } else {
//            return false;
//        }
//    }
//
//    public int hashCode() {
//        return Objects.hash(new Object[]{this.dd, this.id});
//    }
//
//    public int compareTo(Divan o) {
//        return this.dd.compareTo(o.dd);
//    }
//}
