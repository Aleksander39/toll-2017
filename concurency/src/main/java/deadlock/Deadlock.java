package deadlock;

/**
 * Deadlock в Java-это программная ситуация, когда два или более потоков блокируются навсегда.
 * Ситуация взаимоблокировки Java возникает по крайней мере с двумя потоками и двумя или более ресурсами.
 * Пример по ссылке: https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
