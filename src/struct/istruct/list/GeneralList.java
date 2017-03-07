public interface GeneralList<L> {
    void remove();
    void goNext();
    void goPrev();
    void goTo(int n);
    L getActual();
    int getPosActual();
    int size();
    boolean isVoid();
    boolean endList();
    GeneralList<L> clone();
}
