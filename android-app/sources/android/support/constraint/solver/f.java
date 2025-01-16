package android.support.constraint.solver;

final class f {

    interface a<T> {
        T acquire();

        void b(T[] tArr, int i);

        boolean release(T t);
    }

    static class b<T> implements a<T> {
        private final Object[] cW = new Object[256];
        private int cX;

        b() {
        }

        public final T acquire() {
            if (this.cX <= 0) {
                return null;
            }
            int i = this.cX - 1;
            T t = this.cW[i];
            this.cW[i] = null;
            this.cX--;
            return t;
        }

        public final boolean release(T t) {
            if (this.cX >= 256) {
                return false;
            }
            this.cW[this.cX] = t;
            this.cX++;
            return true;
        }

        public final void b(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.cX < 256) {
                    this.cW[this.cX] = t;
                    this.cX++;
                }
            }
        }
    }
}
